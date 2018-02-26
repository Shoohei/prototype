package com.fnsystems.prototype.mvc;

import org.springframework.context.annotation.Configuration;

// TRO : The security is temporary disabled

@Configuration
//@EnableWebSecurity
public class WebSecurityConfig{ 
//	extends WebSecurityConfigurerAdapter {
}
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//            .authorizeRequests()
//                .antMatchers("/", "/resources/static/**", "/home", "/events", "/addevent").permitAll()
//                .anyRequest().authenticated()
//                .and()
//            .formLogin()
//                .loginPage("/login")
//                .permitAll()
//                .and()
//            .logout()
//                .permitAll();
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//            .inMemoryAuthentication()
//                .withUser("user").password("pwd").roles("USER");
//    }
//}