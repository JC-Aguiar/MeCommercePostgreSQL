package br.com.jcaguiar.ecommerce.model;

import java.math.BigInteger;
import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.jcaguiar.ecommerce.util.DataFormato;
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
@Entity(name = "pagamento")
final public class Pagamento implements Entidade<Long> {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	@Column(nullable = false)
	private String cartaoNumero;

	@Column(nullable = false) @Temporal(TemporalType.DATE)
	private LocalDateTime cartaoDataValidade;

	@Column(nullable = false)
	private String cartaoTitular;

	@Column(nullable = false, length = 11)
	private String cartaoCpf;

	@Column(nullable = false)
	private String cartaoAgencia;

	@Column(nullable = false)
	private String cartaoToken;

	@Column(nullable = false)
	private byte parcelas;

	@Column(nullable = false)
	private BigInteger subtotal;

	private LocalDateTime data_pagamento;  //nullable?
	//TODO: como funciona um pagamento (oficialmente)
	// O objeto é criado e fica aguardando o comprovante, para depois informar a data?
	// Ou tudo deve ser criado atomicamente?

	
	public void setPagamento(Cartao cartao, BigInteger subtotal, String token, byte parcelas) {
		this.cartaoNumero = cartao.getNumero();
		this.cartaoDataValidade = cartao. getData_validade();
		this.cartaoTitular = cartao.getTitular();
		this.cartaoCpf = cartao.getCpf();
		this.cartaoAgencia = cartao.getAgencia();
		this.subtotal = subtotal;
		this.cartaoToken = token;
		this.parcelas = parcelas;
	}

}
