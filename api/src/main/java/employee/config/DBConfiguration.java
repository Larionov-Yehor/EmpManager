package employee.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.net.URISyntaxException;
import java.util.Properties;


@EnableWebMvc
@EnableAutoConfiguration
@EnableJpaRepositories("employee")
@Configuration
public class DBConfiguration {

    @Bean
    public Util getPropertyHandler() throws URISyntaxException {
        return new Util(System.getenv("DATABASE_URL"));
    }
    @Bean
    public DataSource getDataSource() throws URISyntaxException {
        final DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getPropertyHandler().getDriverClass());
        dataSource.setUrl(getPropertyHandler().getUrl());
        dataSource.setUsername(getPropertyHandler().getUserName());
        dataSource.setPassword(getPropertyHandler().getUserPass());
        return dataSource;
    }

    @Bean
    public Properties getHibernateProperties() throws URISyntaxException {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", getPropertyHandler().getDialect());
        properties.put("hibernate.show_sql", getPropertyHandler().getShowSql());
        properties.put("hibernate.hbm2ddl.auto", getPropertyHandler().getHbm2ddlAuto());
        return properties;
    }

    @Bean
    public EntityManager entityManager() throws URISyntaxException {
        return entityManagerFactory().getObject().createEntityManager();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(getDataSource());
        em.setPackagesToScan("employee");

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(getHibernateProperties());
        return em;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }

}