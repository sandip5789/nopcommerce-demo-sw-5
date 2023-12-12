package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

        HomePage homePage;
        LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        homePage = new HomePage();
        loginPage = new LoginPage();
    }

    // 1.userShouldNavigateToLoginPageSuccessFully()
    @Test(groups = {"sanity","smoke","regression"})
    public void userShouldNavigateToLoginPageSuccessFully(){
        // Click on login link
        homePage.clickOnLoginLink();
        // verify that "Welcome, Please Sign In!" message display
        String expectedMessage = "Welcome, Please Sign In!";
        String actualMessage = loginPage.getWelcomeText();
        Assert.assertEquals(actualMessage,expectedMessage, "Login page not displayed");
    }
    // 2. verifyTheErrorMessageWithInValidCredentials().
    @Test(groups = {"smoke","regression"})
    public void verifyTheErrorMessageWithInValidCredentials(){
        // Click on login link
        homePage.clickOnLoginLink();
        //Enter EmailId ,Enter Password ,Click on Login Button
        loginPage.loginToApplication("prime78@gmail.com","pr123");
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"Error message not displayed");

    }
    // 3. verifyThatUserShouldLogInSuccessFullyWithValidCredentials.
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials(){
        // Click on login link
        homePage.clickOnLoginLink();
        // Enter EmailId ,Enter Password ,Click on Login Button
        loginPage.loginToApplication("mj2000@gmail.com","mj1234");
        // Verify that LogOut link is display
        Assert.assertTrue(homePage.isLogoutLinkAvailable(),"LogOut link is not available");

    }
    // 4. verifyThatUserShouldLogOutSuccessFully()
    @Test(groups = {"regression"})
    public void verifyThatUserShouldLogOutSuccessFully() {
        // Click on login link
        homePage.clickOnLoginLink();
        // Enter EmailId ,Enter Password ,Click on Login Button
        loginPage.loginToApplication("mj2000@gmail.com", "mj1234");
        // Click on LogOut Link
        homePage.clickOnLogOut();
        //  Verify that LogIn Link Display
        homePage.explicitWait(15);
        Assert.assertTrue(homePage.isLoginLinkAvailable(), "Login link is not available");
    }
}
