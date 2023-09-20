import org.testng.Assert;
import org.testng.annotations.Test;

public class TotalPriceTest extends BaseTest{

    @Test
    public void verifyTotalAndItemTotalPrice()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.addBackpack();
        inventoryPage.addBikeLight();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputForm("Miki", "Misko", "11000");
        checkoutStepOnePage.clickContinue();
        Assert.assertEquals(checkoutStepTwoPage.getTotalPrice(), "Total: $43.18");
        Assert.assertEquals(checkoutStepTwoPage.getItemTotalPrice(), "Item total: $39.98");
    }
}