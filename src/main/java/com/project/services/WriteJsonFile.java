package com.project.services;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.project.models.ItemInformation;

import java.io.File;
import java.io.IOException;

public class WriteJsonFile {
    private static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) {
        writeJsonFile();

    }
    private static void writeJsonFile(){
        ItemInformation itemObject = new ItemInformation();
        itemObject.setPrice("123");
        itemObject.setName("name");
        itemObject.setImageURL("/http:image");
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            mapper.writeValue(new File("data/output.json"), itemObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
