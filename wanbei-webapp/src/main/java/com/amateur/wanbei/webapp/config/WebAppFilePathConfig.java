package com.amateur.wanbei.webapp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by chenhaitao on 2018/6/13.
 */
@Configuration
public class WebAppFilePathConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/temp/**")
     .addResourceLocations("file:/Users/chenhaitao/Desktop/temp/");
     super.addResourceHandlers(registry);
     }
}
