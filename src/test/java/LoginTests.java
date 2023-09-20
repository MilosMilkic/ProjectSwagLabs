import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{
    @Test
    public void loginWithValidCredentials()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "User is login successfully");
    }

    @Test
    public void loginWithInvalidUserName()
    {
        loginPage.enterUserName("standard");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithInvalidPassword()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("user");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithOutPassword()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWithOutUserNameAndPassword()
    {
        loginPage.enterUserName("");
        loginPage.enterPassword("");
        loginPage.clickLogin();
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username is required");
    }
}
