package pj.projekt.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dto.Equipment;


@Repository("EquipmentDAO") // oznacza ze klasa jest klasa dostepu do danych
@Transactional // wszystkie metody klasy dzialaja na zasadzie transacji (dostep do bazy danych)
public class EquipmentDAOImpl implements EquipmentDAO {

	@Autowired  // wstrzykiwanie beana
	private SessionFactory sessionFactory;

	/*
	 * SINGLE
	 * */
	// zwraca produkt o okreslonym id
	@Override
	public Equipment get(int equipmentId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Equipment.class,Integer.valueOf(equipmentId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST - wyswietla liste wszystkich produktow
	 * */

	@Override
	public List<Equipment> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Equipment" , Equipment.class)
						.getResultList();
	}

	/*
	 * INSERT - dodawanie nowego produktu
	 * */
	@Override
	public boolean add(Equipment equipment) {
		try {			
			sessionFactory
					.getCurrentSession()
						.persist(equipment);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;
	}

	/*
	 * UPDATE = aktualizacja produktu
	 * */
	@Override
	public boolean update(Equipment equipment) {
		try {			
			sessionFactory
					.getCurrentSession()
						.update(equipment);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}


	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Equipment equipment) {
		try {

			equipment.setActive(false);
			// call the update method
			return this.update(equipment);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}



	////////////////////// Dodatkowe MEtody - ktorych nie bylo w klasie Category

	@Override
	public List<Equipment> listActiveEquipment() {
		String selectActiveEquipment = "FROM Equipment WHERE active = :active";
		// "FROM Equipment WHERE active .... "" - Equipment to nazwa biezacej klasy 
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveEquipment,Equipment.class)
						.setParameter("active", true)
							.getResultList();

	}

	@Override
	public List<Equipment> listActiveEquipmentByCategory(int categoryId) {
		String selectActiveEquipmentByCategory = "FROM Equipment WHERE active = :active AND categoryId = :categoryId";
		// "FROM Equipment WHERE active .... "" - Equipment to nazwa klasy 
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveEquipmentByCategory,Equipment.class)
						.setParameter("active", true)
						.setParameter("categoryId", categoryId)
							.getResultList();
	}

	
	
	
	@Override
	public List<Equipment> listActiveEquipmentWithSearchCriteria(String rentStart, String rentEnd, Integer categoryId, Double maxPrice) {
		
		if (maxPrice == null) 
		{
			maxPrice = 999999999.0;
		};
		
		String selectActiveEquipmentByCategory;
		
		if(categoryId == 0) {
			selectActiveEquipmentByCategory = "FROM Equipment WHERE active = :active AND unitPrice <= :maxPrice";
			return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveEquipmentByCategory,Equipment.class)
							.setParameter("active", true)
							.setParameter("maxPrice", maxPrice)
								.getResultList();
		}
		else 
			{
			selectActiveEquipmentByCategory = "FROM Equipment WHERE active = :active AND categoryId = :categoryId AND unitPrice <= :maxPrice";
			
		
		
		
			// "FROM Equipment WHERE active .... "" - Equipment to nazwa klasy 
			return sessionFactory
					.getCurrentSession()
						.createQuery(selectActiveEquipmentByCategory,Equipment.class)
							.setParameter("active", true)
							.setParameter("maxPrice", maxPrice)
							.setParameter("categoryId", categoryId)
								.getResultList();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public List<Equipment> getLatestActiveEquipment(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Equipment WHERE active = :active ORDER BY id",Equipment.class)
						.setParameter("active", true)
							.setFirstResult(0)  // zapytanie pobiera z bazy danych liste produktow uporzadkowana wg id - nastepnie ustawiamy ze maksymalna ilosc rezutatow wynosi count - czyli liczbe wybrana przez uzytkownika 
							.setMaxResults(count)  //zwraca maksymalnie tyle produktow ile wybral uzytkownik
								.getResultList();					
	}

}