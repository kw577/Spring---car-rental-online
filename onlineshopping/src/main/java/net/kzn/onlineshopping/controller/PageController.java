package net.kzn.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pj.projekt.backend.dao.CategoryDAO;
import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dto.Category;

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

			mv.addObject("userClickCategoryOffer", true);
			return mv;

		}


		
	
}
