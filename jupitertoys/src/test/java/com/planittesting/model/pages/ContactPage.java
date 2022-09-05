package com.planittesting.model.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage extends BasePage<ContactPage> {
  public ContactPage(WebDriver driver) {
    super(driver);
  }

  // public ContactPage setInput(String name, String text) {
  // driver.findElement(By.name(name)).sendKeys(text);
  // return this;
  // }

  public ContactPage setEmail(String email) {
    driver.findElement(By.name("email")).sendKeys(email);
    return this;
  }

  public ContactPage setForename(String forename) {
    driver.findElement(By.name("forename")).sendKeys(forename);
    return this;
  }

  public ContactPage setMessage(String message) {
    driver.findElement(By.name("message")).sendKeys(message);
    return this;
  }

  // private String getErrorText(By locator) {
  // var elements = driver.findElements(locator);
  // if (elements.isEmpty())
  // return "";
  // return elements.get(0).getText();
  // }

  public String getErrorText(String id) {
    var elements = driver.findElements(By.id(id));
    if (elements.isEmpty())
      return "";
    return elements.get(0).getText();
  }

  // public String getEmailError() {
  // return getErrorText(By.id("email-err"));
  // // return driver.findElement(By.id("email-err")).getText();
  // }

  // public String getForenameError() {
  // return getErrorText(By.id("forename-err"));
  // }

  // public String getMessageError() {
  // return getErrorText(By.id("message-err"));
  // }

  public ContactPage clickSubmitButton() {
    driver.findElement(By.className("btn-contact")).click();
    return this;
  }

  public String getSuccessMessage() {
    return new WebDriverWait(driver, Duration.ofSeconds(60))
        .until(d -> d.findElement(By.className("alert-success"))).getText();
  }
}