package fstt.org.market.entities.persistence;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Etudiant implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, unique = true )
	private Integer id;
	
	@Column(nullable = false, length =  255 )
	private String nom;
	
	@Column(nullable = false, length =  255 )
	private String prenom;
	
	@Column(nullable = false, length =  255 )
	private String cne;
	
	@Column(nullable = false, length =  255 )
	private String adresse;
	
	@Column(nullable = false, length =  255 )
	private String niveau;

	
	public Etudiant() {
		super();
	}

	public Etudiant(Integer id, String nom, String prenom, String cne, String adresse, String niveau) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.adresse = adresse;
		this.niveau = niveau;
	}
	
	public Etudiant(String nom, String prenom, String cne, String adresse, String niveau) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cne = cne;
		this.adresse = adresse;
		this.niveau = niveau;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
	
}