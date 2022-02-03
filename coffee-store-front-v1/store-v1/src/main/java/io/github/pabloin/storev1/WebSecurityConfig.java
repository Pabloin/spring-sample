package io.github.pabloin.storev1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/*.html").permitAll()                 // Publico Estático
				.antMatchers("/", "/home", "/hello").permitAll()    // Publico Home
				.anyRequest().authenticated()                       // Privado: El resto
				.and()
			.formLogin()
				.loginPage("/login").permitAll()                    // Login & logout - son publicos
				.and()
			.logout()
				.permitAll();
	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		UserBuilder users = User.withDefaultPasswordEncoder();
		
		UserDetails user = users
			.username("manager")
			.password("hidden")
			.roles("USER")
			.build();

		UserDetails admin = users
			.username("admin")
			.password("password")
			.roles("USER", "ADMIN")
			.build();

		return new InMemoryUserDetailsManager(user, admin);
	}
}


