package com.bootdo.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by ian on 2018/5/16.
 * 默认的mysql的数据源在DruidDBConfig中已配置，
 * 多数据源配置，如不需要，请讲oracle数据源注释掉,
 */
@Configuration
@EnableTransactionManagement
public class DataSourceConfig {

    private static final Logger log = LoggerFactory.getLogger(DataSourceConfig.class);


    @Bean(name = "oracleDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.oracle")
    public DataSource primaryDataSource() {
        log.info("-------------------- oracleDataSource init ---------------------");
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean(name = "oracleSessionFactory")
    public SqlSessionFactory oracleSessionFactory(@Qualifier("oracleDataSource") DataSource dataSource) throws IOException {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        //根据此目录寻找Mapper.xml文件
        bean.setMapperLocations(
                new PathMatchingResourcePatternResolver()
                        .getResources("classpath*:mybatis/**/*Mapper.xml"));

        try {
            SqlSessionFactory sqlSessionFactory = bean.getObject();
            //设置驼峰
            sqlSessionFactory.getConfiguration().setMapUnderscoreToCamelCase(true);
            return sqlSessionFactory;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
