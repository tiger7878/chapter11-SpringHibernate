package spittr.config;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author: monkey
 * @date: 2018/5/21 21:59
 */
@Configuration
@ComponentScan(basePackages = "spittr")
public class RepositoryConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript("schema.sql")
                .addScript("test-data.sql")
                .build();
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource){
//        LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
//        lsfb.setDataSource(dataSource);
//        lsfb.setPackagesToScan("spittr.domain");//告诉Spring扫描一个或多个包以查找域类，这些类通过注解的方式表明要使用Hibernate进行持久化
//
//        Properties pops=new Properties();
//        pops.setProperty("dialect","org.hibernate.dialect.H2Dialect");
//        lsfb.setHibernateProperties(pops);
//
//        SessionFactory sessionFactory=lsfb.getObject();
//
//        return sessionFactory;

        try {
            LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
            lsfb.setDataSource(dataSource);
            lsfb.setPackagesToScan("spittr.domain");
            Properties props = new Properties();
            props.setProperty("dialect", "org.hibernate.dialect.H2Dialect");
            lsfb.setHibernateProperties(props);
            lsfb.afterPropertiesSet();
            SessionFactory object = lsfb.getObject();
            return object;
        } catch (IOException e) {
            return null;
        }
    }


}
