package com.sureal;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Properties;


/**
 * @author Wuxx
 * @date 2019/6/4 11:37
 * @PackageName PACKAGE_NAME
 * @ClassName com.sureal.PlSpringBootApplication
 * @Description
 */
@SpringBootApplication
public class PlSpringBootApplication {
    public static void main(String[] args) {
        SpringApplication.run(PlSpringBootApplication.class, args);
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("dialect", "mysql");
        pageHelper.setProperties(properties);

//        new SqlSessionFactoryBean().setPlugins(new Interceptor[]{(Interceptor) pageHelper});
        return pageHelper;
    }
}
