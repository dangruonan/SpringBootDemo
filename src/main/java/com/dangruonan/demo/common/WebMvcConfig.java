package com.dangruonan.demo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

//拦截器
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private DemoInterceptor demoInterceptor;

//    配置静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
    }
//    添加拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
//        .excludePathPatterns("/dangruonan/login");
    }

//    解决中文乱码问题
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        converters.add(messageConverter());
    }
    @Bean
    public HttpMessageConverter<String> messageConverter(){
        return new StringHttpMessageConverter(Charset.forName("UTF-8"));
    }
}
