package pj.projekt.backend.dto;

// jest to pomocnicza klasa do dodawania rezerwacji (problem z formatem daty - w formularzu Spring jest text, a w bazie danych Timestamp)
public class ReservationTemp {
	
	private int id;
	
	private int equipment_id;
	private String user_name;
	private String user_surname;
	private String user_email;
	private String user_phone;
	private int total_price;
	private String reservation_start;
	private String reservation_end;
		

	@Override
	public String toString() {
		return "ReservationTemp [id=" + id + ", equipment_id=" + equipment_id + ", user_name=" + user_name
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


	public String getReservation_start() {
		return reservation_start;
	}


	public void setReservation_start(String reservation_start) {
		this.reservation_start = reservation_start;
	}


	public String getReservation_end() {
		return reservation_end;
	}


	public void setReservation_end(String reservation_end) {
		this.reservation_end = reservation_end;
	}

}