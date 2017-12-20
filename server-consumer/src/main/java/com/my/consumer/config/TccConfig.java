package com.my.consumer.config;

import com.alibaba.druid.pool.DruidDataSource;

import org.bytesoft.bytejta.supports.jdbc.LocalXADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * <p></p>
 *
 * @author ooooow
 * @Since 2017/12/19
 */
@Configuration
public class TccConfig {

    @Bean
    DataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        LocalXADataSource localXADataSource = new LocalXADataSource();
        localXADataSource.setDataSource(dataSource);
        return localXADataSource;
    }

    @Bean
    JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
