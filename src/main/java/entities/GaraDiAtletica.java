package entities;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("GaraDiAtletica")
@Table(name = "GareDiAtletica")
public class GaraDiAtletica extends Evento {

	@OneToMany(mappedBy = "garaDiAtletica")
	private Set<Persona> SetAtleti;

	@OneToOne
	@JoinColumn(name = "vincitore_id")
	private Persona vincitore;

	public GaraDiAtletica(String titolo, LocalDate dataEvento,
			String descrizione, TipoEvento tipoEvento, Set<Persona> setAtleti,
			Persona vincitore) {
		super(titolo, dataEvento, descrizione, tipoEvento);
		SetAtleti = setAtleti;
		this.vincitore = vincitore;
	}

}
