package com.gz.manager.configure;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataConfigure {

    /**
     * 配置数据源
     * @param env
     * @return
     */
    @Bean(name = "datasource")
    public DataSource getDataSource(Environment env) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(env.getProperty("spring.datasource.url"));
        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dataSource.setUsername(env.getProperty("spring.datasource.data-username"));
        dataSource.setPassword(env.getProperty("spring.datasource.data-password"));

        return dataSource;
    }
}
