package com.zdotavv.enterprise_homework13.configurations;

import com.zdotavv.enterprise_homework13.service.interfaces.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersonService personService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] antMatchersForAdmin = {"/product/all", "/shop/all", "/person/create", "/person/delete",
                "/person/all","/person/update",  "/product/create","/product/get", "/product/delete", "/product/update",  "/shop/create","/shop/get","/shop/add",
                "/shop/delete", "/cart/create", "/cart/delete", "/cart/get", "/cart/add",
                "/cart/remove", "/cart/clean","/cart/all"};
        String[] antMatchersForCustomer = {"/product/all", "/shop/all",
                "/cart/create", "/cart/delete", "/cart/get", "/cart/add", "/cart/remove", "/cart/clean",
                "/cart/update"};
        http.headers().frameOptions().disable();
        http.csrf()
                .disable()
                .authorizeRequests()
                .antMatchers("/mainIndex").permitAll()
                .antMatchers("/registration").permitAll()
                .antMatchers("/shop/all").permitAll()
                .antMatchers("/product/all").permitAll()
                .antMatchers(antMatchersForAdmin).hasRole("ADMIN")
                .antMatchers(antMatchersForCustomer).hasAnyRole("ADMIN", "CUSTOMER")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/mainIndex")
                .permitAll()
                .and()
                .logout()
                .permitAll()
                .logoutSuccessUrl("/login");
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(personService).passwordEncoder(passwordEncoder);
    }
}
