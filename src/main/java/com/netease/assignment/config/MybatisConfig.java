package com.netease.assignment.config;

import com.github.abel533.mapperhelper.MapperInterceptor;
import com.netease.assignment.consts.PackageConsts;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Description :
 *
 * @author lizhi lizhi1@corp.netease.com
 * @version Create on 2017-08-27
 */
@Configuration
public class MybatisConfig {

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);

        //通用mapper
        MapperInterceptor mapperInterceptor = new MapperInterceptor();
        Properties pros = new Properties();
        pros.setProperty("mappers", PackageConsts.DAO_PACKAGE);
        pros.setProperty("IDENTITY", "MYSQL");
        pros.setProperty("notEmpty", "true");
        mapperInterceptor.setProperties(pros);

        bean.setPlugins(new Interceptor[]{mapperInterceptor});

        bean.setTypeAliasesPackage(PackageConsts.DOMAIN_PACKAGE);

        //添加mapperXML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        bean.setMapperLocations(resolver.getResources("classpath:mapper/*.xml"));

        return bean.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setBasePackage(PackageConsts.DAO_PACKAGE);
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");

        return configurer;
    }

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
