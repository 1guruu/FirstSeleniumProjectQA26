import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest2 {


    public class WishListTest {
        private WebDriver driver;

        @Before
        public void open(){
            System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("http://testfasttrackit.info/selenium-test/");

        }


        @Test

        public void AddToWishList()  {
            driver.findElement(By.cssSelector(".skip-account .label")).click();
            driver.findElement(By.cssSelector("a[title='Log In']")).click();
            driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
            driver.findElement(By.id("pass")).sendKeys("123456");
            driver.findElement(By.id("send2")).click();
            driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
            driver.findElement(By.cssSelector(".actions [title='View Details']")).click();
            driver.findElement(By.cssSelector("a.link-wishlist")).click();
            WebElement wishlistTextElement = driver.findElement(By.cssSelector(".success-msg span"));
            Assert.assertTrue(wishlistTextElement.isDisplayed());


        }

        @After
        public void close(){
            driver.close();
        }


    }

}
