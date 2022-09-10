package com.planittesting.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.planittesting.model.components.Dialogs.LoginDialog;

public class BasePage <CurrentPage extends BasePage<CurrentPage>> {
    static WebDriver driver;
	private String string;
	private String productName;
	private String string2;

    
   
    
    public BasePage(WebDriver driver2) {
    }

    public ContactPage clickContactMenu(){
        driver.findElement(By.cssSelector("#nav-contact a")).click();
        return new ContactPage(driver);
    }

    @SuppressWarnings("unchecked")
    public LoginDialog<CurrentPage> clickLoginMenu(){
        driver.findElement(By.cssSelector("#nav-login a")).click();
        return new LoginDialog <CurrentPage>(
            driver.findElement(By.className("popup")),
            (CurrentPage) this);  
    }

     public String getCurrentUser(){
        return driver.findElement(By.className("user")).getText();
     }

     protected static void waitElementToBeVisible(By lblHeader) {
	}

    public void click(By by) {
        waitElementToBeVisible(by);
        waitElementToBeClick(by);
        driver.findElement(by).click();
	}


    
    protected Object getValue(String string, String productName, String string2) {
        this.string =string;
        this.productName = productName;
        this.string2 = string2;
        
		return null;
	}



	protected static void waitElementToBeClick(By by) {
	}
}
