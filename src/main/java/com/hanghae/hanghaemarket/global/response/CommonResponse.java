package com.hanghae.hanghaemarket.global.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Getter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommonResponse<T> {

  private T data;
  private String message;

  public static <T> ResponseEntity<CommonResponse<T>> ok(T data) {
    return ResponseEntity.ok().body(CommonResponse.<T>builder().data(data).build());
  }

  public static <T> ResponseEntity<CommonResponse<T>> ok(String message) {
    return ResponseEntity.ok().body(CommonResponse.<T>builder().message(message).build());
  }
}
