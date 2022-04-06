package br.com.ecommerce.mvc.bigu.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;


@Controller  
@RequestMapping("/home")
public class HomeController  {
 
	@Autowired		
	private PedidoRepository pedidoRepository;
	
	
	
	/**
	 * Método que recebe requisição GET	com prefixo home.
	 * Estabelece conexão direta com banco de dados executando
	 * consulta personalizada para carregar a lista de todos
	 * os pedidos usando paginação com PageRequest (qtd de páginas, 
	 * qtd de ítens na página) e em ordem da data do pedido 
	 * utilizando o sort. Injetar o nome do usuário em que está 
	 * logado na sessão atual. O model na qual trabalha 
	 * com UI (Interface de Usuário) chama o despachador 
	 * addAtributte informando um nome e passando o objeto 
	 * que o método retornará para a home para exibir os dados
	 * buscados.
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping
	public String home(Model model, Principal principal) {		
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.ENTREGUE, paginacao);		// conexão com banco de dados
		model.addAttribute("pedidos", pedidos);	
		return "home";
	}
	

	
	
}
