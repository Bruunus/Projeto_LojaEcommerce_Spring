package br.com.ecommerce.mvc.bigu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


	List<Pedido> findByStatus(StatusPedido status);
	

}
