package com.example.restTemplate.designPattern.ApiConsumersFactory;


import com.example.restTemplate.designPattern.rest.caller.RestCaller;
import com.example.restTemplate.designPattern.rest.caller.RestTemplateService;
import org.springframework.stereotype.Component;

@Component
public class RestTemplateFactory<RequestType,ResponseType,ErrorType> implements ApiConsumerFactory<RequestType,ResponseType,ErrorType>{

    @Override
    public RestCaller<RequestType, ResponseType, ErrorType> getInstance() {
        return new RestTemplateService<RequestType,ResponseType,ErrorType>();
    }
}
