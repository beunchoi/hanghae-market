package com.hanghae.hanghaemarket.dto;

import lombok.Getter;

@Getter
public class ItemRequestDto {
  private String title;
  private String content;
  private int price;
  private String username;
}
