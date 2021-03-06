package entities;
// Generated 1 juil. 2019 11:22:54 by Hibernate Tools 5.4.2.Final

/**
 * Boutique generated by hbm2java
 */
public class Boutique implements java.io.Serializable {

	private int idbout;
	private Commercant commercant;
	private Integer codebout;
	private Integer nom;

	public Boutique() {
	}

	public Boutique(int idbout, Commercant commercant) {
		this.idbout = idbout;
		this.commercant = commercant;
	}

	public Boutique(int idbout, Commercant commercant, Integer codebout, Integer nom) {
		this.idbout = idbout;
		this.commercant = commercant;
		this.codebout = codebout;
		this.nom = nom;
	}

	public int getIdbout() {
		return this.idbout;
	}

	public void setIdbout(int idbout) {
		this.idbout = idbout;
	}

	public Commercant getCommercant() {
		return this.commercant;
	}

	public void setCommercant(Commercant commercant) {
		this.commercant = commercant;
	}

	public Integer getCodebout() {
		return this.codebout;
	}

	public void setCodebout(Integer codebout) {
		this.codebout = codebout;
	}

	public Integer getNom() {
		return this.nom;
	}

	public void setNom(Integer nom) {
		this.nom = nom;
	}

}
