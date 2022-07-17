package com.medicalcenter.sistema.business;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.medicalcenter.sistema.business.entities.Administrator;
import com.medicalcenter.sistema.business.entities.Doctor;
import com.medicalcenter.sistema.business.entities.Specialty;
import com.medicalcenter.sistema.business.entities.User;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages="com.medicalcenter.sistema.business.repositories")
@ComponentScan(basePackages="com.medicalcenter.sistema.services")
public class SistemaBusinessConfig {

	@Autowired
	Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName(env.getProperty("db.driver"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.username"));
		ds.setPassword(env.getProperty("db.password"));		

		return ds;
	}
	
	//factoria de entidades
	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		 	LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		 	
	        emf.setDataSource(dataSource());
	        //----------------------------------------------------------------------------
	        //Scaneo de Tablas a Entidades
	        emf.setPackagesToScan(User.class.getPackage().getName());
	        emf.setPackagesToScan(Specialty.class.getPackage().getName());
	        emf.setPackagesToScan(Administrator.class.getPackage().getName());
	        emf.setPackagesToScan(Doctor.class.getPackage().getName());
	        //-----------------------------------------------------------------------------
	        HibernateJpaVendorAdapter hibernateJpa = new HibernateJpaVendorAdapter();
	        hibernateJpa.setDatabase(Database.POSTGRESQL);
	        hibernateJpa.setDatabasePlatform(env.getProperty("hibernate.dialect"));
	        hibernateJpa.setGenerateDdl(env.getProperty("hibernate.generateDdl", Boolean.class));
	        hibernateJpa.setShowSql(env.getProperty("hibernate.show_sql", Boolean.class));       
	        emf.setJpaVendorAdapter(hibernateJpa);
	        
	        Properties jpaProperties = new Properties();
	        jpaProperties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
	        jpaProperties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
	        jpaProperties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));
	        emf.setJpaProperties(jpaProperties);	        
	        
	        return emf;
	}
	
	//motor de procesamiento de datos
	 @Bean
	 public JpaTransactionManager transactionManager() {
	        JpaTransactionManager txnMgr = new JpaTransactionManager();
	        txnMgr.setEntityManagerFactory(entityManagerFactory().getObject());
	        return txnMgr;
	 }
	
}
