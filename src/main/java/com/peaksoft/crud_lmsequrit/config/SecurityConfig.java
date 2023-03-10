package com.peaksoft.crud_lmsequrit.config;

import com.peaksoft.crud_lmsequrit.service.impl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public DaoAuthenticationProvider provider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf()
                .disable().authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/users").hasAuthority("ADMIN")
                .antMatchers("users/saveUser").hasAuthority("ADMIN")
                .antMatchers("users/save").hasAuthority("ADMIN")
                .antMatchers("/companies/**").hasAuthority("ADMIN")
                .antMatchers("/teachers/**").hasAuthority("ADMIN")
                .antMatchers("/users/profile").hasAnyAuthority("ADMIN","INSTRUCTOR","USER")
                .antMatchers("/groups").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/students").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/courses").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/courses/updateCourse/{id}").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/groups/updateGroup/{id}").hasAnyAuthority("ADMIN","INSTRUCTOR")
                .antMatchers("/courses/delete/{id}").hasAuthority("ADMIN")
                .antMatchers("/groups/delete/{id}").hasAuthority("ADMIN")
                .antMatchers("/students/addStudent").hasAuthority("ADMIN")
                .antMatchers("/students/updateStudent/{id}").hasAuthority("ADMIN")
                .antMatchers("/students/delete/{id}").hasAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/login").permitAll();
    }


}
