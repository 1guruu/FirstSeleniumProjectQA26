import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoppingCart {
    private WebDriver driver;

    @Before
    public void open(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }
    private void logIn(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
    }

    @Test
    public void ViewCartLoggedIn()  {
        logIn();
        driver.findElement(By.cssSelector(".skip-cart .label")).click();
        driver.findElement(By.cssSelector(".cart-link")).click();
        WebElement cartTextElement = driver.findElement(By.cssSelector(".cart h1"));
        String textFromElement = driver.findElement(By.cssSelector(".cart h1")).getText();
        Assert.assertTrue(cartTextElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART", textFromElement);
    }

    @Test
    public void ViewCartNotLoggedIn(){
        driver.findElement(By.cssSelector(".skip-cart .label")).click();
        WebElement cartTextElement = driver.findElement(By.cssSelector("p.empty"));
        String textFromElement = driver.findElement(By.cssSelector("p.empty")).getText();
        Assert.assertTrue(cartTextElement.isDisplayed());
        Assert.assertEquals("You have no items in your shopping cart",textFromElement);
    }

    @Test
    public void ViewCartNotLoggedIn2(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".top-link-cart")).click();
        WebElement cartTextElement = driver.findElement(By.cssSelector(".page-title"));
        String textFromElement = driver.findElement(By.cssSelector(".page-title h1")).getText();
        Assert.assertTrue(cartTextElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART IS EMPTY",textFromElement);
    }

    @Test

    public void addToCartLoggedIn(){
        logIn();
        driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
        driver.findElement(By.cssSelector(".actions [title='View Details']")).click();
        driver.findElement(By.cssSelector("#swatch27 img")).click();
        driver.findElement(By.cssSelector("#option81 .x")).click();
        driver.findElement(By.cssSelector(".validation-passed span")).click();
        WebElement checkoutTextElement = driver.findElement(By.cssSelector(".cart h1"));
        String textFromElement = driver.findElement(By.cssSelector(".cart h1")).getText();
        Assert.assertTrue(checkoutTextElement.isDisplayed());
        Assert.assertEquals("SHOPPING CART", textFromElement);
    }

    @Test
    public void removeFromCartLoggedIn()  {
        logIn();
        driver.findElement(By.cssSelector(".skip-cart .label")).click();
        driver.findElement(By.cssSelector("a.cart-link")).click();
        driver.findElement(By.cssSelector("td.product-cart-remove .btn-remove")).click();
        WebElement checkoutTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector(".cart-empty p:first-child")).getText();
        Assert.assertTrue(checkoutTextElement.isDisplayed());
        Assert.assertEquals("You have no items in your shopping cart.", textFromElement);


    }




    @After
    public void close(){
        driver.close();
    }

}
