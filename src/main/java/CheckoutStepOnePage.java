import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutStepOnePage extends  BasePage {
    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueButton;

    public CheckoutStepOnePage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputForm(String name, String last, String zipCode)
    {
        firstName.sendKeys(name);
        lastName.sendKeys(last);
        postalCode.sendKeys(zipCode);
    }
    public void clickContinue(){continueButton.click();}
}
