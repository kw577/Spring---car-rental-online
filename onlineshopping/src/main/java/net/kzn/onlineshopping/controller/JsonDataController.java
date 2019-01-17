package net.kzn.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dao.ReservationDAO;
import pj.projekt.backend.dto.Equipment;
import pj.projekt.backend.dto.Reservation;

@Controller 
@RequestMapping("json/data")  // Dotyczy wszystkich metod zawartych w tej klasie
public class JsonDataController {

	@Autowired    
	private EquipmentDAO equipmentDAO;

	@Autowired   
	private ReservationDAO reservationDAO;
	
	
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
	
	
	
	
	@RequestMapping(value = { "offer/criteria/search" }) 
	@ResponseBody
	public List<Equipment> showAllProductsWithCriteria(
			@RequestParam("rentStart") String rentStart,
			@RequestParam("rentEnd") String rentEnd,
			@RequestParam("category") Integer category,
			@RequestParam("maxPrice") Double maxPrice) {

	
		
		///////////////////////////////////
		
		List<Integer> rentedEquipment = new ArrayList<Integer>();
		rentedEquipment.add(0);
		
		
		if(rentStart != "" || rentEnd != "") {
			List<Reservation> temp = reservationDAO.listReservationByDate(rentStart,rentEnd);
			
			for (Reservation item : temp) {
				rentedEquipment.add(item.getEquipment_id());
			    
			}
		}
		
		
		
		System.out.println("\n\n\n\n\n\n### Json Data Controller - lista zajetych samochodow");
		System.out.println(rentedEquipment);
		
		
		////////////////////////////////////////
		
		
		//return equipmentDAO.listActiveEquipmentByCategory(id);
		return equipmentDAO.listActiveEquipmentWithSearchCriteria(rentedEquipment, category, maxPrice);

	}
	
	
	
	
	

	// testowanie czy dane sa zwracane w formacie JSON - postman 
	// np http://localhost:8080/onlineshopping/json/data/all/products    -  metoda GET
	// http://localhost:8080/onlineshopping/json/data/category/3/products
}