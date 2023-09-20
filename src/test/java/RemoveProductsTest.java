import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductsTest extends  BaseTest{

    @Test
    public void removeProductsFromInsideCart()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.addBackpack();
        inventoryPage.addJacket();
        inventoryPage.clickCart();
        cartPage.removeBackpack();
        cartPage.removeJacket();
        cartPage.continueShopping();
        Assert.assertEquals(inventoryPage.productsPage(), "Products");
        Assert.assertEquals(inventoryPage.getCartNumber(), "");
    }
}