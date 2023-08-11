package com.norton.masterslavetest.config.dbConfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * @author kevin.zhang
 * @date 2023/8/11 16:38
 */
@Component
@Order(-99)
public class PropertiesConf {

    @Value("${spring.datasource.type}")
    private Class<? extends DataSource> dataSourceType;


    public Class<? extends DataSource> getDataSourceType() {
        return dataSourceType;
    }

    public void setDataSourceType(Class<? extends DataSource> dataSourceType) {
        this.dataSourceType = dataSourceType;
    }
}
