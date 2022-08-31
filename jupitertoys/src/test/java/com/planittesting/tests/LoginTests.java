package com.planittesting.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.planittesting.model.pages.HomePage;

public class LoginTests extends BaseTest{
    
    @Test
    public void verifyUserLogin() {
        var homePage = new HomePage(driver)
            .clickLoginMenu()
            .setUsername("someone")
            .setPassword("letmein")
            .clickLoginButton();
        
        assertEquals("someone", homePage.getCurrentUser());
    }

    @Test
    public void FillInContactPage() {
        var contactPage = open(HomePage.class)
            .clickContactMenu()
            .clickLoginMenu()
            .setUsername("someone")
            .setPassword("letmein")
            .clickAgreeCheckbox()
            .clickLoginButton()
            .setForename("someone");

        assertEquals("someone", contactPage.getCurrentUser());
    }

    @Test
    public void verifyUserLogOut() {
        var contactPage = open(HomePage.class)
            .clickContactMenu()
            .clickLoginMenu()
            .setUsername("someone")
            .setPassword("letmein")
            .clickAgreeCheckbox()
            .clickLoginButton()
            .clickLogoutMenu()
            .clickLogoutButton();
        
        assertEquals("someone", contactPage.getCurrentUser());
    }
}
