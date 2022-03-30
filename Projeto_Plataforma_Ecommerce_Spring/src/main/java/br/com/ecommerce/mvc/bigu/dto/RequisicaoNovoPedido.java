package br.com.ecommerce.mvc.bigu.dto;

import javax.validation.constraints.NotBlank;

import br.com.ecommerce.mvc.bigu.model.Pedido;
import br.com.ecommerce.mvc.bigu.model.StatusPedido;

public class RequisicaoNovoPedido {
	
	// notação para validação de campos inputs do formulário - O elemento anotado não deve ser nulo e deve conter pelo menos um caractere sem espaço em branco. Aceita CharSequence.
	@NotBlank(message = "Este campo é obrigatório o seu preenchimento")	// Notblank.requisicaoNovoPedido.nomeProduto=
	private String nomeProduto;
	
	@NotBlank(message = "Este campo é obrigatório o seu preenchimento")
	private String urlProduto;
	
	@NotBlank(message = "Este campo é obrigatório o seu preenchimento")
	private String urlImagem;	 
	
	private String descricao;
	
	
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	
	public String getUrlProduto() {
		return urlProduto;
	}
	
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	
	public String getUrlImagem() {
		return urlImagem;
	}
	
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	
	/**
	 * Criação de um método que recebe valos vindo do formulário
	 * invocado dentro do controller PedidoController. Este método
	 * cria um novo objeto e atribui os valos do formulário para 
	 * atributos da classe para ser guardado na base de dados.
	 * @return
	 */
	public Pedido toPedido() {
		Pedido pedido = new Pedido();
		pedido.setNomeProduto(nomeProduto);
		pedido.setDescricao(descricao);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		return pedido;
	}

	
	
	
	

}
