package com.kamakuni.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/login").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/authenticate")
			.defaultSuccessUrl("/todos")
			.failureUrl("/login?error")
		.usernameParameter("email")
		.passwordParameter("password")
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login")
		.deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("email").password("{noop}password").roles("USER")
		.and()
			.withUser("admin").password("{noop}admin").roles("ADMIN");
			//.credentialsExpired(true).accountExpired(true).accountLocked(true)
			//.authorities("WRITE_PRIVILEGES", "READ_PRIVILEGES").roles("ADMIN");
	}
}
