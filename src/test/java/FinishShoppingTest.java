import org.testng.Assert;
import org.testng.annotations.Test;

public class FinishShoppingTest extends BaseTest {
    @Test
    public void buyProduct()
    {
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
        inventoryPage.addJacket();
        inventoryPage.clickCart();
        cartPage.clickCheckout();
        checkoutStepOnePage.inputForm("Miki", "Misko", "11000");
        checkoutStepOnePage.clickContinue();
        checkoutStepTwoPage.clickFinish();
        Assert.assertEquals(checkoutStepTwoPage.getInfoMessage(),"Thank you for your order!");

    }

}
