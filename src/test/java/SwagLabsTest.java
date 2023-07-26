import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwagLabsTest extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOnePage;
    CheckoutStepTwoPage checkoutStepTwoPage;


    @BeforeMethod
    public void setUp()
    {
        driver = openBrowser();
        loginPage = new LoginPage(driver);
        inventoryPage = new InventoryPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
    }

    @Test
    public void sortAndAddToCartThreeProducts()
    {
        loginPage.loginOnPage("standard_user", "secret_sauce");
        inventoryPage.sortProducts();
        inventoryPage.addOnesie();
        inventoryPage.addBikeLight();
        inventoryPage.addT_Shirt();
        Assert.assertEquals(inventoryPage.getCartNumber(), "3");
        inventoryPage.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getInfoOnesie(), "Sauce Labs Onesie");
        Assert.assertEquals(cartPage.getInfoLight(), "Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getInfoTShirt(), "Sauce Labs Bolt T-Shirt");
    }

    @Test
    public void addToCartTwoProductsAndRemoveFromInsideCart()
    {
        loginPage.loginOnPage("standard_user", "secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.addJacket();
        inventoryPage.clickCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getInfoBackpack(), "Sauce Labs Backpack");
        Assert.assertEquals(cartPage.getInfoJacket(), "Sauce Labs Fleece Jacket");
        cartPage.removeBackpack();
        cartPage.removeJacket();
        cartPage.continueShopping();
        Assert.assertEquals(inventoryPage.productsPage(), "Products");
        Assert.assertEquals(inventoryPage.getCartNumber(), "");
    }


    @Test
    public void verifyTotalAndItemTotalPrice()
    {
        loginPage.loginOnPage("standard_user", "secret_sauce");
        inventoryPage.addBackpack();
        inventoryPage.addBikeLight();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputForm("Miki", "Misko", "11000");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkoutStepTwoPage.getItemTotalPrice(), "Item total: $39.98");
        Assert.assertEquals(checkoutStepTwoPage.getTotalPrice(), "Total: $43.18");
    }

    @Test
    public void buyProduct()
    {
        loginPage.loginOnPage("standard_user", "secret_sauce");
        inventoryPage.addJacket();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputForm("Miki", "Misko", "11000");
        checkoutStepTwoPage.clickFinish();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html");
        Assert.assertEquals(checkoutStepTwoPage.getInfoMessage(),"Thank you for your order!");
    }

    @AfterMethod
    public void after()
    {
        driver.quit();
    }
}

