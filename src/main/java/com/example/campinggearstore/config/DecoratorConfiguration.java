package com.example.campinggearstore.config;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.servlet.Filter;
import java.util.Arrays;

import static javax.servlet.DispatcherType.*;

@Configuration
public class DecoratorConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public InternalResourceViewResolver setupViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public FilterRegistrationBean siteMeshFilter() {
        FilterRegistrationBean filter = new FilterRegistrationBean();

        //Set các path decorator ở đây
        Filter siteMeshFilter = new SiteMeshFilterBuilder()
            .addDecoratorPath("/*", "/decorators/web.jsp")
            .addDecoratorPath("/admin*", "/decorators/admin.jsp")
            .addExcludedPath("/api*")
            .setIncludeErrorPages(true)
            .create();
        filter.setFilter(siteMeshFilter);
        filter.setUrlPatterns(Arrays.asList("/*"));
        filter.setDispatcherTypes(REQUEST, FORWARD,ERROR, INCLUDE);
        return filter;
    }
}
