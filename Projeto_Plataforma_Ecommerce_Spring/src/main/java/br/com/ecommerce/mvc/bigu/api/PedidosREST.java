package br.com.ecommerce.mvc.bigu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private PedidoRepository pedidoRepository;

	
	/**
	 * Método que realiza uma API REST. Realiza pesquisa no banco de dados buscando 
	 * os pedidos na qual a coluna esteja com o valor 'AGUARDANDO'. Como parâmetro o 
	 * resultado da busca organizado sorteio com paginação de até 5 ítens. 
	 * O Spring vai retornar esses dados quando este método for invocado, porém por
	 * padrão ele armazena esses dados em JSON para dar possibilidade de criação de 
	 * uma API REST.
	 * 
	 * @return
	 */
	@GetMapping("aguardando")
	public List<Pedido> getPedidosAguardandoOfertas() {

		Sort sort = Sort.by("id").descending();
		PageRequest paginacao = PageRequest.of(0, 5, sort);
		return pedidoRepository.findByStatus(StatusPedido.AGUARDANDO, paginacao);
		
	}
}
