package com.belal.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.belal.ecommercebackend.dao.CategoryDAO;
import com.belal.ecommercebackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;

	// -----------------------------ViewResolver--------------------------------------------------
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());

		mav.addObject("userClickHome", true);
		return mav;
	}

	@RequestMapping(value = "/about")
	public ModelAndView about() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "About");
		mav.addObject("userClickAbout", true);
		return mav;
	}

	@RequestMapping(value = "/contact")
	public ModelAndView contact() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Contact");
		mav.addObject("userClickContact", true);
		return mav;
	}

	/*
	 * methods to load all the products and based on category
	 */
	@RequestMapping(value = "show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "All Products");

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());

		mav.addObject("userClickAllProducts", true);
		return mav;
	}

	@RequestMapping(value = "show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;
		category = categoryDAO.get(id);

		mav.addObject("title", category.getName());

		// passing the list of categories
		mav.addObject("categories", categoryDAO.list());

		// passing the single category object
		mav.addObject("category", category);

		mav.addObject("userClickCategoryProducts", true);
		return mav;
	}

	// --------------------------------@RequestParam-----------------------------------------------
//	@RequestMapping(value = "/test")
//	public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) {
//		if (greeting == null) {
//			greeting = "No greeting used";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("greeting", greeting);
//		return mav;
//	}

	// --------------------------------@PathVariable-----------------------------------------------
//	@RequestMapping(value = "/ttest/{greeting}")
//	public ModelAndView ttest(@PathVariable("greeting") String greeting) {
//		if (greeting == null) {
//			greeting = "No greeting used";
//		}
//		ModelAndView mav = new ModelAndView("page");
//		mav.addObject("greeting", greeting);
//		return mav;
//	}
}
