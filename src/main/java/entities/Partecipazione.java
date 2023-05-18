package entities;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Partecipazione {
	@Id
	@GeneratedValue
	private UUID id;
	private Stato stato;

	public enum Stato {
		CONFERMATA, DA_CONFERMARE
	}

	@ManyToOne
	@JoinColumn(name = "evento_id")
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	public Partecipazione(Persona persona, Evento evento, Stato stato) {

		this.persona = persona;
		this.evento = evento;
		this.stato = stato;
	}

	@Override
	public String toString() {
		return "Partecipazione [id=" + id + ", persona=" + persona + ", evento="
				+ evento + ", stato=" + stato + "]";
	}

}
