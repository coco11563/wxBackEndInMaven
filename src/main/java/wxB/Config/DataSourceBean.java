package wxB.Config;


import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;
import wxB.DAO.wxReceive.wxReceiveTextJPA;
import wxB.DAO.wxUserJPA;

import javax.sql.DataSource;

/**
 * Created by coco1 on 2017/6/19.
 * 启动数据库连接的整体DAO bean 配置文件
 */

@Component
public class DataSourceBean {

//    @Bean
//    @Qualifier("JNDIDS")
//    public JndiObjectFactoryBean dataSourceJNDI() {
//        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
//        jndiObjectFactoryBean.setJndiName("jdbc/wx");
//        jndiObjectFactoryBean.setResourceRef(true);
//        jndiObjectFactoryBean.setProxyInterface(javax.sql.DataSource.class);
//        return jndiObjectFactoryBean;
//    }

    @Bean
    @Qualifier("DBCPDS")
    public BasicDataSource dataSourceDBCP(){
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://35.194.166.10:3306/wx?serverTimezone=UTC&characterEncoding=utf8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("xiaomeng7890");
        ds.setInitialSize(5);
        ds.setMaxTotal(10);
        return ds;
    }
    @Bean
    @Primary
    @Qualifier("JDBCDS")
    public DataSource dataSourceJDBC() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://35.194.166.10:3306/wx?serverTimezone=UTC&characterEncoding=utf8&useSSL=false");
        ds.setUsername("root");
        ds.setPassword("xiaomeng7890");
        return ds;

    }
    @Bean
    public wxUserJPA wxUserJPADAO() {
        return new wxUserJPA();
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public wxReceiveTextJPA wxReceiveTextJPA() {
        return new wxReceiveTextJPA();
    }
}
