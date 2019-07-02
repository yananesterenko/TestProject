package com.project.dao;

import com.project.models.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


public class ItemDaoImpl {

    private static final Logger logger = Logger.getLogger(ItemDaoImpl.class.getName());

    private ConnectionDao connectionDao = new ConnectionPostgress();

    public void addItem(Item item, Connection connection) {
        String sql = "INSERT INTO items (user_id,itemname, price, imageurl) VALUES (?, ?, ?, ?)";
        try {
            connection.setAutoCommit(false);
            PreparedStatement stm  =connection.prepareStatement(sql);
            stm.setString(2, item.getName());
            stm.setDouble(3, item.getPrice());
            stm.setString(4, item.getImageURL());
            stm.executeUpdate();
            connection.commit();
            logger.info("Item " + item.getName() + " was added");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public void updateItem(Item item) {
        logger.info("Item " + item + " was changed");
    }


    public void deleteItem(int id) {
    }

    public Item getItemById(int id) {
        return null;
    }

   public List<Item> listItems() {
        List<Item> itemList = new ArrayList<>();
        return itemList;
    }
}

