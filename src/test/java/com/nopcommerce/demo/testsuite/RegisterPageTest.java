package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class RegisterPageTest extends BaseTest {

    HomePage homePage;
    RegisterPage registerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();

    }

    // 1. verifyUserShouldNavigateToRegisterPageSuccessfully()
    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Verify "Register" text
        String expectedText = "Register";
        String actualText = registerPage.verifyRegisterText();
        Assert.assertEquals(expectedText, actualText, "Register text is not display");
    }

    // 2.verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory()
    @Test(groups = {"smoke", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Click on "REGISTER" button
        registerPage.clickOnRegisterLink();
        // Verify the error message "First name is required."
        String expectedText = "First name is required.";
        String actualText = registerPage.verifyTheErrorMessageFirstNameIsRequiredDisplayed();
        Assert.assertEquals(actualText, expectedText, "First name is required not displayed");
        // Verify the error message "Last name is required."
        String expectedText1 = "Last name is required.";
        String actualText1 = registerPage.verifyTheErrorMessageLastNameIsRequiredDisplayed();
        Assert.assertEquals(actualText1, expectedText1, "Last name is required not displayed");
        // Verify the error message "Email is required."
        String expectedText2 = "Email is required.";
        String actualText2 = registerPage.verifyTheErrorMessageEmailIsRequiredDisplayed();
        Assert.assertEquals(actualText2, expectedText2, "Email is required not displayed");
        // Verify the error message "Password is required."
        String expectedText3 = "Password is required.";
        String actualText3 = registerPage.verifyTheErrorMessagePasswordIsRequiredDisplayed();
        Assert.assertEquals(actualText3, expectedText3, "Password is required not displayed");
        // Verify the error message "Password is required."
        String expectedText4 = "Password is required.";
        String actualText4 = registerPage.verifyTheErrorMessageCPasswordIsRequiredDisplayed();
        Assert.assertEquals(actualText4, expectedText4, "Password is required not displayed");

    }

    // 3. verifyThatUserShouldCreateAccountSuccessfully()
    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        // Click on Register Link
        homePage.clickOnRegisterLink();
        // Select gender "Female"
        registerPage.selectGenderFemale();
        // Enter firstname
        registerPage.enterFirstName("Ali");
        // Enter lastname
        registerPage.enterLastName("Bhatt");
        // Select day
        registerPage.selectDay("10");
        // Select month
        registerPage.selectMonth("December");
        // Select year
        registerPage.selectYear("1990");
        // Enter email
        //Random random = new Random();
        //registerPage.sendDataToEmailField("abcd"+random.nextInt()+"@gmail.com");
        registerPage.enterEmail("aliabhatt1991@gmail.com");
        // Enter password
        registerPage.enterPassword("alia1990");
        // Enter Confirm Password
        registerPage.enterConfirmPassword("alia1990");
        // Click on "REGISTER" button
        registerPage.clickOnRegisterLink();
        // Verify message "Your registration completed"
        String expectedText = "Your registration completed";
        String actualText = registerPage.verifyYourRegistrationCompletedText();
        Assert.assertEquals(actualText, expectedText, "Registration unsuccessfully ");
        // Click on continue button
        registerPage.clickOnContinueButton();
    }

}
