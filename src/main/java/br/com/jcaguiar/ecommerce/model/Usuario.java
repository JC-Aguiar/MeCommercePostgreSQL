package br.com.jcaguiar.ecommerce.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity(name = "usuario")
final public class Usuario {
	
	@Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(unique=true, nullable=false) //se tiver com problemas na persistência, remover/pesquisar
	private String email;
	private String senha;
	private boolean empresa;
	private boolean ativo;
	private Timestamp data_cadastro = new Timestamp( System.currentTimeMillis() );

}
