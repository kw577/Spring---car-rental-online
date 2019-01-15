package pj.projekt.backend.dao;

import java.util.List;

import pj.projekt.backend.dto.Equipment;

public interface EquipmentDAO {

	// 5 ponizszych nalezy zaimplementwac analogicznie jak dla klasy Category
	Equipment get(int equipmentId);
	List<Equipment> list();	
	boolean add(Equipment equipment);
	boolean update(Equipment equipment);
	boolean delete(Equipment equipment);

	// business methods
	List<Equipment> listActiveEquipment();
	List<Equipment> listActiveEquipmentByCategory(int categoryId);
	List<Equipment> getLatestActiveEquipment(int count);
	List<Equipment> listActiveEquipmentWithSearchCriteria(String rentStart, String rentEnd, Integer category, Double maxPrice);
}