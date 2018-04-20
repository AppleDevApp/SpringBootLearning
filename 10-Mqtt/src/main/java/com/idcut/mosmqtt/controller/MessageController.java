package com.idcut.mosmqtt.controller;

import com.idcut.mosmqtt.domain.PlatformPayload;
import com.idcut.mosmqtt.entity.*;
import com.idcut.mosmqtt.platform.ProtocolMsg;
import com.idcut.mosmqtt.pusher.EventPublisher;
import com.idcut.mosmqtt.pusher.MqttPublisher;
import com.idcut.mosmqtt.service.TokenValidateService;
import com.idcut.mosmqtt.util.JsonUtil;
import com.idcut.mosmqtt.util.ProtocolMsgUtil;
import com.idcut.mosmqtt.util.UniqueId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class MessageController {

    @Autowired
    private MqttPublisher mqttPublisher;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private TokenValidateService tokenValidateService;

    @Autowired
    private EventPublisher eventBus;

    @RequestMapping(value = "/")
    public String index() throws Exception {
        ReplyMessageBody replyBody = new ReplyMessageBody();
        replyBody.setMessage("服务推送消息");
        replyBody.setMsgBody("Ok");
        replyBody.setMsgDate(new Date());
        replyBody.setStatus(200);
        replyBody.setMsgOp("UserIn");

        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("roomId", 10086);
        bodyMap.put("msgFrom", "liujianhui");
        bodyMap.put("token", "JqFv3RxThnNM1bOIwPgs81TwOU+KCjMX7Dj2Z6f6mxopbKQcRkkEHcnVILZmePI09JwuusvIwAmgb3nuvo3wy3LHyqrTxhO5idfLgFHqlcJkk\\/\\/5EvukdFOuuuUKnd6FtiZ2vahCp3+FP\\/aeuEvtwyjU5R5Pa523");
        bodyMap.put("revId", "TranId:dfa44e3d-64a7-4130-b9a8-cb2b562a2877");

        ProtocolMsg msg = new ProtocolMsg();
        msg.getHeader().setRequest_id(UniqueId.getLongId().toString());
        msg.getExtensionHeader().setService("iot/chatRoom/UserIn");
        msg.setBody(JsonUtil.toJson(bodyMap));
        byte[] payloadByte = ProtocolMsgUtil.messageToByte(msg);
        String payload = encodeMsg(payloadByte);

        byte[] payloadNow = payload.getBytes("ISO-8859-1");
        ProtocolMsg msgNow = ProtocolMsgUtil.byteToMessage(payloadByte);
        ProtocolMsg msgNow2 = ProtocolMsgUtil.byteToMessage(payloadNow);

        MsgSendWorker worker = new MsgSendWorker(payloadNow, "");
        eventBus.sendMsg(worker);
        //mqttPublisher.sendMsg(payload, "iot/chatRoom/UserIn");

        return "Hello";
    }

    @RequestMapping(value = "/userin")
    public String userin() throws Exception {
        for (int i = 0; i < 3; i++) {
            PlatformPayload<ChatUserEntryBody> payloadData = new PlatformPayload();
            payloadData.setRevId("iot/chatRoom/PrintMessage/" + i);
            payloadData.setToken("Unknown");

            ChatUserEntryBody body = new ChatUserEntryBody();
            body.setMsgFrom("测试者");
            body.setMsgTo("");
            body.setMsgType(1);
            body.setRoomId("10086");
            body.setContent("");

            payloadData.setMsgBody(body);

            ProtocolMsg msg = new ProtocolMsg();
            msg.getHeader().setRequest_id(UniqueId.getLongId().toString());
            msg.getExtensionHeader().setService("iot/chatRoom/UserIn");
            msg.setBody(JsonUtil.toJson(payloadData));
            byte[] payloadByte = ProtocolMsgUtil.messageToByte(msg);
            //mqttPublisher.sendMsgByte(payloadByte, "iot/chatRoom/UserIn");
            MsgSendWorker worker = new MsgSendWorker(payloadByte, "iot/chatRoom/UserIn");
            eventBus.sendMsg(worker);
        }

        return "Hello";
    }

    @RequestMapping(value = "/userout")
    public String userout() throws Exception {
        PlatformPayload<ChatUserLeaveBody> payloadData = new PlatformPayload();
        payloadData.setRevId("iot/msg/listener/local");
        payloadData.setToken("Unknown");

        ChatUserLeaveBody body = new ChatUserLeaveBody();
        body.setMsgFrom("测试者");
        body.setMsgTo("");
        body.setMsgType(1);
        body.setRoomId("10086");
        body.setContent("");

        payloadData.setMsgBody(body);

        ProtocolMsg msg = new ProtocolMsg();
        msg.getHeader().setRequest_id(UniqueId.getLongId().toString());
        msg.getExtensionHeader().setService("iot/chatRoom/UserOut");
        msg.setBody(JsonUtil.toJson(payloadData));
        byte[] payloadByte = ProtocolMsgUtil.messageToByte(msg);
        mqttPublisher.sendMsgByte(payloadByte, "iot/chatRoom/UserOut");

        return "Hello";
    }

    @RequestMapping(value = "/sendmsg")
    public String sendmsg() throws Exception {
        PlatformPayload<ChatUserTalkBody> payloadData = new PlatformPayload();
        payloadData.setRevId("iot/msg/listener/local");
        payloadData.setToken("Unknown");

        ChatUserTalkBody body = new ChatUserTalkBody();
        body.setMsgFrom("测试者");
        body.setMsgTo("");
        body.setMsgType(1);
        body.setRoomId("10086");
        body.setContent("聊天聊天");

        payloadData.setMsgBody(body);

        ProtocolMsg msg = new ProtocolMsg();
        msg.getHeader().setRequest_id(UniqueId.getLongId().toString());
        msg.getExtensionHeader().setService("iot/chatRoom/SendMsg");
        msg.setBody(JsonUtil.toJson(payloadData));
        byte[] payloadByte = ProtocolMsgUtil.messageToByte(msg);
        mqttPublisher.sendMsgByte(payloadByte, "iot/chatRoom/SendMsg");

        return "Hello";
    }

    @RequestMapping(value = "/redis")
    public String testRedis() {
        String value = redisTemplate.opsForValue().get("Hello");
        log.info("Redis Value:{}", value);
        redisTemplate.opsForValue().set("Hello", "OK");
        return "OK Redis";
    }

    @RequestMapping(value = "/token")
    public String testToken() {

        tokenValidateService.validate("OOOOO");
        return "OK Token";
    }


    private String encodeMsg(byte[] payloadByte) {
        try {
            return new String(payloadByte, "ISO-8859-1");
        } catch (Exception ex) {
            log.error("Encode Msg Failed:{}", ex);
        }

        return "";
    }
}
