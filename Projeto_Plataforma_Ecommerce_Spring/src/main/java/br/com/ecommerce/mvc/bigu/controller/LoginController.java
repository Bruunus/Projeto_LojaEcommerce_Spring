package br.com.ecommerce.mvc.bigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	
	/**
	 * Método que utilizado para controlar as requisições get/post 
	 * para autenticação.
	 * @return redirecionamento para página de login
	 */
	@GetMapping
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
}
