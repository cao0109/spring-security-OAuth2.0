package com.caoh2.security.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * 对应web.xml中ContextLoaderListener的配置
 */
@Configuration //相当于applicationContext.xml文件
@ComponentScan(basePackages = "com.caoh2.security",
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = Controller.class)})
public class ApplicationConfig {
}
