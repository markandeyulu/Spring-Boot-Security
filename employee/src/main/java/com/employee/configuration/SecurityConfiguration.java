package com.employee.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	/*
	 * @Bean PasswordEncoder getEncoder() { return new BCryptPasswordEncoder(); }
	 */
	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		
		http.authorizeRequests()
		.antMatchers("/getUserName").permitAll() // permitall and no URL given here - both are same. 
		.antMatchers("/getPassword").hasRole("ADMIN")
		.antMatchers("/getClientId").hasRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()// we can give customised form as well
		.and()
		.csrf().disable()
		.exceptionHandling()
		.accessDeniedHandler(accessDeniedHandler);
		
	}
	/*
	 * @Autowired PasswordEncoder passwordEncoder;
	 */
	
	// it will redirect to login page for authentication for the given URLs with non permitAll.
	// If we give incorrect username pwd, it will throw bad credential. 
	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * PasswordEncoder encoder =
	 * PasswordEncoderFactories.createDelegatingPasswordEncoder();
	 * 
	 * 
	 * auth.inMemoryAuthentication()
	 * .withUser("manoj").password(encoder.encode("manojpwd")).roles("ADMIN") // we
	 * can use {noop}manojpwd as well if we dint want to encode the pwd. .and()
	 * .withUser("mark").password(encoder.encode("markpwd")).roles("USER") .and()
	 * .withUser("testuser").password(encoder.encode("testpwd")).roles("TEMP"); }
	 */
	
	// JDBC based auth
	/*
	 * auth.jdbcAuthentication() .dataSource(dataSource)
	 * .usersByUsernameQuery(userbyUsernameQuery)
	 * .authoritiesByUsernameQuery(rolebyUsernameQuery)
	 * .passwordEncoder(passwordEncoder());
	 */
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		
		auth.inMemoryAuthentication()/* .passwordEncoder(encoder) */
		.withUser("manoj").password(encoder.encode("manojpwd")).roles("ADMIN") // we can use {noop}manojpwd as well if we dint want to encode the pwd. 
		.and()
		.withUser("mark").password(encoder.encode("markpwd")).roles("USER")
		.and()
		.withUser("testuser").password(encoder.encode("testpwd")).roles("TEMP");
	}
}
