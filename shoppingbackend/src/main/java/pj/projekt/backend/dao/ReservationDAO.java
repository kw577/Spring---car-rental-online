package pj.projekt.backend.dao;

import java.util.List;


import pj.projekt.backend.dto.Reservation;

public interface ReservationDAO {


	
	List<Reservation> listReservationByDate(String rentStart, String rentEnd);
	boolean add(Reservation reservation);


}