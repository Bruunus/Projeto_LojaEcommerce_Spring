package br.com.ecommerce.mvc.bigu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	
	/**
	 * Método spring de configuração de autorizção de usuário
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
			.authorizeRequests()
				.anyRequest().authenticated()
			.and()
				.formLogin(form -> form
		            .loginPage("/login")
		            .permitAll()
		        );
	}
	
	
	/**
	 * Método spring de autenticação de usuário.
	 */
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("brunus")
				.password("brunus")
				.roles("ADM")
				.build();

		return new InMemoryUserDetailsManager(user);
	}
	
	
	
	
	
	
	
}
