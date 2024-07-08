package com.hanghae.hanghaemarket.controller;

import com.hanghae.hanghaemarket.dto.ItemRequestDto;
import com.hanghae.hanghaemarket.dto.ItemResponseDto;
import com.hanghae.hanghaemarket.global.response.CommonResponse;
import com.hanghae.hanghaemarket.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;

  @PostMapping
  public ResponseEntity<CommonResponse<ItemResponseDto>> createItemPost(@RequestBody ItemRequestDto itemRequestDto) {

    ItemResponseDto response = itemService.createItemPost(itemRequestDto);

    return CommonResponse.ok(response);
  }

  @GetMapping
  public ResponseEntity<CommonResponse<List<ItemResponseDto>>> getItemPosts() {

    List<ItemResponseDto> responseList = itemService.getItemPosts();

    return CommonResponse.ok(responseList);
  }

  @PutMapping("/{id}")
  public ResponseEntity<CommonResponse<ItemResponseDto>> updateItemPost(@PathVariable Long id, @RequestBody ItemRequestDto requestDto) {

    ItemResponseDto response = itemService.updateItemPost(id, requestDto);

    return CommonResponse.ok(response);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<CommonResponse<String>> deleteItemPost(@PathVariable Long id) {

    itemService.deleteItemPost(id);

    return CommonResponse.ok("게시글이 삭제되었습니다.");
  }
}
