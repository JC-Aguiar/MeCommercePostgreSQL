package br.com.jcaguiar.ecommerce.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import lombok.Getter;


public class deletJpaUtil {
	
	private final EntityManagerFactory fabricaGerente = Persistence.createEntityManagerFactory("jdbc:mysql://localhost/ecommerce2");
	
	@Getter
	private EntityManager gerente;

	public deletJpaUtil() {
		gerente = fabricaGerente.createEntityManager();
	}
	
}