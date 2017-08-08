package com.fdmgroup.springmoviedatabase.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.fdmgroup.springmoviedatabase.configuration.RootConfig;

public class SpringMovieDatabaseDEMO {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(RootConfig.class);

		for(String bean : applicationContext.getBeanDefinitionNames()){
			System.out.println(bean);
		}
		
	}

}
