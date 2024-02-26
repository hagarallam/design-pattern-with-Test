package com.example.restTemplate.designPattern;


import com.example.restTemplate.designPattern.ApiConsumersFactory.RestTemplateFactory;
import com.example.restTemplate.designPattern.rest.caller.ResponseWrapper;
import com.example.restTemplate.designPattern.rest.caller.RestCaller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

@SpringBootApplication
public class RestTemplateDesignPatternApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplateDesignPatternApplication.class, args);
        RestCaller<String,String,String> restCaller = new RestTemplateFactory<String,String,String>().getInstance();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        ResponseWrapper<String,String> userString  = restCaller.performGet("http://jsonplaceholder.typicode.com/posts", httpHeaders,
                new ParameterizedTypeReference<String>(){},new String("Error !!!"));
        System.out.println(userString.getResponseType().getBody());
    }

}
