package com.name.no.config;

import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
 
  @Override
  protected void configure(HttpSecurity http) throws Exception {
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
		.deleteCookies("JSESSIONID")
	  .and()
	  	.sessionManagement().maximumSessions(1).sessionRegistry(sessionRegistry())
	  ;
  }
  
  @Bean
  public SessionRegistry sessionRegistry() {
      return new SessionRegistryImpl();
  }
  
  @Bean
  public ServletListenerRegistrationBean<HttpSessionEventPublisher> httpSessionEventPublisher() {
      return new ServletListenerRegistrationBean<HttpSessionEventPublisher>(new HttpSessionEventPublisher());
  }
  
}
