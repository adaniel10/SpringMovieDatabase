package com.fdmgroup.springmoviedatabase.configuration;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration		//Indicates class declares one or more beans
@EnableJpaRepositories(basePackages = {"com.fdmgroup.springmoviedatabase"})	//Enables JPA repositories
@EnableTransactionManagement	//Enables spring annotation driven transactions
public class JPAPersistenceConfig {

	@Bean																			//creates a dataSource for connecting to a database
	public DataSource dataSource(){
		DriverManagerDataSource mydatasource =  new DriverManagerDataSource();
		mydatasource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		mydatasource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		mydatasource.setUsername("Trainee1");
		mydatasource.setPassword("!QAZSE4");
		return mydatasource;
	}
	
	@Bean																			//bean for Spring JPA
	  public EntityManagerFactory entityManagerFactory() {

	    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	    vendorAdapter.setGenerateDdl(true);											//create tables automatically
	  
	    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
	    factory.setJpaVendorAdapter(vendorAdapter);
	    factory.setPackagesToScan("com.fdmgroup.springmoviedatabase.model");
	    factory.setDataSource(dataSource());
	    factory.afterPropertiesSet();

	    return factory.getObject();
	  }

	
	  @Bean
	  public PlatformTransactionManager transactionManager() {
	    JpaTransactionManager txManager = new JpaTransactionManager();
	    txManager.setEntityManagerFactory(entityManagerFactory());
	    return txManager;
	  }
	
}



