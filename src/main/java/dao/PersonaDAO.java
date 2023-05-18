package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Evento;
import entities.Persona;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonaDAO {
	private final EntityManager em;

	public PersonaDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Persona e) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(e);
		transaction.commit();
		log.info("Persona salvata");
	}

	public void getById(String id) {
		Evento found = em.find(Evento.class, UUID.fromString(id));
		System.out.println();
		log.info("Trovato elemento con id " + id + ":" + System.lineSeparator()
				+ found.toString());
	}

	public void delete(String id) {
		Evento found = em.find(Evento.class, UUID.fromString(id));
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Elemento con id " + id + " eliminato!");
		}
	}

	public void refresh(String id) {
		Evento found = em.find(Evento.class, UUID.fromString(id));
		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
