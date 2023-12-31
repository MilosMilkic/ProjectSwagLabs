import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    WebElement userName;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    @FindBy(css = ".error h3")
    WebElement loginErrorMess;

    public LoginPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUserName(String name){userName.sendKeys(name);}
    public void enterPassword(String pass){password.sendKeys(pass);}
    public void clickLogin(){loginBtn.submit();}
}