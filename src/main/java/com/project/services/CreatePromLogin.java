package com.project.services;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreatePromLogin {
    public static void main(String[] args) {
        createPromLogin();
    }
    public static  void createPromLogin() {
        System.setProperty("webdriver.chrome.driver", "C:/webdrivers2/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://prom.ua/join-customer?source_id=txt.register.customer");

        driver.findElement(By.name("vertical-name")).sendKeys("tttt_25");
        String d = String.valueOf(System.currentTimeMillis());
        driver.findElementByName("vertical-email").sendKeys("tt" + d  + "@gmail.com");
        driver.findElementByName("vertical-password").sendKeys("tttt_25");
        driver.findElementByClassName("lp-button__text").click();
        // driver.quit();
    }
}
