import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterTest {
    private WebDriver driver;

    @Before
    public void open(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }

    @Test
    public void validRegisterTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector(".links [title='Register']")).click();
        driver.findElement(By.id("firstname")).sendKeys("Marius");
        driver.findElement(By.id("lastname")).sendKeys("Marinescu");
        driver.findElement(By.id("email_address")).sendKeys("antonescumarius@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector(".buttons-set span")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".success-msg span"));
        String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, Marius Marinescu!", textFromElement);



    }

    @After
    public void close(){
        driver.close();
    }
}
