import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
    private WebDriver driver;

    @Before
            public void open(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://testfasttrackit.info/selenium-test/");
    }






@Test
    public void loginWithValidCredentialsTest() {
        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, Robert Csete!", textFromElement);
    }


    @Test
    public void loginWithInvalidPasswordTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement((By.cssSelector((".error-msg span"))));
        String textLogin = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.",textLogin);
    }
    @Test
    public void loginWithInvalidEmail(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("121233456");
        driver.findElement(By.id("send2")).click();
        String textLogin = driver.findElement(By.cssSelector(".error-msg span")).getText();
        Assert.assertEquals("Invalid login or password.",textLogin);

    }
    @Test
    public void loginWithoutCredentialsTest(){

        driver.findElement(By.cssSelector(".skip-account .label")).click();
//        WebElement accountLink = driver.findElement(By.cssSelector("#header > div > div.skip-links > div > a > span.label"));
//        accountLink.click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("send2")).click();
        WebElement dashboardTextElement = driver.findElement(By.id("advice-required-entry-email"));
        WebElement dashboardTextElement2= driver.findElement(By.id("advice-required-entry-pass"));
        String textLogin= driver.findElement(By.id("advice-required-entry-email")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertTrue(dashboardTextElement2.isDisplayed());
        Assert.assertEquals("This is a required field.",textLogin);

    }




    @After
            public void close(){
        driver.close();
    }
}
