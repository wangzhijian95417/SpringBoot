package com.wzj.springbootswagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestHeader;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhijian.wang
 * @package com.wzj.springbootswagger2.config
 * @description: Swagger UI 配置类
 * @date 2020/10/19 15:17
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * Swagger API 接口扫描包路径
     */
    private static final String SWAGGER_SCAN_BASE_PACKAGE = "com.wzj.springbootswagger2";

    /**
     * Swagger API 接口版本
     */
    private static final String VERSION="1.0.0";

    /**
     * Swagger API 接口标题
     */
    private static final String TITLE="SWAGGER 2";

    /**
     * Swagger API 接口描述
     */
    private static final String DESCRIPTION="这是一个 Swagger2 测试接口文档";

    /**
     * Swagger API 接口服务地址
     */
    private static final String TERMS_OF_SERVICE_URL="https://www.biadu.com";


    /**
     * Swagger API 接口作者
     */
    private static final String CONTACT="WangZhiJian";


    /**
     * Swagger API 接口许可地址
     */
    private static final String LICENSE_URL="https://www.biadu.com";


    /**
     * Swagger API 接口许可
     */
    private static final String LICENSE="WangZhiJian";

    @Bean
    public Docket createRequestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title(TITLE)
                .description(DESCRIPTION)
                .version(VERSION)
                .termsOfServiceUrl(TERMS_OF_SERVICE_URL)
                .contact(CONTACT)
                .licenseUrl(LICENSE_URL)
                .license(LICENSE)
                .build();
    }
}
