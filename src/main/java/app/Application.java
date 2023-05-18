package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PersonaDAO;
import entities.Evento;
import entities.Evento.TipoEvento;
import entities.Location;
import entities.Partecipazione;
import entities.Partecipazione.Stato;
import entities.Persona;
import entities.Persona.Sesso;
import utils.JpaUtil;

public class Application {

	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		PersonaDAO persd = new PersonaDAO(em);
		EventoDAO ed = new EventoDAO(em);
		LocationDAO ld = new LocationDAO(em);
		PartecipazioneDAO partd = new PartecipazioneDAO(em);

		Persona mario = new Persona("Mario", "Rossi", "Mario.rossi@gmail.com",
				LocalDate.parse("1985-02-04"), Sesso.Maschio);

		Evento evento1 = new Evento("Lezione EPICODE", LocalDate.now(),
				"Lezione di JAVA JPA", TipoEvento.PRIVATO);

		Location location1 = new Location("Epicode", "Roma");

		Partecipazione partecipazione1 = new Partecipazione(mario, evento1,
				Stato.CONFERMATA);

		persd.save(mario);
		ed.save(evento1);
		ld.save(location1);
		evento1.setLocation(location1);
		partd.save(partecipazione1);

		em.close();
		emf.close();
	}

}
