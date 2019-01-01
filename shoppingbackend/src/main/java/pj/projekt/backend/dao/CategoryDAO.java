package pj.projekt.backend.dao;

import java.util.List;

import pj.projekt.backend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	
	List<Category> list();
	
	Category get(int id);
	
	boolean update(Category category);
	boolean delete(Category category);

}