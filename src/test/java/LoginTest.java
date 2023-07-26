import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    LoginPage loginPage;

    @BeforeMethod
    public void setUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithWalidData()
    {
        loginPage.loginOnPage("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginWithInvalidPassword()
    {
        loginPage.loginOnPage("standard_user", "user");
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithOutPassword()
    {
        loginPage.loginOnPage("standard_user", "");
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Password is required");
    }

    @Test
    public void loginWithInvalidUserName()
    {
        loginPage.loginOnPage("standard", "secret_sauce");
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginWithOutData()
    {
        loginPage.loginOnPage("", "");
        Assert.assertTrue(loginPage.loginErrorMess.isDisplayed(), "Epic sadface: Username is required");
    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }

}
