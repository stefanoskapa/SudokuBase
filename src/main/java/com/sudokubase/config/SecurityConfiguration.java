package com.sudokubase.config;

import javax.servlet.Filter;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT username,password,enabled "
                        + "FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username,roles.role "
                        + "FROM users,roles WHERE username = ? AND users.role=roles.id");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/dashboard").hasAnyRole("ADMIN", "USER")
                .antMatchers("/play").hasAnyRole("ADMIN", "USER")
                .antMatchers("/check/**").permitAll()
                .antMatchers("/check").permitAll()
                .antMatchers("/history").hasAnyRole("ADMIN", "USER")
                .antMatchers("/profile").hasAnyRole("ADMIN", "USER")
                .antMatchers("/puzzle").permitAll()
                .antMatchers("/confirm-account").permitAll()
                .antMatchers("/policy").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/dashboard", true)
                .loginProcessingUrl("/auth")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login");

    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public Filter httpsEnforcerFilter() {
        return new HttpsEnforcer();
    }

}
