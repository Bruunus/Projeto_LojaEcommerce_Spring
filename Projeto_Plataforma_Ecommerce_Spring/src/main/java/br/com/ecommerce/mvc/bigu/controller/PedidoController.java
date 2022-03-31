package br.com.ecommerce.mvc.bigu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecommerce.mvc.bigu.dto.RequisicaoNovoPedido;
import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.User;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;
import br.com.ecommerce.mvc.bigu.repository.UserRepository;


@Controller @RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoPedido request) {
		return "pedido/formulario";
	}
	
	
	/**
	 * Método de requisição para cadastrar um produto no banco de dados. Recebe um RequisicaoNovoPedido
	 * Contendo um filtro de validação de preenchimento e um BingingResult para tratativa de erro.
	 * SecurityContextHolder guardada em uma variável para descobrir o nome do usuário que está logado
	 * Criado uma query de select para identificar o usuário pelo nome através do repository UserRepository
	 * Instanciado um objeto do tipo pedido em variável que chamará o método setter e passando o nome do usuário 
	 * recuperado para associa-lo entre o banco e a aplicação. Por fim realiza o cadastro do ítem vinculado ao
	 * usuário.
	 * 
	 * @valid - O Spring se conecta com a notação @NotBlank de validação dos atributos para entrada de dados deste parâmetro
	 * @param request
	 * @return - O objeto do parâmetro BindingResult informa o resultado da validação dos dados acionando um erro ou não.
	 */
	@PostMapping("/novo")
	public String novo(@Validated RequisicaoNovoPedido request, BindingResult result) {
		
		if(result.hasErrors())		
			return "pedido/formulario";
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(username);
		
		Pedido pedido = request.toPedido();
		pedido.setUser(user);
		pedidoRepository.save(pedido);
		
		return "redirect:/home";   
	}
	
}
