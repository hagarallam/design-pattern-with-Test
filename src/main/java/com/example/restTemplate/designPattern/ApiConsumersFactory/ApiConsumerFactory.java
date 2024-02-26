package com.example.restTemplate.designPattern.ApiConsumersFactory;


import com.example.restTemplate.designPattern.rest.caller.RestCaller;

public interface ApiConsumerFactory<RequestType,ResponseType,ErrorType> {

    RestCaller<RequestType,ResponseType,ErrorType> getInstance();
}
