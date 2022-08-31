package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;

import com.planittesting.model.data.ContactData;
import com.planittesting.model.pages.HomePage;

public class ContactTests extends BaseTest {
  @Test
  public void verifyIncorrectEmailError() {
    var contactPage = new HomePage(driver)
        .clickContactMenu()
        .setEmail("notanemail");

    assertEquals("Please enter a valid email", contactPage.getErrorText("email-err"));
  }

  @Test
  public void verifyRequiredFieldErrors() {
       driver.findElement(By.cssSelector("#nav-contact a")).click();
    driver.findElement(By.className("btn-contact")).click();

    var foreNameError = driver.findElement(By.id("forename-err")).getText();
    var emailError = driver.findElement(By.id("email-err")).getText();
    var msgError = driver.findElement(By.id("message-err")).getText();

    assertEquals("Forename is required", foreNameError);
    assertEquals("Email is required", emailError);
    assertEquals("Message is required", msgError);
  }

  @ParameterizedTest
  @CsvSource(value = { "andre,badilles,abadilles@planittesting.com,041234567, message" })
  public void validateRequiredFieldErrorsRemoval(ContactData data) {
    var contactPage = new HomePage(driver)
        .clickContactMenu()
        .clickSubmitButton()
        .setEmail(data.email())
        .setForename(data.forename())
        .setMessage(data.messsage());

    assertEquals("", contactPage.getErrorText("email-err"));
    assertEquals("", contactPage.getErrorText("forename-err"));
    assertEquals("", contactPage.getErrorText("message-err"));
  }

  @Test
  @CsvFileSource(resources = "data/contactData.csv", numLinesToSkip = 3)
  public void validateContactFormSubmission(ContactData data) {
    var message = new HomePage(driver)
        .clickContactMenu()
        .setEmail(data.email())
        .setForename(data.forename())
        .setMessage(data.messsage())
        .clickSubmitButton()
        .getSuccessMessage();

    assertEquals("Thanks you, we appreciate your feedback.", message);
  }
}