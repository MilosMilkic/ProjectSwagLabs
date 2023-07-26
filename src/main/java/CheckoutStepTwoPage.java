import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepTwoPage extends BasePage {
    @FindBy(className = "summary_subtotal_label")
    WebElement itemPrice;

    @FindBy(className = "summary_total_label")
    WebElement totalPrice;

    @FindBy(id = "finish")
    WebElement finish;

    @FindBy(className = "complete-header")
    WebElement infoMess;

    public CheckoutStepTwoPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getItemTotalPrice()
    {
        return itemPrice.getText();
    }

    public String getTotalPrice()
    {
        return totalPrice.getText();
    }

    public void clickFinish()
    {
        finish.click();
    }

    public String getInfoMessage()
    {
        return infoMess.getText();
    }
}
