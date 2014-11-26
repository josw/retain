package com.swj.stock.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.swj.stock.data.db;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses=db.class)
public class PersistenceConfig {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306");
		dataSource.setUsername("root");
		// dataSource.setPassword("pass");

		return dataSource;
	}
	
	 @Bean
	  public EntityManagerFactory entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);

	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.swj.stock");
	    factory.setDataSource(dataSource());
	    factory.setJpaProperties(hibernateProperties());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }

	  @Bean
	  public PlatformTransactionManager transactionManager() {

	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
	
//	@Bean
//	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		vendorAdapter.setGenerateDdl(Boolean.TRUE);
//		vendorAdapter.setShowSql(Boolean.TRUE);
//		factory.setDataSource(dataSource());
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setJpaProperties(hibernateProperties());
//		factory.afterPropertiesSet();
//		factory.setPackagesToScan("com.swj.stock.data");
//		factory.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
//		return factory;
//	}
////
////	@Bean
////	public LocalSessionFactoryBean sessionFactory() {
////		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
////		sessionFactory.setDataSource(getDataSource());
////		sessionFactory
////				.setPackagesToScan(new String[] { "org.baeldung.spring.persistence.model" });
////		sessionFactory.setHibernateProperties(hibernateProperties());
////
////		return sessionFactory;
////	}
//
//	@Bean
//	@Autowired
//	public HibernateTransactionManager transactionManager(
//			SessionFactory sessionFactory) {
//		HibernateTransactionManager txManager = new HibernateTransactionManager();
//		txManager.setSessionFactory(sessionFactory);
//
//		return txManager;
//	}
//
//	@Bean
//	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
//		return new PersistenceExceptionTranslationPostProcessor();
//	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", "create-drop");
				setProperty("hibernate.dialect",
						"org.hibernate.dialect.MySQL5Dialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
			}
		};
	}

}
