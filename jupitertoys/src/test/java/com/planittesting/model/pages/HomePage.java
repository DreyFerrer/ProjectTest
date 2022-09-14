package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage<HomePage> {
    WebDriver driver;

    public static final By LBL_HEADER = By.className("hero-unit");
    public static final By BTN_HOME = By.className("btn");
    public static final By LBL_SHOP = By.xpath("//*[@id='nav-shop']");

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void accessHomePage(){
        waitElementToBeVisible(LBL_HEADER);
    }



    // public void clickShopMenu(){
    //     driver.findElement(By.className("nav-shop"));
    //     waitElementToBeVisible(LBL_SHOP);
    //     click(LBL_SHOP);
    //     return new ShopPage(driver);

    }
    

	

