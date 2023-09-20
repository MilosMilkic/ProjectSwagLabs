import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest{

    @Test
    public void sortAndAddProductsToTheCart()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.sortProducts();
        inventoryPage.addOnesie();
        inventoryPage.addBikeLight();
        inventoryPage.addTShirt();
        inventoryPage.clickCart();
        Assert.assertEquals(inventoryPage.getCartNumber(), "3");
        Assert.assertEquals(cartPage.getInfoOnesie(), "Sauce Labs Onesie");
        Assert.assertEquals(cartPage.getInfoLight(), "Sauce Labs Bike Light");
        Assert.assertEquals(cartPage.getInfoTShirt(), "Sauce Labs Bolt T-Shirt");
    }
}
