package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Concerto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConcertoDAO {
	private final EntityManager em;

	public ConcertoDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Concerto c) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(c);
		transaction.commit();
		log.info("Evento salvato");
	}

	public void getById(String id) {
		ConcertoDAO found = em.find(ConcertoDAO.class, UUID.fromString(id));
		System.out.println();
		log.info("Trovato elemento con id " + id + ":" + System.lineSeparator()
				+ found.toString());
	}

	public void delete(String id) {
		ConcertoDAO found = em.find(ConcertoDAO.class, UUID.fromString(id));
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Elemento con id " + id + " eliminato!");
		}
	}

	public void refresh(String id) {
		ConcertoDAO found = em.find(ConcertoDAO.class, UUID.fromString(id));

		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
