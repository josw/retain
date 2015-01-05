package com.swj.stock.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.swj.stock.data.ChartRepository;
import com.swj.stock.data.Company;
import com.swj.stock.data.CompanyRepository;

@Controller
@Slf4j
public class Index {
	
	@Autowired
	private CompanyRepository repository;
	
	@Autowired
	private ChartRepository chartRepository;

	@RequestMapping({"/", ""})
	public ModelAndView index(final Company company) {
		
		List<Company> aaa = repository.findAll();
		
		ModelAndView mnv = new ModelAndView("index");
		mnv.addObject("data", aaa);
		
		log.info("idx 11 {}", aaa);
		return mnv;
	}

	@RequestMapping(value="/", params={"save"})
	public ModelAndView index(final Company company,  final BindingResult bindingResult, final ModelMap model) {
		
		log.info("idx 22 {} {}", bindingResult, model);
		
		return new ModelAndView("index");
	}

	@RequestMapping(value="/", params={"update_data"})
	public ModelAndView index(final Company company, String symbol) {
		
		log.info("idx 22x {} {}", symbol);
		
		return new ModelAndView("index");
	}

	@RequestMapping(value="/dig")
	@ResponseBody
	public String dig(String code) {
		
		
		log.info(">>>>>{}",chartRepository.findLatest(code));
		
		return "ook" + code;
		
	}
	
	
}
