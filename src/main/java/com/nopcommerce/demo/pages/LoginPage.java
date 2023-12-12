package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage  extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'Welcome, Please Sign In!')]")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(id = "Email")
    WebElement emailField;

    @CacheLookup
    @FindBy(name = "Password")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Log in')]")
    WebElement loginButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement errorMessage;

    @CacheLookup
    @FindBy(xpath = "//div[@class='message-error validation-summary-errors']")
    WebElement loginUnsuccessfulMessage;




    public String getWelcomeText(){
        String message = getTextFromElement(welcomeText);
        return message;
    }
    public void enterEmail(String email){
        sendTextToElement(emailField,email);
    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
    }
    public void clickOnLoginButton(){
        clickOnElement(loginButton);
    }

    public void loginToApplication(String email, String password){
        enterEmail(email);
        enterPassword(password);
        clickOnLoginButton();
    }
    public String getErrorMessage(){
        String message = getTextFromElement(errorMessage);
        return message;
    }
    // ******************************Just for reference*****************************
    public void loginToTheApplication(String emailID, String password) {
        sendDataToEmailField(emailID);
        sendDataToPasswordField(password);
        clickOnLoginButton();
    }

    public void sendDataToEmailField (String emailId) {
        sendTextToElement(emailField, emailId);
    }

    public void sendDataToPasswordField (String password) {
        sendTextToElement(passwordField, password);
    }
    public String getLoginUnsuccessfulMessage() {
        return getTextFromElement(loginUnsuccessfulMessage);
    }

}
