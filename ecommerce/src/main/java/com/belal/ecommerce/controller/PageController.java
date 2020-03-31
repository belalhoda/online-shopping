package com.belal.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {

	// -----------------------------ViewResolver--------------------------------------------------
	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("page");
		mav.addObject("title", "Home");
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
