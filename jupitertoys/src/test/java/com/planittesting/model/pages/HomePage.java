package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage<HomePage> {
    WebDriver driver;

    public static final By LBL_HEADER = By.className("hero-unit");
    public static final By BTN_SHOP = By.className("btn btn-success btn-large");
    public static final By LBL_SHOP = By.xpath("//*[@id='nav-shop']/a");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void accessHomePage(){
        waitElementToBeVisible(LBL_HEADER);
    }

    public void StartShopping(){
         waitElementToBeVisible(BTN_SHOP);
         click(BTN_SHOP);
    }
    public void clickShopMenu(){
        driver.findElement(By.className("nav-shop"));
        waitElementToBeVisible(LBL_SHOP);
        waitElementToBeClick(LBL_SHOP);
    }
    

	

}
