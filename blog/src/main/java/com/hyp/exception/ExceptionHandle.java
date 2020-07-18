package com.hyp.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @ProjectName blog
 * @ClassName ExceptionHandle
 * @create 2020-07-08 11:30
 * @Author by hyp
 */
@ControllerAdvice
public class ExceptionHandle {

    private final Logger logger=LoggerFactory.getLogger(this.getClass());

    public ModelAndView exceptionHandle(HttpServletRequest request,Exception e) throws Exception {
        logger.error("Request URL : {}, Exception : {}", request.getRequestURI(), e);
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null) {
            throw e;
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", request.getRequestURL());
        mv.addObject("exception", e);
        mv.setViewName("error/error");
        return mv;
    }
}
