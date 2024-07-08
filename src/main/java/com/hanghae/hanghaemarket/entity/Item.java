package com.hanghae.hanghaemarket.entity;

import com.hanghae.hanghaemarket.dto.ItemRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "item")
public class Item {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String title;

  @Column
  private String content;

  @Column
  private int price;

  @Column
  private String username;

  public Item(ItemRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.price = requestDto.getPrice();
    this.username = requestDto.getUsername();
  }

  public void updateItem(ItemRequestDto requestDto) {
    this.title = requestDto.getTitle();
    this.content = requestDto.getContent();
    this.price = requestDto.getPrice();
    this.username = requestDto.getUsername();
  }
}
