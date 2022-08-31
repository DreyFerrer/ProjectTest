package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.jupitertoys.model.components.dialogs.LoginDialog;
import com.planittesting.jupitertoys.model.components.dialogs.LogoutDialog;

public class BasePage <HomePage extends BasePage<HomePage>> {
    WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver =  driver;
    }

    public ContactPage clickContactMenu() {
        driver.findElement(By.id("nav-contact")).click();
        return new ContactPage(driver);
    }

    public ShopPage clickShopMenu() {
        driver.findElement(By.id("nav-shop")).click();
        return new ShopPage(driver);
    }

    public CartPage clickCartMenu() {
        driver.findElement(By.id("nav-cart")).click();
        return new CartPage(driver);
        
    }
    
    @SuppressWarnings("unchecked")
    public LoginDialog<HomePage> clickLoginMenu(){
        driver.findElement(By.cssSelector("#nav-login a")).click();
        return new LoginDialog <HomePage>(
            driver.findElement(By.className("popup")),
            (HomePage) this); 
    }

    @SuppressWarnings("unchecked")
    public LogoutDialog<T> clickLogoutMenu() {
        driver.findElement(By.id("menu-logout")).click();
        return new LogoutDialog<T>(
            driver.findElement(By.id("logout-modal")), (T)this
        );
    }


     public String getCurrentUser(){
        return driver.findElement(By.className("user")).getText();
     }

     public Integer getCartCount() {
        return Integer.parseInt(driver.findElement(By.id("cart-count")).getText());
    }
}
