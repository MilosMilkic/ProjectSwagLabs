import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement productJacket;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement productBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    WebElement productOnesie;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement productBikeLight;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement productTShirt;

    @FindBy(className = "product_sort_container")
    WebElement sortContainer;

    @FindBy(css = "#shopping_cart_container .shopping_cart_link ")
    WebElement shoppingCart;

    @FindBy(css = ".header_secondary_container .title")
    WebElement pageOfProducts;

    public InventoryPage(ChromeDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void addJacket()
    {
        productJacket.click();
    }
    public void addBackpack()
    {
        productBackpack.click();
    }
    public void addOnesie()
    {
        productOnesie.click();
    }
    public void addTShirt()
    {
        productTShirt.click();
    }
    public void addBikeLight()
    {
        productBikeLight.click();
    }

    public void sortProducts()
    {
        Select select = new Select(sortContainer);
        select.selectByValue("lohi");
    }

    public String getCartNumber()
    {
        return  shoppingCart.getText();
    }

    public void clickCart()
    {
        shoppingCart.click();
    }

    public String productsPage()
    {
        return pageOfProducts.getText();
    }
}
