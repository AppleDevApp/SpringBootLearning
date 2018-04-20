package com.idcut.mosmqtt.service;

import com.idcut.mosmqtt.constant.StatusCode;
import com.idcut.mosmqtt.entity.TokenValidateResult;
import com.idcut.mosmqtt.entity.TopicMeta;
import com.idcut.mosmqtt.event.SystemResponseEvent;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import com.idcut.mosmqtt.util.HttpUtil;
import com.idcut.mosmqtt.util.JsonUtil;
import com.idcut.mosmqtt.util.UniqueId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class TokenValidateService {

    @Value("${token.validateUrl}")
    private String validateUrl;

    public TokenValidateResult validate(String token) {
        Map<String, Object> param = new HashMap<>();
        param.put("reqid", UniqueId.getLongId());
        param.put("access_token", token);

        String rspJson = HttpUtil.postJson(validateUrl, param);
        TokenValidateResult result = null;
        if (StringUtils.hasText(rspJson)) {
            result = JsonUtil.fromJson(rspJson, TokenValidateResult.class);
        }

        if (result == null) {
            result = new TokenValidateResult();
            result.setCode(StatusCode.FAILED);
            result.setMsg("Validate Token Failed");
        } else if (result.getCode().equals(10001)) {
            result.setCode(StatusCode.SUCCESS);
        }

        return result;
    }

    public SystemResponseEvent validateWithResult(Message<ProtocolMsg> message, TopicMeta meta, String revId, String token) {
        SystemResponseEvent rspEvent = new SystemResponseEvent();
        rspEvent.setMsgId(UniqueId.getLongId().toString());
        rspEvent.setReqId(message.getPayload().getHeader().getRequest_id());
        rspEvent.setService(message.getPayload().getExtensionHeader().getService());
        rspEvent.setUserTopic(revId);
        rspEvent.setMsgOp(meta.getOperate());

        TokenValidateResult validResult = validate(token);
        if (validResult == null || !validResult.getCode().equals(StatusCode.SUCCESS)) {
            //notice
            rspEvent.setStatus(StatusCode.FAILED);
            rspEvent.setMessage("验证Token失效");
        } else {
            rspEvent.setStatus(StatusCode.SUCCESS);
            rspEvent.setMessage("成功");
        }

        rspEvent.setMsgDate(new Date());
        return rspEvent;
    }
}
