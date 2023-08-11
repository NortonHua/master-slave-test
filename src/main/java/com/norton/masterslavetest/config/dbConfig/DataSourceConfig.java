package com.norton.masterslavetest.config.dbConfig;

import jakarta.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author kevin.zhang
 * @date 2023/8/11 16:39
 */
@Configuration
public class DataSourceConfig {

    private final Logger logger = LoggerFactory.getLogger(DataSourceConfig.class);

    @Resource
    PropertiesConf propertiesConf;

    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    @ConfigurationProperties("spring.datasource.master")
    public DataSource primaryDataSource() {
        DataSource masterDataSource = DataSourceBuilder.create().type(propertiesConf.getDataSourceType()).build();
        logger.info("load master data source :{}", masterDataSource);
        return masterDataSource;
    }

    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    @ConfigurationProperties("spring.datasource.slave")
    public DataSource secondaryDataSource() {
        DataSource slaveDataSource = DataSourceBuilder.create().type(propertiesConf.getDataSourceType()).build();
        logger.info("load slave data source :{}", slaveDataSource);
        return slaveDataSource;
    }
}
