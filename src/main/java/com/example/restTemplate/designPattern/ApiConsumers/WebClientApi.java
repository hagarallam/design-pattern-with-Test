package com.example.restTemplate.designPattern.ApiConsumers;

import org.springframework.http.HttpHeaders;

public class WebClientApi<RequestType,ResponseType> implements ApiConsumer<RequestType,ResponseType> {
    @Override
    public ResponseType performGet(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        return null;
    }

    @Override
    public ResponseType performPost(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        return null;
    }

    @Override
    public ResponseType performPut(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        return null;
    }

    @Override
    public ResponseType performDelete(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        return null;
    }
}
