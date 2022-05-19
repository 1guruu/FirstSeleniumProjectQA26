import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class RegisterTest {
    private WebDriver driver;

    public static void wait ( int mil){
        try {
            Thread.sleep(mil);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

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
        String email = RandomStringUtils.randomAlphanumeric(10) + "@email.com";
        driver.findElement(By.id("email_address")).sendKeys(email);
        wait(1500);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirmation")).sendKeys("123456");
        driver.findElement(By.cssSelector(".buttons-set span")).click();
        WebElement dashboardTextElement = driver.findElement(By.cssSelector(".success-msg span"));
        String textFromElement = driver.findElement(By.cssSelector(".hello strong")).getText();
        Assert.assertTrue(dashboardTextElement.isDisplayed());
        Assert.assertEquals("Hello, Marius Marinescu!", textFromElement);



    }


    public void randomRegisterTest() {



        String qty = driver.findElement(By.cssSelector(".qty")).getAttribute("value");

        WebElement womenCategory = driver.findElement(By.cssSelector(".level0 > a[href*='women']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(womenCategory).perform();

        WebElement element = driver.findElement(By.id("select-language"));
        Select selectLanguage = new Select(element);
        selectLanguage.selectByVisibleText("German");
        wait(1500);
    }




    @After
    public void close(){
        driver.close();
    }
}
