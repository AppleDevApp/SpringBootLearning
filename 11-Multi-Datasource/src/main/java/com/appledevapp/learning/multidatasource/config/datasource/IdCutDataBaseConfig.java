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
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * 配置数据源和Mybatis包扫描
 * primary定义为默认数据源
 */
@Configuration
@MapperScan(basePackages = {"com.appledevapp.learning.multidatasource.persistence.idcutdb"}, sqlSessionTemplateRef = "idcutSqlSessionTemplate", nameGenerator = UniqueNameGenerator.class)
public class IdCutDataBaseConfig {

    @Primary
    @Bean(name = "idcutDataSource")
    @ConfigurationProperties(prefix = "datasource.idcutdb")
    public DataSource idcutDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "idcutTransactionManager")
    public DataSourceTransactionManager idcutTransactionManager(@Qualifier("idcutDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Primary
    @Bean(name = "idcutSqlSessionFactory")
    public SqlSessionFactory idcutSqlSessionFactory(@Qualifier("idcutDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("config.model");

        return factoryBean.getObject();
    }

    @Primary
    @Bean(name = "idcutSqlSessionTemplate")
    public SqlSessionTemplate idcutSqlSessionTemplate(@Qualifier("idcutSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
