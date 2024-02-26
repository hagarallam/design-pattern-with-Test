package com.example.restTemplate.designPattern.ApiConsumersFactory;


import com.example.restTemplate.designPattern.ApiConsumers.ApiConsumer;
import com.example.restTemplate.designPattern.ApiConsumers.WebClientApi;
import com.example.restTemplate.designPattern.rest.caller.RestCaller;

public class WebClientFactory<RequestType,ResponseType,ErrorType> implements ApiConsumerFactory<RequestType,ResponseType,ErrorType>{

    @Override
    public RestCaller<RequestType, ResponseType, ErrorType> getInstance() {
        return null;
    }
}
