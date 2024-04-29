package com.example.demo.infrastructure.web.rest.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class HttpResponse {
    private String message;
    private String status;
    private Object data;
}
