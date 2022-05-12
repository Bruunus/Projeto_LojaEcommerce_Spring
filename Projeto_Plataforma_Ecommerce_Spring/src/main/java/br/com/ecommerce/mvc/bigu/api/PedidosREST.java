package br.com.ecommerce.mvc.bigu.api;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;
import br.com.ecommerce.mvc.bigu.repository.PedidoRepository;

@RestController
@RequestMapping("api/pedidos")
public class PedidosREST {
	
	private PedidoRepository pedidoRepository;
	
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {
		
		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
	}

}
