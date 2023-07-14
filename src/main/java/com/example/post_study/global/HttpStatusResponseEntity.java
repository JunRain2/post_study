package com.example.post_study.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;

public class HttpStatusResponseEntity {
    public static ResponseEntity<HttpStatus> RESPONSE_OK = ResponseEntity.status(HttpStatus.OK).build();
    public static ResponseEntity<HttpStatus> RESPONSE_CONFLICT = ResponseEntity.status(HttpStatus.CONFLICT).build();
}
