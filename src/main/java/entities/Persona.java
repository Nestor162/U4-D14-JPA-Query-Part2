package entities;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Persona {
	@Id
	@GeneratedValue
	private UUID id;
	private String nome;
	private String cognome;
	private String email;
	private LocalDate dataNascita;
	private Sesso sesso;

	public enum Sesso {
		Maschio, Femmina
	}

	@OneToMany(mappedBy = "persona")
	private Set<Partecipazione> listaPartecipazioni;

	public Persona(String nome, String cognome, String email,
			LocalDate dataNascita, Sesso sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.dataNascita = dataNascita;
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome + ", cognome=" + cognome
				+ ", email=" + email + ", dataNascita=" + dataNascita
				+ ", sesso=" + sesso + ", listaPartecipazioni="
				+ listaPartecipazioni + "]";
	}

}
