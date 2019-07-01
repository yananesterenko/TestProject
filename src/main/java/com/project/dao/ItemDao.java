package com.project.dao;

import com.project.models.Item;

import java.sql.Connection;
import java.util.List;

public interface ItemDao {
    void addItem(Item item, Connection connection);

    void updateItem(Item item);

    void deleteItem(int id);

    Item getItemById(int id);

    List<Item> listItems();


}
