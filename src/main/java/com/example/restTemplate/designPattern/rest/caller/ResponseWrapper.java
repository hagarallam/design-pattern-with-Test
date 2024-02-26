package com.example.restTemplate.designPattern.rest.caller;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<ResponseType,ErrorType> {

    ResponseEntity<ResponseType> responseType;
    ErrorType errorType;

    public ResponseWrapper(ResponseEntity<ResponseType> responseType) {
        this.responseType = responseType;
    }
}
