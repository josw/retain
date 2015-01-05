package com.swj.stock.configuration;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
		dataSource.setUrl("jdbc:mysql://localhost:3306/stock?UseUnicode=true&amp;characterEncoding=utf8&amp;connectionCollation=utf8_general_ci");
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

	@SuppressWarnings("serial")
	private Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto", "update");
				setProperty("hibernate.dialect",
						"org.hibernate.dialect.MySQLDialect");
				setProperty("hibernate.globally_quoted_identifiers", "true");
				setProperty("hibernate.connection.CharSet", "UTF-8");
				setProperty("hibernate.connection.characterEncoding", "UTF-8");
				setProperty("hibernate.connection.useUnicode", "true");
				setProperty("hibernate.show_sql" ,"true");
			}
		};
	}

}
