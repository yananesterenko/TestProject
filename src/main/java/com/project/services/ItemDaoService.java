package com.project.services;


import com.project.models.Item;
import com.project.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ItemDaoService {

    public static Connection getConnection(){
         Connection connection = ConnectionUtil.getConnection("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5432/myapp_data","postgres","postgres");
         return connection;
    }

    public static boolean createTable(Connection connection) {
        boolean rs = false;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String qs = "CREATE TABLE IF NOT EXISTS items(user_id SERIAL NOT NULL PRIMARY KEY,itemName varchar(225) NOT NULL UNIQUE,price integer,ImageURL varchar(225))";
            rs = statement.execute(qs);

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



}
