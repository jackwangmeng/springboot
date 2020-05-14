package com.wm.springboot.component;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public class MyErrorAttributes extends DefaultErrorAttributes {

    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);
        errorAttributes.put("private","wangmeng");

        Map<String,Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        errorAttributes.put("ext",ext);
        return errorAttributes;
    }
}
