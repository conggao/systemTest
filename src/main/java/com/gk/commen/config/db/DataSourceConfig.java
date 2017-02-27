package com.gk.commen.config.db;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import javax.sql.DataSource;

/**
 * Created by yons on 2017/2/27.
 */
public class DataSourceConfig {
    @Bean(name = "jsonDataSource")
    @Qualifier("jsonDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.json")
    public DataSource jsonDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "masterDataSource")
    @Qualifier("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().build();
    }


}
