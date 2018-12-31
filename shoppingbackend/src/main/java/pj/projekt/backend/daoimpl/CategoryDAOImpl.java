package pj.projekt.backend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import pj.projekt.backend.dao.CategoryDAO;
import pj.projekt.backend.dto.Category;


@Repository("categoryDAO") //  polaczenie z projektem frontendu "categoryDAO" odpowiada nazwie obiektu w PageController
public class CategoryDAOImpl implements CategoryDAO {

	// stala lista kategorii - do celow testowych
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

	//////////////// stala lista kategorii - test 


	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

}