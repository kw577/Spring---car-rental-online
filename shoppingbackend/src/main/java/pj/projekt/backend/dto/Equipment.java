package pj.projekt.backend.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity // adnotacja oznacza ze klasa odpowiada tabeli w bazie danych
public class Equipment {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	
	private String brand;
	
	// przechowuje adres zdjecia
	private String code;

	private String description;
	
	@Column(name = "unit_price")
	private double unitPrice;
	
	private int quantity;
	
	@Column(name = "is_active")
	@JsonIgnore // pole decription bedzie pominiete przy generowaniu danych w formacie JSON
	private boolean active;
	
	@Column(name = "category_id")
	@JsonIgnore // pole decription bedzie pominiete przy generowaniu danych w formacie JSON
	private int categoryId;
	
	@JsonIgnore // pole decription bedzie pominiete przy generowaniu danych w formacie JSON
	private String detailed_description;
	

	// setters and getters	
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
		
	public String getDetailed_description() {
		return detailed_description;
	}
	public void setDetailed_description(String detailed_description) {
		this.detailed_description = detailed_description;
	}
	
	// toString for debugging
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", description="
				+ description + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", active=" + active
				+ ", categoryId=" + categoryId + "]";
	}

}