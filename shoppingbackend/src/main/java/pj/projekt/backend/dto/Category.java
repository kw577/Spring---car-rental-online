package pj.projekt.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Category {

	@Id // pole id jest kluczem glownym w tabeli Category bazy danych
	@GeneratedValue(strategy = GenerationType.IDENTITY) // automatyczne generowanie klucza glownego
	private int id;
	private String name;
	private String description;
	
	@Column(name = "image_url") // nazwa atrybutu inna niz odpowiadajaca mu kolumna w tabeli bazy danych
	private String imageURL;
	
	@Column(name = "is_active") // nazwa atrybutu inna niz odpowiadajaca mu kolumna w tabeli bazy danych
	private boolean active = true;


	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + ", imageURL=" + imageURL
				+ ", active=" + active + "]";
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public String getImageURL() {
		return imageURL;
	}
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}



}