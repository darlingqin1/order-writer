package com.leiyi.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.leiyi.mapper", sqlSessionFactoryRef = "order1SqlSessionFactory")
public class Order1DataSourceConfig {

    @Bean(name = "order1DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.dynamic.datasource.order1")
    public DataSource order1DataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "order1SqlSessionFactory")
    public SqlSessionFactory order1SqlSessionFactory(@Qualifier("order1DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        return factoryBean.getObject();
    }
}