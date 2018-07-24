package com.appledevapp.learning.multidatasource.config.datasource;

import com.appledevapp.learning.multidatasource.extension.UniqueNameGenerator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 配置数据源和Mybatis包扫描
 */
@Configuration
@MapperScan(basePackages = {"com.appledevapp.learning.multidatasource.persistence.etemaldb"}, sqlSessionTemplateRef = "etemalSqlSessionTemplate", nameGenerator = UniqueNameGenerator.class)
public class EtemalDataBaseConfig {

    @Bean(name = "etemalDataSource")
    @ConfigurationProperties(prefix = "datasource.etemaldb")
    public DataSource etemalDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "etemalTransactionManager")
    public DataSourceTransactionManager etemalTransactionManager(@Qualifier("etemalDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "etemalSqlSessionFactory")
    public SqlSessionFactory etemalSqlSessionFactory(@Qualifier("etemalDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("config.model");

        return factoryBean.getObject();
    }

    @Bean(name = "etemalSqlSessionTemplate")
    public SqlSessionTemplate etemalSqlSessionTemplate(@Qualifier("etemalSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


}
