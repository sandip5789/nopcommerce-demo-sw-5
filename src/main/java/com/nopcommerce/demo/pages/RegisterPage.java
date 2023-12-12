package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Register']")
    WebElement registerText;

    @CacheLookup
    @FindBy(id = "register-button")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//span[@id='FirstName-error']")
    WebElement firstNameIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='LastName-error']")
    WebElement lastNameIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Email-error']")
    WebElement emailIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='Password-error']")
    WebElement passwordIsRequired;

    @CacheLookup
    @FindBy(xpath = "//span[@id='ConfirmPassword-error']")
    WebElement cPasswordIsRequired;

    @CacheLookup
    @FindBy(id = "gender-female")
    WebElement genderFemaleLink;

    @CacheLookup
    @FindBy(id = "FirstName")
    WebElement firsNameField;

    @CacheLookup
    @FindBy(id = "LastName")
    WebElement lastNameField;

    @CacheLookup
    @FindBy(name = "DateOfBirthDay")
    WebElement dateOfBirthField;

    @CacheLookup
    @FindBy(xpath = "//select[@name='DateOfBirthMonth']")
    WebElement monthOfBirthField;

    @CacheLookup
    @FindBy(name = "DateOfBirthYear")
    WebElement yearOfBirthField;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(id = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(id = "ConfirmPassword")
    WebElement cPassWordField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='result']")
    WebElement youRegistrationCompletedText;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement continueButton;






    public String verifyRegisterText(){
        String text = getTextFromElement(registerText);
        return text;
    }
    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
    public String verifyTheErrorMessageFirstNameIsRequiredDisplayed(){
        String text = getTextFromElement(firstNameIsRequired);
        return text;
    }
    public String verifyTheErrorMessageLastNameIsRequiredDisplayed(){
        String text = getTextFromElement(lastNameIsRequired);
        return text;
    }
    public String verifyTheErrorMessageEmailIsRequiredDisplayed(){
        String text = getTextFromElement(emailIsRequired);
        return text;
    }
    public String verifyTheErrorMessagePasswordIsRequiredDisplayed(){
        String text = getTextFromElement(passwordIsRequired);
        return text;
    }
    public String verifyTheErrorMessageCPasswordIsRequiredDisplayed(){
        String text = getTextFromElement(cPasswordIsRequired);
        return text;
    }
    public void selectGenderFemale(){
        clickOnElement(genderFemaleLink);
    }
    public void enterFirstName(String firstName){
        sendTextToElement(firsNameField,firstName);
    }
    public void enterLastName(String lastName){
        sendTextToElement(lastNameField,lastName);
    }
    public void selectDay(String day){
        selectByValueFromDropDown(dateOfBirthField,day);
    }
    public void selectMonth(String month){
        selectByVisibleTextFromDropDown(monthOfBirthField,month);
    }
    public void selectYear(String year){
        selectByValueFromDropDown(yearOfBirthField,year);
    }
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void enterConfirmPassword(String cPassword){
        sendTextToElement(cPassWordField,cPassword);
    }
    public void clickOnContinueButton(){
        clickOnElement(continueButton);
    }
    public String verifyYourRegistrationCompletedText(){
        String text = getTextFromElement(youRegistrationCompletedText);
        return text;
    }

}
