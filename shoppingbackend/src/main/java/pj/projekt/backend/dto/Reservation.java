package pj.projekt.backend.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Reservation {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	private int equipment_id;
	private String user_name;
	private String user_surname;
	private String user_email;
	private String user_phone;
	private int total_price;
	private Date reservation_start;
	private Date reservation_end;
	
	
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", equipment_id=" + equipment_id + ", user_name=" + user_name
				+ ", user_surname=" + user_surname + ", user_email=" + user_email + ", user_phone=" + user_phone
				+ ", total_price=" + total_price + ", reservation_start=" + reservation_start + ", reservation_end="
				+ reservation_end + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getEquipment_id() {
		return equipment_id;
	}


	public void setEquipment_id(int equipment_id) {
		this.equipment_id = equipment_id;
	}


	public String getUser_name() {
		return user_name;
	}


	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}


	public String getUser_surname() {
		return user_surname;
	}


	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}


	public String getUser_email() {
		return user_email;
	}


	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}


	public String getUser_phone() {
		return user_phone;
	}


	public void setUser_phone(String user_phone) {
		this.user_phone = user_phone;
	}


	public int getTotal_price() {
		return total_price;
	}


	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}


	public Date getReservation_start() {
		return reservation_start;
	}


	public void setReservation_start(Date reservation_start) {
		this.reservation_start = reservation_start;
	}


	public Date getReservation_end() {
		return reservation_end;
	}


	public void setReservation_end(Date reservation_end) {
		this.reservation_end = reservation_end;
	}
	


}