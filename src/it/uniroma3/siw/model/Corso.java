package it.uniroma3.siw.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Corso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private LocalDate dataInizio;
	
	@Column
	private int durata;
	
	/*
	 * Quando creo un corso, memorizzo tutti i suoi allievi.
	 * Quando un allievo cambia corso, tolgo dalla lista del corso lo studente.
	 */
	@ManyToMany (mappedBy = "corsi", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Allievo> studenti;
	
	@ManyToOne
	private Docente curatore;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}

	public List<Allievo> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Allievo> studenti) {
		this.studenti = studenti;
	}


	
	
}
