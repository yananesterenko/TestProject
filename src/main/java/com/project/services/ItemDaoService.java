package com.project.services;


import com.project.models.Item;
import com.project.utils.ConnectionUtil;

import java.sql.Connection;
import java.util.List;

public class ItemDaoService {

    public static Connection getConnection(){
         Connection connection = ConnectionUtil.getConnection("org.postgresql.Driver", "jdbc:postgresql://127.0.0.1:5433/myapp_data","postgres","postgres");
         return connection;
    }



}
