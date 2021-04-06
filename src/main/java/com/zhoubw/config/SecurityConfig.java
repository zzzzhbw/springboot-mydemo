package com.zhoubw.config;

import com.zhoubw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/druid/*");
        http.authorizeRequests()
//                .antMatchers("/login","classpath:/**").permitAll()
                .antMatchers("/login","/bootstrap/**","/images/*","/assets/*","/vendors/*","/druid/*").permitAll()
                .antMatchers("/*").hasRole("USER");

        http.formLogin().loginPage("/login").defaultSuccessUrl("/index").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
                .and()
                .rememberMe().tokenValiditySeconds(1209600)
                .tokenRepository(persistentTokenRepository()).userDetailsService(userService);

        http.sessionManagement().maximumSessions(1).expiredUrl("/login");
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().dataSource(dataSource).withDefaultSchema();
//    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl persistentTokenRepository = new JdbcTokenRepositoryImpl();
        // 将 DataSource 设置到 PersistentTokenRepository
        persistentTokenRepository.setDataSource(dataSource);
        // 第一次启动的时候自动建表（可以不用这句话，自己手动建表，源码中有语句的）
        // persistentTokenRepository.setCreateTableOnStartup(true);
        return persistentTokenRepository;
    }
}
