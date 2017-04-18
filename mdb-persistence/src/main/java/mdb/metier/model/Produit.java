package mdb.metier.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="Produit")
public class Produit {
	private Long id;
	private Integer version;
	private String nom;
	private String description;
	private Integer stock = 0;
	private Double prix;
	
	public Produit(){}

	public Produit(String nom, String description, Integer stock, Double prix) {
		super();
		this.nom = nom;
		this.description = description;
		this.stock = stock;
		this.prix=prix;
	}
	
	@Id  @GeneratedValue
	@JsonView(Views.Public.class)
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}


	@Version
	@Column(name="Version")
	@JsonView(Views.Public.class)
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}

	@Column(name="nom")
	@JsonView(Views.Public.class)
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name="description")
	@JsonView(Views.Public.class)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="stock")
	@JsonView(Views.Public.class)
	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}


	@JsonView(Views.Public.class)
	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	
	
	

}
