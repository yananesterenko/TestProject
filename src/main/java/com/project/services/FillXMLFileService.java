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

    public FillXMLFileService() {
    }

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

            //nickname elements
            Element nickname = doc.createElement("itemName");
            nickname.appendChild(doc.createTextNode(itemObject.getName()));
            item.appendChild(nickname);

            //salary elements
            Element salary = doc.createElement("price");
            salary.appendChild(doc.createTextNode(itemObject.getPrice()));
            item.appendChild(salary);

            Element firstname = doc.createElement("imageURL");
            firstname.appendChild(doc.createTextNode(itemObject.getImageURL()));
            item.appendChild(firstname);

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
