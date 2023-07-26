import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BasePage {
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
