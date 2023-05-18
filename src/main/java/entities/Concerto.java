package entities;

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
@DiscriminatorValue("Concerto")
@Table(name = "Concerti")
public class Concerto extends Evento {
	private Genere genere;
	private boolean isStreaming;

	public enum Genere {
		CLASSICO, ROCK, POP

	}

}
