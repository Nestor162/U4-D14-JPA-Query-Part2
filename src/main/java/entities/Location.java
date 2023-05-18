package entities;

import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Location {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String citta;

	// Una location può ospitare più eventi
	@OneToMany(mappedBy = "location")
	@OrderBy("dataEvento")
	private Set<Evento> listaEventi;

	public Location(String nome, String citta) {
		this.nome = nome;
		this.citta = citta;
	}

}
