package com.project.services;

import com.project.models.Item;

import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CollectItemInformation {


   public static void getItemInformation(String pathNet){
       Item itemInformationObject = ItemHTMLService.getItemInformation(pathNet);
       File itemsfile = new File(System.getProperty("user.dir") + "/data", "item.xml");
       FillXMLFileService.fillingXMLFile(itemsfile, itemInformationObject);
       Connection connection = ItemDaoService.getConnection();

       Statement statement = null;
       try {
           statement = connection.createStatement();
           String qs = "CREATE TABLE IF NOT EXISTS item(user_id SERIAL NOT NULL PRIMARY KEY,itemName varchar(225) NOT NULL UNIQUE,price integer,ImageURL varchar(225))";
           String qs1 = "SELECT * FROM item";
           ResultSet rs = statement.executeQuery(qs1);
           statement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }




   }

}
