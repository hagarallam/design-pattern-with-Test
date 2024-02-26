package com.example.restTemplate.designPattern.rest.caller;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static org.springframework.http.HttpMethod.*;

@Component
public class RestTemplateService<RequestType,ResponseType,ErrorType> implements RestCaller<RequestType,ResponseType,ErrorType>{

    private final RestTemplate restTemplate;

    public RestTemplateService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public ResponseWrapper<ResponseType, ErrorType> performGet(String url, HttpHeaders httpHeaders, ParameterizedTypeReference<ResponseType> responseType, ErrorType errorType) {
        ResponseWrapper<ResponseType,ErrorType> responseWrapper = new ResponseWrapper<>() ;
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ResponseType> responseEntity = this.restTemplate.exchange(
                url,GET,httpEntity,responseType);
        responseWrapper.setResponseType(responseEntity);
        if(responseEntity.getStatusCode() != HttpStatus.OK) {
            responseWrapper.setErrorType(errorType);
        }
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<ResponseType, ErrorType> performPost(String url, HttpHeaders httpHeaders, RequestType requestType, ParameterizedTypeReference<ResponseType> responseType, ErrorType errorType) {
        ResponseWrapper<ResponseType,ErrorType> responseWrapper = new ResponseWrapper<>() ;
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(requestType,httpHeaders);
        ResponseEntity<ResponseType> responseEntity = this.restTemplate.exchange(
                url,POST,httpEntity,responseType);
        responseWrapper.setResponseType(responseEntity);
        if(responseEntity.getStatusCode() != HttpStatus.OK) {
            responseWrapper.setErrorType(errorType);
        }
        return responseWrapper;

    }

    @Override
    public ResponseWrapper<ResponseType, ErrorType> performPut(String url, HttpHeaders httpHeaders, RequestType requestType, ParameterizedTypeReference<ResponseType> responseType, ErrorType errorType) {
        ResponseWrapper<ResponseType,ErrorType> responseWrapper = new ResponseWrapper<>() ;
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(requestType,httpHeaders);
        ResponseEntity<ResponseType> responseEntity = this.restTemplate.exchange(
                url,POST,httpEntity,responseType);
        responseWrapper.setResponseType(responseEntity);
        if(responseEntity.getStatusCode() != HttpStatus.OK) {
            responseWrapper.setErrorType(errorType);
        }
        return responseWrapper;
    }

    @Override
    public ResponseWrapper<ResponseType, ErrorType> performDelete(String url, HttpHeaders httpHeaders, ParameterizedTypeReference<ResponseType> responseType, ErrorType errorType) {
        ResponseWrapper<ResponseType,ErrorType> responseWrapper = new ResponseWrapper<>() ;
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ResponseType> responseEntity = this.restTemplate.exchange(
                url,DELETE,httpEntity,responseType);
        responseWrapper.setResponseType(responseEntity);
        if(responseEntity.getStatusCode() != HttpStatus.OK) {
            responseWrapper.setErrorType(errorType);
        }
        return responseWrapper;

    }
}

