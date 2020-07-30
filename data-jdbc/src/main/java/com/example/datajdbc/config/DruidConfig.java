package com.example.datajdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletRegistration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置druid监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> iniParams = new HashMap<>();
        iniParams.put("loginUsername","admin");
        iniParams.put("loginPassword","123456");
        iniParams.put("allow","");
        //iniParams.put("deny","192.268.2.622");
        registrationBean.setInitParameters(iniParams);
        return registrationBean;
    }

    //2、配置一个Web监控的Filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());

        Map<String,String> iniParams = new HashMap<>();
        iniParams.put("exclusions","*.css,*.js,/druid/*");

        bean.setInitParameters(iniParams);
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}
