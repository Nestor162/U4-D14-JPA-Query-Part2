package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Eventi")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_evento")
public class Evento {
	@Id
	@GeneratedValue
	private UUID id;
	private String titolo;
	private LocalDate dataEvento;
	private String descrizione;
	private TipoEvento tipoEvento;

	public enum TipoEvento {
		PUBBLICO, PRIVATO
	}

	// Un evento possono avere più partecipazioni
	@OneToMany(mappedBy = "evento", cascade = CascadeType.ALL)
	private Set<Partecipazione> listaPartecipazioni;

	// Un evento puo avvenire in una sola location
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;

	public Evento(String titolo, LocalDate dataEvento, String descrizione,
			TipoEvento tipoEvento, Location location) {

		this.titolo = titolo;
		this.dataEvento = dataEvento;
		this.descrizione = descrizione;
		this.tipoEvento = tipoEvento;
		this.location = location;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", titolo=" + titolo + ", dataEvento="
				+ dataEvento + ", descrizione=" + descrizione + ", tipoEvento="
				+ tipoEvento + ", listaPartecipazioni=" + listaPartecipazioni
				+ ", location=" + location + "]";
	}

}
