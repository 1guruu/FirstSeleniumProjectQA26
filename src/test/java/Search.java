import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Search {
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

    private void logIn(){
        driver.findElement(By.cssSelector(".skip-account .label")).click();
        driver.findElement(By.cssSelector("a[title='Log In']")).click();
        driver.findElement(By.id("email")).sendKeys("robertcsete@yahoo.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.id("send2")).click();
    }

    @Test
    public void searchEmpty(){
        driver.findElement(By.cssSelector(".search-button")).click();
        driver.findElement(By.cssSelector("#search .required-entry . validation-failed")).isDisplayed();

    }

    @Test
    public void searchNumbersNotLoggedIn(){
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomNumeric(5) ;
        driver.findElement(By.id("search")).sendKeys(search);
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);
    }

    @Test
    public void searchLettersNotLoggedIn(){
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomAlphabetic(5) ;
        driver.findElement(By.id("search")).sendKeys(search);
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);
    }

    @Test
    public void searchNumbersLoggedIn(){
        logIn();
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomNumeric(5) ;
        driver.findElement(By.id("search")).sendKeys(search);
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);
    }

    @Test
    public void searchLettersLoggedIn(){
        logIn();
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomAlphabetic(5) ;
        driver.findElement(By.id("search")).sendKeys(search);
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);

    }

    @Test
    public void searchAlphanumericLoggedIn(){
        logIn();
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomAlphanumeric(6) ;
        driver.findElement(By.id("search")).sendKeys(search);
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);

    }

    @Test
    public void searchAlphanumericNotLoggedIn(){
        driver.findElement(By.id("search"));
        String search = RandomStringUtils.randomAlphanumeric(6) ;
        driver.findElement(By.id("search")).sendKeys(search);
        driver.findElement(By.cssSelector(".search-button")).click();
        WebElement searchTextElement = driver.findElement(By.cssSelector(".page-title h1"));
        String textFromElement = driver.findElement(By.cssSelector("p.note-msg")).getText();
        Assert.assertTrue(searchTextElement.isDisplayed());
        Assert.assertEquals("Your search returns no results.", textFromElement);
    }


    @After
    public void close(){
        driver.close();
    }
}
