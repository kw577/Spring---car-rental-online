package net.kzn.onlineshopping.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pj.projekt.backend.dao.CategoryDAO;
import pj.projekt.backend.dao.EquipmentDAO;
import pj.projekt.backend.dao.ReservationDAO;
import pj.projekt.backend.daoimpl.ReservationDAOImpl;
import pj.projekt.backend.dto.Category;
import pj.projekt.backend.dto.Equipment;
import pj.projekt.backend.dto.Reservation;
import pj.projekt.backend.dto.ReservationTemp;

@Controller
public class PageController {

	@Autowired // polaczenie z projektem Backendu 
	private CategoryDAO categoryDAO;
	
	@Autowired // polaczenie z projektem Backendu 
	private EquipmentDAO equipmentDAO;
	
	@Autowired   
	private ReservationDAO reservationDAO;
	
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

			
			// tworzenie nowego obiektu ktory ma zostac dodany do bazy danych
			// tworzenie nowej rezerwacji - obiekt pomocniczy
			ReservationTemp newReservation = new ReservationTemp();
			mv.addObject("reservation", newReservation);
			
			return mv;
		}
		
		
		
		// dodawanie nowego produktu poprzez formularz administratora
		@RequestMapping(value = "/cart/add/id/{id}/equipment", method = RequestMethod.POST) 
		public String handleProductSubmission(@PathVariable int id, @ModelAttribute("reservation") ReservationTemp tempReservation) { // @ModelAttribute("product") - jak w manageProducts.jsp

			// TEST ////////////////////////////////////////////////////
			//tempReservation.setEquipment_id(id);
			//System.out.println("\n\n\n\n\n\nDane nowej rezerwacji");
			//System.out.println("id: " + tempReservation.getId());
			//System.out.println("eq id: " + tempReservation.getEquipment_id());
			//System.out.println("name: " + tempReservation.getUser_name());
			//System.out.println("surname: " + tempReservation.getUser_surname());
			//System.out.println("eamil: " + tempReservation.getUser_email());
			//System.out.println("phone: " + tempReservation.getUser_phone());
			//System.out.println("total price: " + tempReservation.getTotal_price());
			//System.out.println("start: " + tempReservation.getReservation_start());
			//System.out.println("end: " + tempReservation.getReservation_end());
			//////////////////////////////////////////////////////////
			

			
			
			// konwersja daty
			//if(Pattern.matches("(\\d{3}-){2}\\d{3}", tempReservation.getReservation_start())) System.out.println("\nPoprawny format danych");
			int wynik = 1;			
			if(tempReservation.getReservation_start().matches("\\d{4}-\\d{2}-\\d{2}") && tempReservation.getReservation_end().matches("\\d{4}-\\d{2}-\\d{2}")) 
			{
				System.out.println("\n\n\n\n#######################");
				System.out.println("\nPoprawny format danych - dokonano konwersji na string - czas");
				
				Timestamp rentStartTs=ReservationDAOImpl.convertStringToTimestamp(tempReservation.getReservation_start() + " 00:00:00:000");
				Timestamp rentEndTs=ReservationDAOImpl.convertStringToTimestamp(tempReservation.getReservation_end()  + " 23:59:59:999");
				
				
				if(rentStartTs == null || rentEndTs == null) {
					wynik = 0;
					System.out.println("Bledny format daty");
				}
				
				if(rentStartTs.before(new Timestamp(System.currentTimeMillis()))) {
					wynik = 0;
					System.out.println("Data nie moze byc starsza niz aktualna");
					// message
				}
				
				if(rentStartTs.after(rentEndTs)) {
					wynik = 0;
					System.out.println("Data koncowa musi byc starsza niz poczatkowa");
					// messsage
				}
				
			
				
				// sprawdzenie czy w tym terminie nie ma juz zrobionej rezerwacji
				if(wynik == 1) {
					List<Reservation> temp = reservationDAO.listReservationByDate(tempReservation.getReservation_start(),tempReservation.getReservation_end());
					List<Integer> rentedEquipment = new ArrayList<Integer>();
					rentedEquipment.add(0);
					
					for (Reservation item : temp) {
						rentedEquipment.add(item.getEquipment_id());
					    
					}
					
					if(rentedEquipment.contains(id)) {
						wynik = 0;
						System.out.println("Na ten pojazd jest juz zrobiona rezerwacja w tym terminie");
					}
					
					// messsage
				}
				
				
				if(tempReservation.getUser_name() == "" || tempReservation.getUser_surname() == "" || tempReservation.getUser_email() == "") {
					wynik = 0;
					System.out.println("Formuarz zawiera puste pola danych uzytkownika");
				}
				
				if(!tempReservation.getUser_phone().matches("\\d{7,11}")) {
					wynik = 0;
					System.out.println("Niepoprawny numer telefonu");
					
				}
				
				
				
					
				
				
				
				//new Timestamp(System.currentTimeMillis());
				
				if(wynik == 1) {
				
				Reservation nReservation = new Reservation();
				
				nReservation.setEquipment_id(id);
				nReservation.setUser_name(tempReservation.getUser_name());
				nReservation.setUser_surname(tempReservation.getUser_surname());
				nReservation.setUser_email(tempReservation.getUser_email());
				nReservation.setUser_phone(tempReservation.getUser_phone());
								
				nReservation.setReservation_start(rentStartTs);
				nReservation.setReservation_end(rentEndTs);
				
				
				//
				int totalAmount = (int)(Math.ceil((rentEndTs.getTime()-rentStartTs.getTime())/(1000*60*60*24)));
				
				
				
				
				
				nReservation.setTotal_price(totalAmount * (int)equipmentDAO.get(id).getUnitPrice());
				
				
				System.out.println("\nWypozycznie trwa dni: " + totalAmount);
				System.out.println("\nWypozycznie bedzie kosztowalo: " + (totalAmount * equipmentDAO.get(id).getUnitPrice()));
				
				
				
		
			
				
				reservationDAO.add(nReservation);
				
				
				
				
				
				
				System.out.println("\n--------------------------");
				System.out.println("\nUtworzono nowa rezerwacje");
				//nReservation.toString();
				System.out.println("\n--------------------------");
				}
				
				
				
				
			} else {
				System.out.println("\nNiepoprawny format daty");
				wynik = 0;
			}
			

			if(wynik == 0) {
				return "redirect:/cart/add/id/{id}/equipment";
			}
			
			else return "redirect:/home";
			//return "redirect:/manage/products?operation=product";
		}
		
		
		
	
}
