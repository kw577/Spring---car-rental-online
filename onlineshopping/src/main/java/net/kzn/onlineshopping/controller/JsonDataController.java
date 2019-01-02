package net.kzn.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dto.Equipment;

@Controller 
@RequestMapping("json/data")  // Dotyczy wszystkich metod zawartych w tej klasie
public class JsonDataController {

	@Autowired // wstrzykiwanie beanu - klasy ProductDAOImpl  
	private EquipmentDAO equipmentDAO;

	@RequestMapping("/whole/offer")  // adresy typu:  http://localhost:8080/onlineshopping/json/data/all/products 
	@ResponseBody // Spring stara sie przeksztalcic zwrocone wartosci w odpowiedz http (np. konwertujac obiekt na format JSON lub XML)
	public List<Equipment> getAllEquipment(){


		return equipmentDAO.listActiveEquipment();
	}


	@RequestMapping("/category/{id}/equipment")   
	@ResponseBody // Spring stara sie przeksztalcic zwrocone wartosci w odpowiedz http (np. konwertujac obiekt na format JSON lub XML)
	public List<Equipment> getEquipmentByCategory(@PathVariable int id){


		return equipmentDAO.listActiveEquipmentByCategory(id);
	}

	// testowanie czy dane sa zwracane w formacie JSON - postman 
	// np http://localhost:8080/onlineshopping/json/data/all/products    -  metoda GET
	// http://localhost:8080/onlineshopping/json/data/category/3/products
}