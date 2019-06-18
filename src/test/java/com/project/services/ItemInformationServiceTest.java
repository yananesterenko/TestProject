package com.project.services;

import com.project.models.ItemInformation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemInformationServiceTest {

    @Test

    void getItemInformation() {

        ItemInformation item = ItemInformationService.getItemInformation("https://prom.ua/p895411456-igrovoj-noutbu-omen.html");
        assertNotNull(item);
        assertNotNull(item.getName());
        assertNotNull(item.getImageURL());
        assertNotNull(item.getPrice());
        assertFalse(item.getPrice().contains("[a-zA-Z]+"));

    }

}