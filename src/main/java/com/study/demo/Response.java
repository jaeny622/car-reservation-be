package com.study.demo;

import jakarta.annotation.Nullable;

public record Response<T>(
        String status,
        @Nullable T data
) {
    public static <T> Response<T> success(@Nullable T data) {
        return new Response<>("success",data);
    }

    public static <T> Response<T> created(@Nullable T data) {
        return new Response<>("success",data);
    }

    public static <T> Response<T> fail(@Nullable T data) {
        return new Response<>("fail",data);
    }
}
