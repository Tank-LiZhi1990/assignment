package com.netease.assignment.dao;

import com.netease.assignment.domain.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IItemDao {

    void addItem(Item item);

    void deleteItem(Integer itemId);

    Item getItem(Integer itemId);

    void updateItem(Item item);

    List<Item> getItems();

    List<Item> getBoughtItems(Integer userId);

    List<Item> getUnBoughtItems(Integer userId);

    Integer getMaxItemId();

    List<Item> getSellerItems(Integer sellerId);

}
