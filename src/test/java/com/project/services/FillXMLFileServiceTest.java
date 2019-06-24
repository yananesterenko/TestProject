package com.project.services;

import com.project.models.Item;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

class FillXMLFileServiceTest {
    @Test
    void fillFileService() {

        String name = "PC";
        String price = "2000.00";
        String imageURL = "https://images/1.jpg";
        Item itemObject = new Item();
        itemObject.setName(name);
        itemObject.setPrice(price);
        itemObject.setImageURL(imageURL);
        File filename = new File("temp.xml");
        FillXMLFileService.fillingFileXML(filename, itemObject);
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new InputSource(filename.getName()));
            if (!name.equals(doc.getDocumentElement().getElementsByTagName("itemName").item(0).getFirstChild().getTextContent())) {
                System.out.println("Wrong name!");
            }
            if (!price.equals(doc.getDocumentElement().getElementsByTagName("price").item(0).getFirstChild().getTextContent())) {
                System.out.println("Wrong price!");
            } else if (!imageURL.equals(doc.getDocumentElement().getElementsByTagName("imageURL").item(0).getFirstChild().getTextContent())) {
                System.out.println("Wrong URL!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        filename.delete();

    }
}