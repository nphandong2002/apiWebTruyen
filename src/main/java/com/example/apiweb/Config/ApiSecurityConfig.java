package com.example.apiweb.Config;

import com.example.apiweb.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ApiSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userSevice;
    @Autowired
    JwtAuthenticationEntryPoint JwtAuthenticationEntryPoint;
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws  Exception{
        auth.userDetailsService(userSevice).passwordEncoder(passwordEncoder());
    }
    @Bean
    public AuthenticationFilter authenticationFilter(){
        return new AuthenticationFilter();
    }
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws  Exception{
        return  super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues());
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/api/**").hasAnyAuthority("user","admin","qtv")
                .antMatchers("/", "/api/login", "/api/logout","/api/register","/api/category/","/img/**","/*.jpg").permitAll()

                .anyRequest().authenticated()
                .and().logout().logoutUrl("/api/logout")
                .and()
                    .formLogin()
                    .disable()


                .exceptionHandling().authenticationEntryPoint(JwtAuthenticationEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);

    }
}
