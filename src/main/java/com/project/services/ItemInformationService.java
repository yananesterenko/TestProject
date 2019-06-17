package com.project.services;

import com.project.models.ItemInformation;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class ItemInformationService {

    private String netPath;
    //  private final Document doc;


    public ItemInformationService(String netPath) {

        this.netPath = netPath;
    }

    public ItemInformation getItemInformation() {
        ItemInformation itemObject = new ItemInformation();
        Document doc = getDocument();
        Elements itemElements = doc.getElementsByClass("x-product-info");
        for (Element itemElement : itemElements) {
            Elements itemContent = itemElement.getElementsByClass("x-product-info__content");
            for (Element element : itemContent) {
                itemObject.setName(getName(element));
               // itemObject.setImageURL(getImageURL(doc));
                itemObject.setPrice(getPrice(doc));
            }
            Elements itemImages = itemElement.getElementsByClass("x-product-info__images");
            for (Element element : itemImages) {
                itemObject.setImageURL(getImageURL(element));
            }

        }


        return itemObject;

    }

    private String getPrice(Document doc) {
        String price = "";
        Elements priceElement = doc.getElementsByClass("x-product-price__value");
        for (Element element : priceElement) {
            price = element.attr("data-qaprice");
        }

        return price;

    }


    private String getName(Element element) {
        String name ;
        name = element.getElementsByTag("h1").text();
        return name;
    }

    private Document getDocument() {
        Document doc = null;
        try {
            doc = Jsoup.connect(netPath).get();

        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return doc;
    }


    private static String getImageURL(Element element) {
        String imageURL;
        imageURL = element.getElementsByClass("magnifier__image--2qkjO").attr("src");
        return imageURL;
    }
}
