package entities;
// Generated 1 juil. 2019 11:22:54 by Hibernate Tools 5.4.2.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Personne generated by hbm2java
 */
public class Personne implements java.io.Serializable {

	private int idpers;
	private String prenom;
	private String nom;
	private String login;
	private String motdepase;
	private Set clients = new HashSet(0);
	private Set commercants = new HashSet(0);
	private Set administrateurs = new HashSet(0);

	public Personne() {
	}

	public Personne(int idpers) {
		this.idpers = idpers;
	}

	public Personne(int idpers, String prenom, String nom, String login, String motdepase, Set clients, Set commercants,
			Set administrateurs) {
		this.idpers = idpers;
		this.prenom = prenom;
		this.nom = nom;
		this.login = login;
		this.motdepase = motdepase;
		this.clients = clients;
		this.commercants = commercants;
		this.administrateurs = administrateurs;
	}

	public int getIdpers() {
		return this.idpers;
	}

	public void setIdpers(int idpers) {
		this.idpers = idpers;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotdepase() {
		return this.motdepase;
	}

	public void setMotdepase(String motdepase) {
		this.motdepase = motdepase;
	}

	public Set getClients() {
		return this.clients;
	}

	public void setClients(Set clients) {
		this.clients = clients;
	}

	public Set getCommercants() {
		return this.commercants;
	}

	public void setCommercants(Set commercants) {
		this.commercants = commercants;
	}

	public Set getAdministrateurs() {
		return this.administrateurs;
	}

	public void setAdministrateurs(Set administrateurs) {
		this.administrateurs = administrateurs;
	}

}
