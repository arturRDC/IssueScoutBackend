package com.arturrdc.issuescoutbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        String rootPath = Paths.get("").toAbsolutePath().toString();
        registry.addResourceHandler("/files/avatars/**")
                .addResourceLocations("file:/" + rootPath + "/files/avatars/")
                .setCacheControl(CacheControl.noCache());
    }
}