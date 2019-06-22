package com.project.services;


import com.project.models.ItemInformation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class FillXMLFileService {

     public static void fillingFileXML(File file, ItemInformation itemObject) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            //root elements
            Document doc = docBuilder.newDocument();
            Element items = doc.createElement("items");
            doc.appendChild(items);
            Element item = doc.createElement("item");
            items.appendChild(item);
            Element itemName = doc.createElement("itemName");
            itemName.appendChild(doc.createTextNode(itemObject.getName()));
            item.appendChild(itemName);
            Element price = doc.createElement("price");
            price.appendChild(doc.createTextNode(itemObject.getPrice()));
            item.appendChild(price);
            Element imageURL = doc.createElement("imageURL");
            imageURL.appendChild(doc.createTextNode(itemObject.getImageURL()));
            item.appendChild(imageURL);

            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

            System.out.println("Done");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();

        }





    }

}
