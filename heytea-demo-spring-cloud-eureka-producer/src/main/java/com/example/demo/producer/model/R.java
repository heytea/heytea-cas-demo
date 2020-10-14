package com.example.demo.producer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.Getter;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class R<T> {

    @SuppressWarnings("rawtypes")
    public static final R DEFAULT_R = new EmptyResponseResult();

    private int code = 0;
    private String message = "success";
    private T data = null;

    public static <T> R<T> success() {
        return DEFAULT_R;
    }

    @Getter
    private static final class EmptyResponseResult<T> extends R<T> {
        private int code = 0;
        private String message = "success";
        private T data = null;
    }

}
