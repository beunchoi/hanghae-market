package com.hanghae.hanghaemarket.dto;

import com.hanghae.hanghaemarket.entity.Item;
import lombok.Getter;

@Getter
public class ItemResponseDto {
  private String title;
  private String content;
  private int price;
  private String username;

  public ItemResponseDto(Item item) {
    this.title = item.getTitle();
    this.content = item.getContent();
    this.price = item.getPrice();
    this.username = item.getUsername();
  }
}
