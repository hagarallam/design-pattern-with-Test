package com.example.restTemplate.designPattern.rest.caller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;


public interface RestCaller<RequestType,ResponseType,ErrorType> {



   ResponseWrapper<ResponseType,ErrorType> performGet(String url, HttpHeaders httpHeaders, ParameterizedTypeReference<ResponseType> responseType,ErrorType errorType);
    ResponseWrapper<ResponseType,ErrorType> performPost(String url, HttpHeaders httpHeaders,RequestType requestType ,ParameterizedTypeReference<ResponseType> responseType,ErrorType errorType);
    ResponseWrapper<ResponseType,ErrorType> performPut(String url, HttpHeaders httpHeaders,RequestType requestType ,ParameterizedTypeReference<ResponseType> responseType,ErrorType errorType);
    ResponseWrapper<ResponseType,ErrorType> performDelete(String url, HttpHeaders httpHeaders, ParameterizedTypeReference<ResponseType> responseType,ErrorType errorType);

}
