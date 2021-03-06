import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishListTest {

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

        public void AddToWishListLoggenIn()  {
            logIn();
            driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
            driver.findElement(By.cssSelector(".actions [title='View Details']")).click();
            driver.findElement(By.cssSelector("a.link-wishlist")).click();
            WebElement wishlistTextElement = driver.findElement(By.cssSelector(".success-msg span"));
            Assert.assertTrue(wishlistTextElement.isDisplayed());


        }
        @Test

        public void AddToWishListNotLoggedIn()  {
            driver.findElement(By.cssSelector(".nav-5 .has-children")).click();
            driver.findElement(By.cssSelector(".actions [title='View Details']")).click();
            driver.findElement(By.cssSelector("a.link-wishlist")).click();
            WebElement wishlistTextElement = driver.findElement(By.cssSelector(".success-msg span"));
            Assert.assertTrue(wishlistTextElement.isDisplayed());
        }





        @Test
        public void GoToCheckoutLoggedIn(){
            logIn();
            driver.findElement(By.cssSelector(".skip-cart .label")).click();
            driver.findElement(By.cssSelector(".checkout-button")).click();
            WebElement checkoutTextElement = driver.findElement(By.cssSelector(".page-title h1"));
            String textFromElement = driver.findElement(By.cssSelector(".page-title h1")).getText();
            Assert.assertTrue(checkoutTextElement.isDisplayed());
            Assert.assertEquals("CHECKOUT", textFromElement);
        }




        @After
        public void close(){
            driver.close();
        }


    }


