package com.sahil.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.sahil.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {

	// set up a variable to hold the properties
	
	@Autowired
	private Environment env; // this will hold the data read by properties file
	
	// set up a logger
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	
	// Define a bean for ViewResolver
	
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		
		vr.setPrefix("/WEB-INF/view/");
		vr.setSuffix(".jsp");
		
		return vr;
		
		
	}
	
	// define a bean for our security datasource
	
	@Bean
	public DataSource securityDataSource(){
		
		// Create connection pool
		ComboPooledDataSource securityDataSource = 
				new ComboPooledDataSource();
		
		// Set JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}
		
		// Log the connection properties
		// Just to make sure that we're reading the right file
		logger.info(">>>>>>> jdbc.url= " + env.getProperty("jdbc.url"));
		logger.info(">>>>>>> jdbc.user= " + env.getProperty("jdbc.user"));
		
		// Set database connection props
		
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		
		// set connection pool props
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.initialPoolSize"));
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.minPoolSize"));
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.maxPoolSize"));
		
		securityDataSource.setInitialPoolSize(
				getIntProperty("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	// Need a helper method
	// read env property and convert it to integer
	
	private int getIntProperty(String propName) {
		
		String propVal = env.getProperty(propName);
		
		return Integer.parseInt(propVal);
		
	}
	
	
	
	
	
	
	
	
	
	
}
