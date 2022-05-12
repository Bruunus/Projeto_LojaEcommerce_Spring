package br.com.ecommerce.mvc.bigu.api;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.mvc.bigu.dto.RequisicaoNovaOferta;
import br.com.ecommerce.mvc.bigu.model.Oferta;
import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;

@RestController
@RequestMapping("/api/ofertas")
public class GerarOfertasRESTFull {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	
	// métodos que vai receber os dados por requisição de uma oferta
	// No parâmetro ele espera dados vindo do formulário através da anotação @RequestBody de acordo com os dados 
	// da classe RequisicaoNovaOferta
	// Feito acesso ao banco de dados por id passado na requisição e armazenado em uma lista do tipo Optional
	/**
	 * 
	 * @param requisicao
	 * @return
	 */
	@PostMapping
	public Oferta criaOferta(@RequestBody RequisicaoNovaOferta requisicao) {
		
		Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
		
		if(!pedidoBuscado.isPresent()) {
			return null;
		}
		
		Pedido pedido = pedidoBuscado.get();
		
		Oferta novaOferta = requisicao.toOferta();
		novaOferta.setPedido(pedido);		// passa o pedido que buscou no banco
		pedido.getOfertas().add(novaOferta);
		pedidoRepository.save(pedido);
		
		return novaOferta;
		
	}
	
}
