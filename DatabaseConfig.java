package com.jstudyplanner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.jstudyplanner.repository")
public class DatabaseConfig {

    @Value("${hibernate.dialect}")
    private String HIBERNATE_DIALECT;

    @Value("${hibernate.show_sql}")
    private String HIBERNATE_SHOW_SQL;

    @Value("${hibernate.hbm2ddl.auto}")
    private String HIBERNATE_HBM2DDL_AUTO;

    @Autowired
    private DataSource dataSource;

            @Bean
            public LocalSessionFactoryBean sessionFactory() {

            LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
            sessionFactoryBean.setDataSource(dataSource);

            sessionFactoryBean.setMappingResources("mapping.hbm.xml");

            Properties hibernateProperties = new Properties();
            hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
            hibernateProperties.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
            hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
            sessionFactoryBean.setHibernateProperties(hibernateProperties);

             return sessionFactoryBean;
}

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager transactionManager =
                new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

}