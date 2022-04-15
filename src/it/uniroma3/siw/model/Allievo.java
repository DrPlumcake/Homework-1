package it.uniroma3.siw.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
public class Allievo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column (nullable = false)
	private String nome;
	
	@Column
	private String cognome;
	
	@Column 
	private LocalDate dataDiNascita;
	
	@Column
	private String luogoDiNascita;
	
	@Column
	private int matricola;
	
	@Column
	private String email;
	
	/*
	 * Quanto immetto un allievo nel database immetto anche la società alla quale appartiene.
	 * Quando rimuovo un allievo non rimuovo anche la società in quanto altri allievi potrebbero appartenervi.
	 */
	
	@OneToOne(cascade = {CascadeType.PERSIST})
	private Società società;
	
	@ManyToMany 
	private List<Corso> corsi;
	
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
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public int getMatricola() {
		return matricola;
	}
	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
