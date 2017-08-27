package com.netease.assignment.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * Description :
 *
 * @author lizhi lizhi1@corp.netease.com
 * @version Create on 2017-08-27
 */
@Configuration
public class BeanDefinition {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {

        return DataSourceBuilder.create().build();
    }

}
