package com.netease.assignment.service;

import com.netease.assignment.domain.Item;

import java.util.List;

public interface ItemService {

    List<Item> getItems();

    List<Item> getBoughtItems(Integer userId);

    // 如果只有一个用户，则就是指销量为0的物品
    List<Item> getUnBoughtItems(Integer userId);

    void addItem(Item item);

    void deleteItem(Integer itemId);

    Item getItem(Integer itemId);

    void updateItem(Item item);

    List<Item> getSellerItems(Integer sellerId);
}
