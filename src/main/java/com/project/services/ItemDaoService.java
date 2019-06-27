package com.project.services;

import com.project.models.Item;

import java.util.List;



public interface ItemDaoService {
    public void addItem(Item item);

    public void updateItem(Item item);

    public void removeItem(Item item);

    public Item getItemById(Item item);

    public List<Item> listItem();
}

