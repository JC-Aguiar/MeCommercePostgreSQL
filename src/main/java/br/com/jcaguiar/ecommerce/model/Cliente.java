package br.com.jcaguiar.ecommerce.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

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
@Entity(name = "cliente")
final public class Cliente {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	@JoinColumn(name = "id")
	private final List<Endereco> endereco = new ArrayList<>();
	
	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
	private final List<Cartao> cartao = new ArrayList<>();
	private String nome;
	private String sobrenome;
	private String cpf;
	private String phone;
	private LocalDateTime data_nascimento;
	private short idade;
	private char sexo;
	private short votos;

}
