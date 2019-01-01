package pj.projekt.backend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pj.projekt.backend.dao.CategoryDAO;
import pj.projekt.backend.dto.Category;


@Repository("categoryDAO") //  polaczenie z projektem frontendu "categoryDAO" odpowiada nazwie obiektu w PageController
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	//////////// stala lista kategorii - do celow testowych
	private static List<Category> categories = new ArrayList<>();	

	static {
		Category category = new Category();

		// adding first category
		category.setId(1);
		category.setName("Cars");
		category.setDescription("This is some description for Cars!");
		category.setImageURL("CAT_1.png");

		categories.add(category);

		// adding second category
		category = new Category();
		category.setId(2);
		category.setName("Motocycles");
		category.setDescription("This is some description for Motocycles!");
		category.setImageURL("CAT_2.png");

		categories.add(category);


		// adding third category
		category = new Category();
		category.setId(3);
		category.setName("Busses");
		category.setDescription("This is some description for Busses!");
		category.setImageURL("CAT_3.png");

		categories.add(category);
		
		
		// adding category
		category = new Category();
		category.setId(4);
		category.setName("Limousines");
		category.setDescription("This is some description for Limousines!");
		category.setImageURL("CAT_4.png");

		categories.add(category);
		
		
		// adding category
		category = new Category();
		category.setId(5);
		category.setName("Trailers");
		category.setDescription("This is some description for Trailers!");
		category.setImageURL("CAT_5.png");

		categories.add(category);

	}
	
	


	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	
	
	@Override
	public Category get(int id) {

		// petla forEach
		for(Category category : categories) {

			if(category.getId() == id) return category;

		}

		return null;
	}


	//////////////// stala lista kategorii - test 
	*/
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		// w hibernate jako nazwy tabeli uzywa sie nazwy klasy
		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		query.setParameter("active", true);

		return query.getResultList();
	}
	
	
	
	@Override
	public Category get(int id) {

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
	}
	
	
	
	
	// dodanie nowej kategorii do bazy danych
	@Override
	@Transactional
	public boolean add(Category category) {

		try {
			// nawiazanie polaczenia z baza danych 
			sessionFactory.getCurrentSession().persist(category);

			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}


	}
	
	
	// metoda sluzy do updatowania kategorii w bazie danych
	@Override
	public boolean update(Category category) {
		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {

		category.setActive(false); // kategoria nie jest tak wlasciewie usuwana tylko jej status jest ustawiany na nieaktywna

		// po zmianie statusu wybranej kategorii nastepuje jej update 
		try {

			sessionFactory.getCurrentSession().update(category);

			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
}