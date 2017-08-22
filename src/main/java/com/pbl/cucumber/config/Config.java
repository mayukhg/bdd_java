package com.pbl.cucumber.config;
import lombok.Getter;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven Satelle on 08/08/2017.
 */
@Configuration
public class Config {

    @Getter
    @Value("${merch.catalogFile}")
    private String catalogFileLocation;

    @Getter
    @Value("${talend.script}")
    private String talendScript;

    @Bean
    public static PropertySourcesPlaceholderConfigurer properties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean(destroyMethod = "close")
    public DataSource pblDataSource(@Value("${db.driver}") String driver, @Value("${db.url}") String db_url,
                                         @Value("${db.username}") String user, @Value("${db.password}") String dbPassword) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(db_url);
        dataSource.setUsername(user);
        dataSource.setPassword(dbPassword);
        return dataSource;
    }

}
