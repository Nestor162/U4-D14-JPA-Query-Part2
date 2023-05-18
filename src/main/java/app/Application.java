package app;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.ConcertoDAO;
import dao.EventoDAO;
import dao.LocationDAO;
import dao.PartecipazioneDAO;
import dao.PartitaDiCalcioDAO;
import dao.PersonaDAO;
import entities.Concerto;
import entities.Concerto.Genere;
import entities.Evento;
import entities.Evento.TipoEvento;
import entities.Location;
import entities.Partecipazione;
import entities.Partecipazione.Stato;
import entities.PartitaDiCalcio;
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
		PartitaDiCalcioDAO partitad = new PartitaDiCalcioDAO(em);
		ConcertoDAO concertod = new ConcertoDAO(em);

		Persona mario = new Persona("Mario", "Rossi", "Mario.rossi@gmail.com",
				LocalDate.parse("1985-02-04"), Sesso.Maschio);

		Location location1 = new Location("Epicode", "Roma");
		Location location2 = new Location("Stadio San Siro", "Milano");

		Evento evento1 = new Evento("Lezione EPICODE", LocalDate.now(),
				"Lezione di JAVA JPA", TipoEvento.PRIVATO, location1);

		Partecipazione partecipazione1 = new Partecipazione(mario, evento1,
				Stato.CONFERMATA);

		PartitaDiCalcio partita1 = new PartitaDiCalcio("partita Esempio",
				LocalDate.now(), "partita di calcio", TipoEvento.PUBBLICO,
				"Squadra1", "Squadra2", "Squadra2", 1, 3, location1);

		Concerto concerto1 = new Concerto("Concerto Maneskin", LocalDate.now(),
				"concerto streaming Maneskin", TipoEvento.PUBBLICO, Genere.ROCK,
				true, location2);

		Concerto concerto2 = new Concerto("Concerto Imagine Dragons",
				LocalDate.now(), "concerto streaming Imagine Dragons",
				TipoEvento.PUBBLICO, Genere.POP, true, location2);

//		ld.save(location1);
//		ld.save(location2);
//		persd.save(mario);
//		ed.save(evento1);
//		ld.save(location1);
//		partd.save(partecipazione1);
//		partitad.save(partita1);
//		concertod.save(concerto1);

//		List<Evento> concertiInStreaming = ed.getConcertiInStreaming(true);
//		System.out.println("Concerti in streaming:");
//		concertiInStreaming
//				.forEach(concerto -> System.out.println(concerto.toString()));

		List<Evento> concertiPerGenere = ed.getConcertiPerGenere(Genere.ROCK);
		System.out.println("Concerti per genere:");
		concertiPerGenere
				.forEach(concerto -> System.out.println(concerto.toString()));

		em.close();
		emf.close();
	}

}
