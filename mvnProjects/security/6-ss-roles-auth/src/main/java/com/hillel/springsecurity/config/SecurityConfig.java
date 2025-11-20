package com.hillel.springsecurity.config;

import com.hillel.springsecurity.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers(HttpMethod.GET, "/api/v1/ping").permitAll()

//                .antMatchers(HttpMethod.GET, "/api/v1/dev/**").hasAnyRole(Role.USER.name(), Role.ADMIN.name())
//                .antMatchers(HttpMethod.POST, "api/v1/dev").hasRole(Role.ADMIN.name())
//                .antMatchers(HttpMethod.DELETE, "api/v1/dev/**").hasRole( Role.ADMIN.name())

                .antMatchers("/api/v1/dev/**").authenticated()
                .antMatchers(HttpMethod.POST, "api/v1/dev").authenticated()

                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder().username("user")
                        .password(passwordEncoder().encode("user"))
                        .roles(Role.USER.name())
                        .build(),
                User.builder().username("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles(Role.ADMIN.name())
                        .build()

        );
    }

    @Bean
    protected PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(12);
    }
}
