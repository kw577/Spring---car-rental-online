package pj.projekt.backend.dao;

import java.util.List;

import pj.projekt.backend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	
	Category get(int id);

}