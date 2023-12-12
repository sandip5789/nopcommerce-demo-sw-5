package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class ComputerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//h1[normalize-space()='Computers']")
    WebElement computerText;

    @CacheLookup
    @FindBy(xpath = "//a[@title='Show products in category Desktops'][normalize-space()='Desktops']")
    WebElement desktopsLink;

    public String verifyComputerText(){
        String text = getTextFromElement(computerText);
        return text;
    }
    public void clickOnDesktopLink(){
        clickOnElement(desktopsLink);
    }
}
