package com.example.resttemplatedesignpattern;

import com.example.restTemplate.designPattern.ApiConsumersFactory.RestTemplateFactory;
import com.example.restTemplate.designPattern.rest.caller.ResponseWrapper;
import com.example.restTemplate.designPattern.rest.caller.RestCaller;
import com.example.restTemplate.designPattern.rest.caller.RestTemplateService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {com.example.restTemplate.designPattern.RestTemplateDesignPatternApplication.class})
class RestTemplateDesignPatternApplicationTests {


    @Autowired
    RestTemplateFactory<String,String,String> restTemplateFactory;

    @Autowired
    RestCaller<String,String,String> restCaller;

    @Test
    void contextLoads() {
    }


    @Test
    void testFactory(){
        RestCaller<String,String,String> restCaller = new RestTemplateFactory<String,String,String>().getInstance();
        assertThat(restCaller).isNotNull();
    }

    @Test
    void testFactory2(){
        RestCaller<String,String,String> restCaller = new RestTemplateFactory<String,String,String>().getInstance();
        assertThat(restCaller).isInstanceOf(RestCaller.class);
    }


    @Test
    void testAutoWiringForFactory(){
        assertThat(restTemplateFactory).isNotNull();
    }

    @Test
    void testGetInstanceMethod(){
        RestCaller<String,String,String> restCaller = restTemplateFactory.getInstance();
        assertThat(restTemplateFactory).isNotNull();
    }

    @Test
    void testPerformGet(){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        restCaller = new RestTemplateFactory<String,String,String>().getInstance();
        ResponseWrapper responseWrapper = restCaller.performGet("http://jsonplaceholder.typicode.com/posts", httpHeaders,
                new ParameterizedTypeReference<String>(){},new String("Error !!!"));
        assertThat(responseWrapper.getResponseType().getBody()).isNotNull();
    }
}
