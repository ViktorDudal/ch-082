package com.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value = { @ComponentScan("com.dao"),
      @ComponentScan("com.service") })
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();

        Properties props = new Properties();
        props.put(DRIVER, env.getProperty("postgresql.driver"));
        props.put(URL, env.getProperty("postgresql.url"));
        props.put(USER, env.getProperty("postgresql.user"));
        props.put(PASS, env.getProperty("postgresql.password"));

        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        props.put(DIALECT, env.getProperty("hibernate.dialect"));

        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
        props.put(C3P0_ACQUIRE_INCREMENT,
                env.getProperty("hibernate.c3p0.acquire_increment"));
        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("com.model");

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());

        return transactionManager;
    }

}
