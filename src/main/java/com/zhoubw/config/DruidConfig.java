//package com.zhoubw.config;
//
//
//import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import javax.servlet.Servlet;
//
//@Configuration
//public class DruidConfig {
//
//    @Bean
//    public ServletRegistrationBean statViewServlet() {
//        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(StatViewServlet(), "/druid/*");
//        // 添加IP白名单
//        servletRegistrationBean.addInitParameter("allow", "");
//        // 添加IP黑名单，当白名单和黑名单重复时，黑名单优先级更高
////        servletRegistrationBean.addInitParameter("deny", "192.168.25.123");
//        // 添加控制台管理用户
//        servletRegistrationBean.addInitParameter("loginUsername", "druid");
//        servletRegistrationBean.addInitParameter("loginPassword", "123456");
//        // 是否能够重置数据
//        servletRegistrationBean.addInitParameter("resetEnable", "false");
//        return servletRegistrationBean;
//
//    }
//
//}