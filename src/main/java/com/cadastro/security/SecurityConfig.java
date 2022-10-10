package com.cadastro.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/auth")
		.usernameParameter("username").passwordParameter("password").permitAll() 
		.and()
		.authorizeRequests()
			.antMatchers("/").authenticated()
		.and()
			.logout()
			.permitAll();
		 http.csrf().disable();
	     	return http.build();
	}
	
/*	@Autowired
	protected void configureGlobal (AuthenticationManagerBuilder auth) throws Exception {
		 auth.inMemoryAuthentication().withUser("admin").password("system2022").roles("ADMIN").and()
			.withUser("dev").password("system2022").roles("ADMIN");
	
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}
	
	 @Bean
	 protected UserDetailsService userDetailsService() {
	        UserDetails user1 = User
	                .withUsername("admin")
	                .password("$2a$12$EJjoM7q/XkXAXLNdy/mfIeAYeQekF8gqzAFu2CriFwV/rA0J39uwW")
	                .roles("USER")
	                .build();
	        return new InMemoryUserDetailsManager(user1);
	    }
	 
	 
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedMethods("*");
	    }

}
