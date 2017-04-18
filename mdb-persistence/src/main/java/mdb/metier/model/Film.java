package mdb.metier.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;



@Entity
@Table(name="film")
public class Film {
	
	private Long idLocal;
	//id de the movie database
	private Long id;
	private Integer version;
	private String titre;
	private String posterPath;
	private String description;
	//private List<String> genres = new ArrayList<String>();
	
	public Film() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Film(String titre) {
		super();
		this.titre = titre;
	}
	
	@GeneratedValue
	public Long getIdLocal() {
		return idLocal;
	}

	public void setIdLocal(Long id) {
		this.idLocal = id;
	}

	@Version
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	@Id @Column(name="id_tmdb")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getPosterPath() {
		return posterPath;
	}

	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


//	public List<String> getGenres() {
//		return genres;
//	}
//
//	public void setGenres(List<String> genres) {
//		this.genres = genres;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	

}
