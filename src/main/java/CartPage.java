import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
    @FindBy(id = "item_2_title_link")
    WebElement verifyOnesie;
    @FindBy(id = "item_0_title_link")
    WebElement verifyBikeLight;
    @FindBy(id = "item_1_title_link")
    WebElement verifyTShirt;
    @FindBy(id = "item_4_title_link")
    WebElement verifyBackpack;
    @FindBy(id = "item_5_title_link")
    WebElement verifyJacket;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    WebElement jacket;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement backpack;

    @FindBy(id = "continue-shopping")
    WebElement continueShop;

    @FindBy(id = "checkout")
    WebElement checkout;

    public CartPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getInfoOnesie()
    {
        return verifyOnesie.getText();
    }
    public String getInfoLight()
    {
        return verifyBikeLight.getText();
    }
    public String getInfoTShirt()
    {
        return verifyTShirt.getText();
    }
    public String getInfoBackpack()
    {
        return verifyBackpack.getText();
    }
    public String getInfoJacket()
    {
        return verifyJacket.getText();
    }

    public void removeJacket()
    {
        jacket.click();
    }

    public void removeBackpack()
    {
        backpack.click();
    }

    public void continueShopping()
    {
        continueShop.click();
    }

    public void clickCheckout()
    {
        checkout.click();
    }
}
