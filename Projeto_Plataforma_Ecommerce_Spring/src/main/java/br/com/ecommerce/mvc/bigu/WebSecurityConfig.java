package br.com.ecommerce.mvc.bigu;

import javax.sql.DataSource;

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
	private DataSource dataSource;
	
	
	
	/**
	 * Método spring de configuração de autorizção de usuário.
	 * Invocado o método formLogin para configurar o caminho da
	 * requisição, e, caso a autenticação estiver de acordo é 
	 * redirecionado para a página home através do metodo defaultSuccessUrl.
	 * Configurado o encerramento de sessão através do método logout fazendo 
	 * o redirecionamento configurado na view e desabilitado o modo cfrf (cross-site request forgery)  
	 * do Spring para evitar erro de redirecionamento pelo mecanismo interno do Spring.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		
			.authorizeRequests()
			.antMatchers("/home/**")	
				.permitAll()
			
			.anyRequest().authenticated()
			.and()
				.formLogin(form -> form
		            .loginPage("/login")
		            .defaultSuccessUrl("/usuario/pedido", true)
		            .permitAll()
		        )
			.logout(logout -> logout.logoutUrl("/logout")
					.logoutSuccessUrl("/home"))
			.csrf().disable();
			
	}
	
	
	/*
	 * Método proposital para informar ao spring security que as autenticações
	 * serão feitas através do JDBC. Criado um objeto BCryptPasswordEncoder
	 * para criptografar as senhas no banco de dados, utilizando o recurso
	 * UserDetails para já subir a aplicação criando um usuário no bando e já 
	 * com senha criptografada e configuração da AuthenticationManagerBuilder
	 * do objeto auth que realiza as configurações de acesso ao bando via
	 * JDBC e configurações de encriptação de senhas.
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
		auth
		.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(encoder);
 
	}
	
	
	
	
}
