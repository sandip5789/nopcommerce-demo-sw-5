package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Utility {

    @CacheLookup
    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @CacheLookup
    @FindBy(linkText = "Register")
    WebElement registerLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logOutLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log in']")
    WebElement loginLinkText;

    @CacheLookup
    @FindBy(linkText = "Computers")
    WebElement computerLink;

    // *************************** For Reference ********************************************
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='Welcome to our store']")
    WebElement welcomeText;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']")
    WebElement computersPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    WebElement electronicsPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Apparel']")
    WebElement apparelPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Digital downloads']")
    WebElement digitalDownloadsPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Books']")
    WebElement booksPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Jewelry']")
    WebElement jewelryPageLink;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Gift Cards']")
    WebElement giftCardsPageLink;


    @CacheLookup
    @FindBy(xpath = "//img[@alt='nopCommerce demo store']")
    WebElement nopCommerceLogo;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li/a")
    WebElement listOfTopMenu;

    @CacheLookup
    @FindBy(xpath = "//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']")
    WebElement cellPhoneSubMenuLink;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Log out']")
    WebElement logoutLink;

    ///**************************************** end ************************************************************

    public void clickOnLoginLink(){
        clickOnElement(loginLink);
    }

    public void clickOnRegisterLink(){
        clickOnElement(registerLink);
    }
    public void clickOnLogOut(){
        clickOnElement(logOutLink);
    }
    public String getLogOutLinkIsDisplay(){
        String text = getTextFromElement(logOutLink);
        return text;
    }
    public String getLogInLinkIsDisplay(){
        String text = getTextFromElement(loginLinkText);
        return text;
    }
    public void clickOnComputerTab(){
        clickOnElement(computerLink);
    }
    public void clickOnComputersMenu () {
        clickOnElement(computersPageLink);
    }

    public void mouseHoverOnElectronicsMenu () {
        mouseHoverToElement(electronicsPageLink);
    }

    public void mouseHoverAndClickOnCellPhoneSubMenu() {
        mouseHoverToElementAndClick(cellPhoneSubMenuLink);
    }

    public void clickOnElectronicsMenu () {
        clickOnElement(electronicsPageLink);
    }

    public void clickOnApparelMenu () {
        clickOnElement(apparelPageLink);
    }

    public void clickOnDigitalDownloadsMenu () {
        clickOnElement(digitalDownloadsPageLink);
    }

    public void clickOnBooksMenu () {
        clickOnElement(booksPageLink);
    }

    public void clickOnJewelryMenu () {
        clickOnElement(jewelryPageLink);
    }

    public void clickOnGiftCardsMenu () {
        clickOnElement(giftCardsPageLink);
    }

    public void clickOnLogout() {
        clickOnElement(logoutLink);
    }

    public boolean isLoginLinkAvailable() {
        System.out.println("LoginLink: " + loginLink.getText());
        return verifyThatElementIsDisplayed(loginLink);
    }

    public boolean isLogoutLinkAvailable() {
        return verifyThatElementIsDisplayed(logoutLink);
    }

    public boolean verifyNopCommerceLogoDisplay() {
        return verifyThatElementIsDisplayed(nopCommerceLogo);
    }

    public void explicitWait(int time) {
        waitUntilVisibilityOfElementLocated(By.className("ico-login"), time);
    }


}
