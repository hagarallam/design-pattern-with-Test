package com.example.restTemplate.designPattern.ApiConsumers;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import static org.springframework.http.HttpMethod.PUT;
import static org.springframework.http.HttpMethod.DELETE;
public class RestTemplateApi<RequestType,ResponseType>implements ApiConsumer<RequestType,ResponseType> {

    private RestTemplate restTemplate = new RestTemplate();
    private HttpHeaders httpHeaders;



    @Override
    public ResponseType performGet(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(httpHeaders);
        ParameterizedTypeReference<ResponseType> typeRef = new ParameterizedTypeReference<ResponseType>() {};
        List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();


        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.ALL));
        messageConverters.add(converter);
        restTemplate.setMessageConverters(messageConverters);
            ResponseEntity<ResponseType> responseEntity = restTemplate.exchange(url, GET, httpEntity, typeRef);
        return responseEntity.getBody();
    }

    @Override
    public ResponseType performPost(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(requestEntity,httpHeaders);
        ResponseEntity<ResponseType> responseEntity = restTemplate.exchange(url, POST, httpEntity, new ParameterizedTypeReference<ResponseType>(){});
        return responseEntity.getBody();
    }

    @Override
    public ResponseType performPut(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(requestEntity,httpHeaders);
        ResponseEntity<ResponseType> responseEntity = restTemplate.exchange(url, PUT, httpEntity, new ParameterizedTypeReference<ResponseType>(){});
        return responseEntity.getBody();
    }

    @Override
    public ResponseType performDelete(String url, RequestType requestEntity, HttpHeaders httpHeaders) {
        HttpEntity<RequestType> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<ResponseType> responseEntity = restTemplate.exchange(url, DELETE, httpEntity, new ParameterizedTypeReference<ResponseType>(){});
        return responseEntity.getBody();
    }
}
