package edu.bupt.slms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 韩 宁
 * @create: 2020/04/03 07:57:24
 */
@Configuration
@EnableSwagger2
@Profile({"dev", "test"})
public class SwaggerConfig {
    @Bean
    Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("edu.bupt.slms.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .description("路灯管理系统接口描述")
                        .title("API测试文档")
                        .contact(new Contact("韩宁", null, "706697727@qq.com"))
                        .version("v1.0")
                        .build())
                .securitySchemes(security());

    }

    private List<ApiKey> security() {
        List<ApiKey> list = new ArrayList<>();
        list.add(new ApiKey("token","token","header"));
        return list;
    }
}
