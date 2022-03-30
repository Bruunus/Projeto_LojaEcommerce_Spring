package br.com.ecommerce.mvc.bigu.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecommerce.mvc.bigu.dto.RequisicaoNovoPedido;
import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;


@Controller @RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	
	@GetMapping("/formulario")
	public String formulario(RequisicaoNovoPedido request) {
		return "pedido/formulario";
	}
	
	
	/**
	 * @valid - O Spring se conecta com a notação @NotBlank de validação dos atributos para entrada de dados deste parâmetro
	 * @param request
	 * @return - O objeto do parâmetro BindingResult informa o resultado da validação dos dados acionando um erro ou não.
	 */
	@PostMapping("/novo")
	public String novo(@Validated RequisicaoNovoPedido request, BindingResult result) {
		
		if(result.hasErrors())		
			return "pedido/formulario";
		
		Pedido pedido = request.toPedido();
		pedidoRepository.save(pedido);
		
		return "redirect:/home";  // ou     return "forward:/home"; - serve também
	}
	
}
