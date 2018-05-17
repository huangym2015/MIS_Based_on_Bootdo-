package com.bootdo.common.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ian on 2018/5/16.
 */

@Configuration
@AutoConfigureAfter(DataSourceConfig.class)
public class MyBatisMapperScannerConfig {
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurationMysql() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("mysqlSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.bootdo.**.dao");
        return mapperScannerConfigurer;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurationOracle() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("oracleSessionFactory");
        mapperScannerConfigurer.setBasePackage("com.bootdo.**.oracledao");
        return mapperScannerConfigurer;
    }
}
