package com.swj.stock.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.swj.stock.data.Company;

@Controller
@Slf4j
public class Index {

	@RequestMapping({"/", ""})
	public ModelAndView index(final Company company) {
		
		log.info("hahahaha");
		return new ModelAndView("index");
	}
	
	
}
