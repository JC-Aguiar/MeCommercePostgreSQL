package br.com.jcaguiar.ecommerce.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity(name = "pedido_item")
final public class PedidoItem implements Entidade<Long> {

	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private PedidoProduto produto;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	private short quantidade;
	private BigDecimal total;
	private final LocalDateTime data_carrinho = LocalDateTime.now();
	
}
