import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BookStoreTest {
    public WebDriver driver;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bookhaven.ie/");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void Registration(){
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[4]/a"));
        element.click();

        WebElement res = driver.findElement(By.xpath("/html/body/div[1]/main/div/form/div[3]/div[1]/a[1]"));
        res.click();

        WebElement email = driver.findElement(By.id("login"));
        email.sendKeys("rahul2021@gmail.com");

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("rahul");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("rahul@2021");

        WebElement conform = driver.findElement(By.id("confirm_password"));
        conform.sendKeys("rahul@2021");

        WebElement signup = driver.findElement(By.xpath("//button[text()=' Sign up']"));
        signup.click();

    }
    @Test(priority = 1)
    public void LoginAndPassword(){
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[4]/a"));
        element.click();

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("rahul2021@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("rahul@2021");

        WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginbutton.submit();
    }
    @Test(priority = 2)
    public void ResetPassword(){
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[4]/a"));
        element.click();

        WebElement reset = driver.findElement(By.linkText("Reset Password"));
        reset.click();

        WebElement conform = driver.findElement(By.name("login"));
        conform.sendKeys("rahul2021@gmail.com");

        WebElement confirmbutton = driver.findElement(By.xpath("//button[text()='Confirm']"));
        confirmbutton.click();
    }



}
