package com.alunoTurma.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
			http.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/aluno/")
					.authenticated()
					)
					.httpBasic();
			return http.build();
			
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("yasmin")
				.password("12345678")
				.build();
		return new InMemoryUserDetailsManager(user);
	}

}
