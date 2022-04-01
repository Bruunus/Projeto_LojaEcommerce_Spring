package br.com.ecommerce.mvc.bigu.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

	
	@Autowired		// notação utilizada para realização de injeção de dependência do spring. Reconhece automaticamente uma injeção
	private PedidoRepository pedidoRepository;
	
	
	
	
	/**
	 * Método que recebe requisição GET	com prefixo home.
	 * Estabelece conexão direta com banco de dados executando
	 * consulta personalizada para carregar a lista de pedidos
	 * por usuário. Recebe objeto Principal como parâmetro para
	 * injetar o nome do usuário em que está logado na sessão atual.
	 * O model na qual trabalha com UI (Interface de Usuário) chama o 
	 * despachador addAtributte informando um nome e passando o 
	 * objeto que o método retornará para a home para exibir os dados
	 * buscados.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("pedido")
	public String home(Model model, Principal principal) {		
		List<Pedido> pedidos = pedidoRepository.findByUsuario(principal.getName());		// conexão com banco de dados
		model.addAttribute("pedidos", pedidos);	
		return "usuario/home";
	}
	
	
	
	
	/**
	 * Controller redirecionador para links internos da página home.
	 * Este método é chamado dependendo da URL que for chamada, e ao ser 
	 * invocado realiza uma busca no banco de dados para listar os
	 * dados do usuário pelo status do produto pelo vínculo com o usuário.
	 * A referência para o valor no @GetMapping é aquele que
	 * recebe o nome de status, e vem através do request. Na assinatura 
	 * do método foi especificado pelo spring que seja adicionado na 
	 * variável status vinda da URL da request própriamente na variável 
	 * String status.
	 * 
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("pedido/{status}")
	public String porStatus(@PathVariable("status")String status, Model model, Principal principal) {		
		List<Pedido> pedidos = pedidoRepository.findByStatusEUsuario(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
		model.addAttribute("pedidos", pedidos);	
		model.addAttribute("status", status);
		return "usuario/home"; 
	}
	
	
	
	
	/**
	 * Tratamento de erro do método 'porStatus' caso ele não consiga atender a requisição.
	 * @return - Página home da aplicação
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuario/home";
	}
	
	
	
	
}
