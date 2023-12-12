package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.BuildYourOwnComputerPage;
import com.nopcommerce.demo.pages.ComputerPage;
import com.nopcommerce.demo.pages.DesktopsPage;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;


@Listeners(CustomListeners.class)
public class ComputerPageTest extends BaseTest {

    HomePage homePage;
    ComputerPage computerPage;
    DesktopsPage desktopsPage;
    BuildYourOwnComputerPage buildYourOwnComputerPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        computerPage = new ComputerPage();
        desktopsPage = new DesktopsPage();
        buildYourOwnComputerPage =new BuildYourOwnComputerPage();

    }

    // 1. verifyUserShouldNavigateToComputerPageSuccessfully()
    @Test(groups = {"sanity","smoke","regression"})
    public void verifyUserShouldNavigateToComputerPageSuccessfully() {
        // Click on Computer tab
        homePage.clickOnComputerTab();
        // Verify "Computer" text
        String expectedText = "Computers";
        String actualText = computerPage.verifyComputerText();
        Assert.assertEquals(actualText, expectedText, "Computer not displayed");
    }

    // 2. verifyUserShouldNavigateToDesktopsPageSuccessfully()
    @Test(groups = {"smoke","regression"})
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        // Click on Computer tab
        homePage.clickOnComputerTab();
        // Click on Desktops link
        computerPage.clickOnDesktopLink();
        // Verify "Desktops" text
        String expectedText = "Desktops";
        String actualText = desktopsPage.verifyDesktopText();
        Assert.assertEquals(actualText, expectedText, "Desktop not displayed");

    }

    // 3. verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String
    //processor, String ram, String hdd, String os, String software)
    @Test(dataProvider = "builtYourOwnComputer", dataProviderClass = TestData.class,groups = {"regression"})
    public void verifyThatUserShouldBuildYouOwnComputerAndAddThemToCartSuccessfully(String processor, String ram,
                                                                                    String hdd, String os, String software) {
        // Click on Computer tab
        homePage.clickOnComputerTab();
        // Click on Desktops link
        computerPage.clickOnDesktopLink();
        // Click on product name "Build your own computer"
        desktopsPage.clickOnBuildYourOwnComputer();
       // Select processor "processor" ,Select RAM "ram" ,Select HDD "hdd" ,Select OS "os" ,Select Software "software"
        buildYourOwnComputerPage.optionsToBuiltYourOwnComputer(processor,ram,hdd,os,software);
        // Click on "ADD TO CART" Button
        buildYourOwnComputerPage.clickOnAddToCart();
        // Verify message "The product has been added to your shopping cart"
        String expectedMessage = "The product has been added to your shopping cart";
        String actualMessage = buildYourOwnComputerPage.getAddToCartSuccessfulMessage();
        Assert.assertEquals(actualMessage, expectedMessage, "Product is not added successfully");

    }
}
