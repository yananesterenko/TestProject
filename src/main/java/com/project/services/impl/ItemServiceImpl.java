package com.project.services.impl;

import com.project.dao.ConnectionPostgress;
import com.project.dao.ItemDaoImpl;
import com.project.models.Item;
import com.project.services.ItemHTMLService;
import com.project.services.ItemService;
import com.project.services.ReadXMLFileService;
import com.project.services.WriteXMLFileService;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class ItemServiceImpl implements ItemService {

    final static File file = new File(System.getProperty("user.dir") + "/data", "item.xml");


    public static void getItemInformation(String pathNet) {
        Item itemHTMLObject = ItemHTMLService.getHTMLItemInformation(pathNet);
        WriteXMLFileService.fillingXMLFile(file, itemHTMLObject);
    }

    public static void addItemInformation() {
        Item item = ReadXMLFileService.readItemToObject(file);
        Connection connection = new ConnectionPostgress().getConnection();
        if (connection != null) {

            ItemDaoImpl dao = new ItemDaoImpl();
            dao.addItem(item, connection);
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
