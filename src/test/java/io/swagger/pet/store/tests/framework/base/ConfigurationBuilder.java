package io.swagger.pet.store.tests.framework.base;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RedirectConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.swagger.petstore.GsonObjectMapper;

import java.util.Arrays;

public class ConfigurationBuilder {

    public RequestSpecBuilder getRequestSpecBuilder() {
        return new RequestSpecBuilder().setConfig(RestAssured.config()
                .objectMapperConfig(ObjectMapperConfig.objectMapperConfig().defaultObjectMapper(GsonObjectMapper.gson()))
                .redirect(RedirectConfig.redirectConfig().followRedirects(false))
                .sslConfig(SSLConfig.sslConfig().relaxedHTTPSValidation()))
                .setBaseUri("http://petstore.swagger.io:80/v2")
                .addFilters(Arrays.asList(
                        new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

}
