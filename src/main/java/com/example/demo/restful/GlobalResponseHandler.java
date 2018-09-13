package com.example.demo.restful;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @Description
 * @Author huqifeng
 * @Date 2018/09/13 15:46
 */
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        final String returnTypeName = returnType.getParameterType().getName();
        return !"com.example.demo.restful.GlobalResponse".equals(returnTypeName) && !"org.springframework.http.ResponseEntity".equals(returnTypeName);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        final String returnTypeName = returnType.getParameterType().getName();
        if ("void".equals(returnTypeName)) {
            return GlobalResponse.success(null);
        }
        if (!selectedContentType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }
        if ("com.example.demo.restful.GlobalResponse".equals(returnTypeName)) {
            return body;
        }
        return GlobalResponse.success(body);
    }


}
