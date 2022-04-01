package br.com.ecommerce.mvc.bigu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {


	List<Pedido> findByStatus(StatusPedido status);

	/**
	 * Método que realiza consulta no banco de dados através da @query especificada.
	 * No caso para trazer os pedidos de acordo com o username especificado fazendo 
	 * junção com a tabela 'users'.
	 * @param username
	 * @return
	 */
	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username")
	List<Pedido> findByUsuario(@Param("username")String username);
	
	
	/**
	 * Método que realiza busca no banco de dado para trazer os produtos que estão 
	 * amarrados ao status que o status esteja vinculados ao usuário. 
	 * @param status - Status atual do produto no banco de dados.
	 * @param username - Usuario cadastrado no banco de dados
	 * @return
	 */
	@Query("SELECT p FROM Pedido p JOIN p.user u WHERE u.username = :username AND p.status = :status")
	List<Pedido> findByStatusEUsuario(@Param("status")StatusPedido status, @Param("username")String username);

}
