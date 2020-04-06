package com.pro.contact.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.pro.contact.dao.ContactDao;
import com.pro.contact.dao.ContactDaoImp;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.pro.contact")
public class SpringMvcConfig {

	@Bean
	public DataSource getDataSource()
	{
		DriverManagerDataSource dmds=new DriverManagerDataSource();
		dmds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dmds.setUrl("jdbc:mysql://localhost:3306/contactDb");
		dmds.setUsername("root");
		dmds.setPassword("root");
		
		return dmds;

	}
	
	@Bean
	public ViewResolver getViewResolver()
	{
		InternalResourceViewResolver vw=new InternalResourceViewResolver();
		vw.setPrefix("/WEB-INF/views/");
		vw.setSuffix(".jsp");
		return null;
		
	}
	
	@Bean
	public ContactDao getContactDao()
	{
		return new ContactDaoImp(getDataSource());
		
	}
	
}
