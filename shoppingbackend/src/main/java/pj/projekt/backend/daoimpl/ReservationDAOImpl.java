package pj.projekt.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pj.projekt.backend.dao.ReservationDAO;
import pj.projekt.backend.dto.Equipment;
import pj.projekt.backend.dto.Reservation;



import java.sql.Timestamp;
import java.util.Date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;







@Repository("reservationDAO") 
@Transactional
public class ReservationDAOImpl implements ReservationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	
	
	public static Timestamp convertStringToTimestamp(String str_date) {
	    try {
	      DateFormat formatter;
	      formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SSS");
	      Date date = (Date) formatter.parse(str_date);
	      java.sql.Timestamp timeStampDate = new Timestamp(date.getTime());

	      return timeStampDate;
	    } catch (ParseException e) {
	      System.out.println("Exception :" + e);
	      return null;
	    }
	  }
	
	
	
	
		
	
	@Override
	public List<Reservation> listReservationByDate(String rentStart, String rentEnd) {
		// TODO Auto-generated method stub
		
		
		if(rentStart == "" && rentEnd != "") rentStart=rentEnd;
		if(rentEnd == "" && rentStart != "") rentEnd=rentStart;
		
		
		rentStart=rentStart + " 00:00:00:000";
		rentEnd=rentEnd + " 23:59:59:999";
		
		
		Timestamp rentStartTs=this.convertStringToTimestamp(rentStart);
		Timestamp rentEndTs=this.convertStringToTimestamp(rentEnd);
		
		String selectReservations = "FROM Reservation WHERE (reservation_start  <= :rentEndTs AND reservation_end >= :rentEndTs) OR (reservation_start  <= :rentStartTs AND reservation_end >= :rentStartTs) OR (reservation_start  >= :rentStartTs AND reservation_end <= :rentEndTs)";
		
		
		
		Query query = sessionFactory
				.getCurrentSession()
				.createQuery(selectReservations, Reservation.class)
				.setParameter("rentStartTs", rentStartTs)
				.setParameter("rentEndTs", rentEndTs);

		return query.getResultList();
	}

	
	@Override
	public boolean add(Reservation reservation) {
		
		
		
		
		
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(reservation);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	
}