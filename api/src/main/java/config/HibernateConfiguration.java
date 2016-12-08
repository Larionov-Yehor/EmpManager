package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
/**
 * Created by employee on 12/7/16.
 */
@Configuration
@EnableTransactionManagement

public class HibernateConfiguration {

    private static Util propsHandler = new Util(System.getenv("DATABASE_URL"));

    @Bean
    public DataSource dataSource() {

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername(propsHandler.getUserName());
        dataSource.setPassword(propsHandler.getUserPass());
        dataSource.setUrl(propsHandler.getUrl());
        dataSource.setDriverClassName(propsHandler.getDriverClass());


        return dataSource;
    }
    @Bean
    public LocalSessionFactoryBean sessionFactory() {

        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("employee.model");
        Properties properties = new Properties();
        properties.put("hibernate.dialect", propsHandler.getDialect());
        properties.put("hibernate.show_sql", propsHandler.getShowSql());
        properties.put("hibernate.hbm2ddl.auto", propsHandler.getHbm2ddlAuto());
        sessionFactory.setHibernateProperties(properties);

        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }


}