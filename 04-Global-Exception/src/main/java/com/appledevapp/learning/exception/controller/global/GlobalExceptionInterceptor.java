package com.appledevapp.learning.exception.controller.global;

import com.appledevapp.learning.exception.base.ErrorInfo;
import com.appledevapp.learning.exception.exception.MarkedException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 控制器增强方法 - 全局异常控制处理
 */
@ControllerAdvice
public class GlobalExceptionInterceptor {

    private static final Log log = LogFactory.getLog(GlobalExceptionInterceptor.class);

    /**
     * 全局默认异常处理
     *
     * @param request
     * @param ex
     * @return
     * @throws Exception
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception ex) throws Exception {
        //异常写入日志
        log.error("Global Exception:", ex);

        //响应定制错误视图
        ModelAndView modelView = new ModelAndView();
        modelView.addObject("exception", ex);
        modelView.addObject("url", request.getRequestURL());
        modelView.setViewName("error");
        return modelView;
    }

    /**
     * 已标记异常，以JSON形式返回
     *
     * @param request
     * @param ex
     * @return
     * @throws Exception
     */
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = MarkedException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, MarkedException ex) throws Exception {
        //异常写入日志
        log.error("Marked Exception:", ex);

        ErrorInfo<String> err = new ErrorInfo<>();
        err.setMessage(ex.getMessage());
        err.setCode(ErrorInfo.FAILED);
        err.setData("Invalid Handle State");
        err.setUrl(request.getRequestURL().toString());
        return err;
    }

}
