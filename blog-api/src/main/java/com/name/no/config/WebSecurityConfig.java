package com.name.no.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests().anyRequest().fullyAuthenticated().and().
//    httpBasic().and().
//    csrf().disable();
	  http
	  .formLogin()
		.defaultSuccessUrl("/api/user/comments")
		.permitAll()
		.and()
	  .csrf().disable()
      .authorizeRequests()
      .antMatchers("/api/blog/**").permitAll()
      .antMatchers("/api/user/**").fullyAuthenticated().and().httpBasic()
      .and()
	.httpBasic()
		.and()
	.logout()
  .logoutSuccessUrl("/")
		.invalidateHttpSession(true)
		.deleteCookies("JSESSIONID");
	  ;
  }
  
  
}
