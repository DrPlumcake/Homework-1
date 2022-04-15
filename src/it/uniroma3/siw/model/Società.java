package it.uniroma3.siw.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Società {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String ragioneSociale;
	
	@Column
	private int numeroTelefono;
	/*
	 * Quando carico una società voglio caricare anche il suo indirizzo.
	 * Quando rimuovo una società voglio rimuovere anche il suo indirizzo.
	 */
    @OneToOne (cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Indirizzo address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public int getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Indirizzo getAddress() {
		return address;
	}

	public void setAddress(Indirizzo address) {
		this.address = address;
	}
	
    
}
