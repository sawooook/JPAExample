package com.example.JPAExample.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

public class ApiUtils {
    public static <T> ApiResult<T> success(T response) {
        return new ApiResult<T>(true, response, null);
    }

    public static ApiResult<?> error(Throwable throwable, HttpStatus status) {
        return new ApiResult<Object>(false, null, new ApiError(throwable, status));
    }

    public static ApiResult<?> error(String message, HttpStatus status) {
        return new ApiResult<Object>(false, null, new ApiError(message, status));
    }


    @RequiredArgsConstructor
    public static class ApiResult<T> {
        private final boolean success;
        private final T response;
        private final ApiError error;

    }

    public static class ApiError {
        private String message;
        private int status;
        public ApiError(Throwable throwable, HttpStatus status) {
            this(throwable.getMessage(), status);
        }

        public ApiError(String message, HttpStatus status) {
            this.message = message;
            this.status = status.value();
        }
    }
}
