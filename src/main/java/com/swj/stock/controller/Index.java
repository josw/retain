package com.swj.stock.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swj.stock.data.Company;

@Controller
@Slf4j
public class Index {

	@RequestMapping({"/", ""})
	public ModelAndView index(final Company company) {
		
		log.info("idx 1");
		return new ModelAndView("index");
	}

	@RequestMapping(value="/", params={"save"})
	public ModelAndView index(final Company company,  final BindingResult bindingResult, final ModelMap model) {
		
		log.info("idx 2 {} {}", bindingResult, model);
		
		return new ModelAndView("index");
	}

	
	
}
