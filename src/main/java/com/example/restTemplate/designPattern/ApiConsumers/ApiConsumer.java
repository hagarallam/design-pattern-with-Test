package com.example.restTemplate.designPattern.ApiConsumers;
import org.springframework.http.HttpHeaders;

public interface ApiConsumer<RequestType,ResponseType>{
    ResponseType performGet(String url , RequestType requestEntity, HttpHeaders httpHeaders);
    ResponseType performPost(String url , RequestType requestEntity, HttpHeaders httpHeaders);
    ResponseType performPut(String url , RequestType requestEntity, HttpHeaders httpHeaders);
    ResponseType performDelete(String url , RequestType requestEntity, HttpHeaders httpHeaders);

}
