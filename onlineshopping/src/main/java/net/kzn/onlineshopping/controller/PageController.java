package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pj.projekt.backend.dao.CategoryDAO;
import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dto.Category;
import pj.projekt.backend.dto.Equipment;

@Controller
public class PageController {

	@Autowired // polaczenie z projektem Backendu 
	private CategoryDAO categoryDAO;
	
	@Autowired // polaczenie z projektem Backendu 
	private EquipmentDAO equipmentDAO;
	
	// funkcja zwracajaca ModelAndView - zawartosc strony 
	@RequestMapping(value = {"/", "/home", "/index"}) // adres html np: http://localhost:8080/onlineshopping/home
	public ModelAndView index() {
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Home");
		
		mv.addObject("categories", categoryDAO.list()); // test
		
		mv.addObject("userClickHome", true);
		return mv;
		
		
	}
	
	
	// funkcja uruchamia sie gdy na pasku nawigacji nacisnie sie przycisk "about" -
		// przycisk ten jest odnosnikiem do adresu onlineshopping/about
		@RequestMapping(value = { "about" })
		public ModelAndView about() {

			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title", "About Us");
			mv.addObject("userClickAbout", true);
			return mv;

	}
		
		
		// funkcja uruchamia sie gdy na pasku nawigacji nacisnie sie przycisk "Contact"
		// - przycisk ten jest odnosnikiem do adresu onlineshopping/contact
		@RequestMapping(value = { "contact" })
		public ModelAndView contact() {
			ModelAndView mv = new ModelAndView("page");
			mv.addObject("title", "Contact Us");
			mv.addObject("userClickContact", true);
			return mv;

		}
		
		
		/*
		 * Wyswietla wszystkie dostepne somochody do wynajecia
		 */
		@RequestMapping(value = { "show/whole/offer" }) 
		public ModelAndView showAllProducts() {

			ModelAndView mv = new ModelAndView("page");

			mv.addObject("title", "Whole offer");

			mv.addObject("categories", categoryDAO.list());	
			
			// TEST
			mv.addObject("cars", equipmentDAO.listActiveEquipment());	
			///////
			
			
			mv.addObject("userClickWholeOffer", true);
			return mv;

		}


		@RequestMapping(value = { "show/category/{id}/offer" }) 
		public ModelAndView showCategoryProducts(@PathVariable("id") int id) {

			ModelAndView mv = new ModelAndView("page");

			// categoryDAO to fetch a single category
			Category category = null;

			category = categoryDAO.get(id);

			mv.addObject("title", category.getName());

			// lista kategorii
			mv.addObject("categories", categoryDAO.list());	

			// passing the single category object
			mv.addObject("category", category);	

			// TEST
			//mv.addObject("cars", equipmentDAO.listActiveEquipmentByCategory(category.getId()));
			
			mv.addObject("userClickCategoryOffer", true);
			return mv;

		}


		/*
		 * Wyswietla oferte wg podanych kryteriow wyszukiwania
		 */
		@RequestMapping(value = { "offer/criteria/search" }) 
		public ModelAndView showAllProductsWithCriteria(
				@RequestParam("rentStart") String rentStart,
				@RequestParam("rentEnd") String rentEnd,
				@RequestParam("category") Integer category,
				@RequestParam("maxPrice") Double maxPrice) {

			
			String searchCriteria;
			searchCriteria = "?rentStart=" + rentStart + "&rentEnd=" + rentEnd + "&category=" + category;
			if(maxPrice == null) searchCriteria += "&maxPrice=";
			else searchCriteria += "&maxPrice=" + maxPrice;
			
			System.out.println("\n\n\n\n\n################################");
			
			System.out.println("\n rent start: " + rentStart);
			System.out.println("\n rent end: " + rentEnd);
			System.out.println("\n category: " + category);
			System.out.println("\n maxPrice: " + maxPrice);
			
			System.out.println("\n searchCriteria: " + searchCriteria);
			
			
			System.out.println("\n\n\n\n\n################################");
			
			
			
			ModelAndView mv = new ModelAndView("page");

			mv.addObject("title", "User criteria offer");

			mv.addObject("categories", categoryDAO.list());	
			
			mv.addObject("searchingCriteria", searchCriteria);
			
			mv.addObject("userClickUserCriteriaOffer", true);
			return mv;

		}

		
		
		
		/*
		 * Podglad informacji o pojedynczym urzadzeniu
		 */
		
		@RequestMapping(value = "/view/id/{id}/equipment")
		public ModelAndView showSingleProduct(@PathVariable int id) {
			ModelAndView mv = new ModelAndView("page");
			
			Equipment equipment = null;
			equipment = equipmentDAO.get(id);

						
			// zwieksza liczik wyswietlen 
			//equipment.setViews(equipment.getViews() + 1); 
			//equipmentDAO.update(equipment);
			//-----------------------


			mv.addObject("title", equipment.getName());
			mv.addObject("equipment", equipment);

			mv.addObject("userClickShowDetails", true); // zmienna pomocnicza wykorzystywana w pliku page.jsp do ustalenia jaa zawartosc strony ma byc wyswietlona

			return mv;
		}
		
		
		/*
		 * Strona rezerwacji
		 */
		
		@RequestMapping(value = "/cart/add/id/{id}/equipment")
		public ModelAndView reservationEquipment(@PathVariable int id) {
			ModelAndView mv = new ModelAndView("page");
			
			Equipment equipment = null;
			equipment = equipmentDAO.get(id);

			mv.addObject("title", equipment.getName());
			mv.addObject("equipment", equipment);

			mv.addObject("userClickEquipmentReservation", true); // zmienna pomocnicza wykorzystywana w pliku page.jsp do ustalenia jaa zawartosc strony ma byc wyswietlona

			return mv;
		}
		
		
		
		
		
	
}
