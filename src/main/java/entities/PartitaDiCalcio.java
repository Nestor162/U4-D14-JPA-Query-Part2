package entities;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PartitaDiCalcio")
@Table(name = "PartiteDiCalcio")
public class PartitaDiCalcio extends Evento {
	private String squadraDiCasa;
	private String squadraOspite;
	private String squadraVincete;
	private int numeroGolSquadraDiCasa;
	private int numeroGolSquadraOspite;

	public PartitaDiCalcio(String titolo, LocalDate dataEvento,
			String descrizione, TipoEvento tipoEvento, String squadraDiCasa,
			String squadraOspite, String squadraVincete,
			int numeroGolSquadraDiCasa, int numeroGolSquadraOspite,
			Location location) {

		super(titolo, dataEvento, descrizione, tipoEvento, location);
		this.squadraDiCasa = squadraDiCasa;
		this.squadraOspite = squadraOspite;
		this.squadraVincete = squadraVincete;
		this.numeroGolSquadraDiCasa = numeroGolSquadraDiCasa;
		this.numeroGolSquadraOspite = numeroGolSquadraOspite;
	}

}
