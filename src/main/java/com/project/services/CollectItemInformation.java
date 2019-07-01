package com.project.services;

import com.project.dao.ItemDaoImpl;
import com.project.models.Item;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class CollectItemInformation {
    final static File file = new File(System.getProperty("user.dir") + "/data", "item.xml");

    public static void getItemInformation(String pathNet) {
        Item itemHTMLObject = ItemHTMLService.getHTMLItemInformation(pathNet);
        WriteXMLFileService.fillingXMLFile(file, itemHTMLObject);
    }

    public static void saveItemInformation() {
        Item item = ReadXMLFileService.readItemToObject(file);
        Connection connection = ItemDaoService.getConnection();
        if (connection != null) {
            ItemDaoService.createTable(connection);
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
