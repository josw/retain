package com.swj.stock.configuration;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class StockWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[]{StockServiceConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{StockWebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}
	
	@Override
	protected Filter[] getServletFilters() {
		return super.getServletFilters();
	}
	

}
