package edu.bupt.slms.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author: 韩 宁
 * @create: 2020/04/03 21:35:41
 */
@Configuration
public class ActivitiConfig extends AbstractProcessEngineAutoConfiguration {
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource(){
        return new DruidDataSource();
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.activiti")
    public DataSource activitiDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(
            PlatformTransactionManager platformTransactionManager,
            SpringAsyncExecutor springAsyncExecutor) throws IOException {
        return baseSpringProcessEngineConfiguration(
                activitiDataSource(),
                platformTransactionManager,
                springAsyncExecutor
        );
    }

}
