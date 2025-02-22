package com.InterviewSpringboot.springbootproject.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
		entityManagerFactoryRef = "d2entityManagerFactory",
		basePackages = {
				"com.InterviewSpringboot.springbootproject.d2repository"
				}, transactionManagerRef = "d2TransactionManager"
)
public class Db2Config {

	@Bean(name = "d2dataSource")
	@ConfigurationProperties(prefix = "spring.user.datasource")
	public DataSource dataSource()
	{
		return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "d2entityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
		 @Qualifier("d2dataSource")	DataSource dataSource)
	{
		
		HashMap<String,Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		
		return builder.dataSource(dataSource)
				.properties(properties)
				.packages("com.InterviewSpringboot.springbootproject.d2model")
				.persistenceUnit("db2")
				.build();
		
	}
	
	@Bean(name="d2TransactionManager")
	public PlatformTransactionManager transactionManager(@Qualifier("d2entityManagerFactory") EntityManagerFactory entityManagerFactory)
	{
		return new JpaTransactionManager(entityManagerFactory);
	}
}
