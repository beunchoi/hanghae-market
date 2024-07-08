package com.hanghae.hanghaemarket.service;

import com.hanghae.hanghaemarket.dto.ItemRequestDto;
import com.hanghae.hanghaemarket.dto.ItemResponseDto;
import com.hanghae.hanghaemarket.entity.Item;
import com.hanghae.hanghaemarket.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ItemService {

  private final ItemRepository itemRepository;

  public ItemResponseDto createItemPost(ItemRequestDto requestDto) {

    Item item = itemRepository.save(new Item(requestDto));

    return new ItemResponseDto(item);
  }

  public List<ItemResponseDto> getItemPosts() {

    List<Item> itemList = itemRepository.findAll();

    return itemList.stream().map(ItemResponseDto::new).toList();
  }

  @Transactional
  public ItemResponseDto updateItemPost(Long id, ItemRequestDto requestDto) {

    Item item = itemRepository.findById(id).orElseThrow(() ->
        new IllegalArgumentException("해당 게시글이 존재하지 않습니다."));

    item.updateItem(requestDto);

    return new ItemResponseDto(item);
  }

  public void deleteItemPost(Long id) {

    itemRepository.deleteById(id);
  }
}
