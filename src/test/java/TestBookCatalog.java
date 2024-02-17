import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class TestBookCatalog {
    public WebDriver driver;


    @BeforeMethod
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bookhaven.ie/");


        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[4]/a"));
        element.click();

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("rahul2021@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("rahul@2021");

        WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginbutton.submit();



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void ElementsDisplayedOrNot(){
        WebElement logo = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[1]/a/span/img"));

        WebElement searchelement = driver.findElement(By.name("search"));

        List<WebElement> list = driver.findElements(By.xpath("//li[contains(@class, 'nav-i')]/descendant::*"));
        for(int i = 1; i <= 10; i++){
            if(list.size() > 0){
                System.out.println(list.size());
            }else{
                System.out.println("No Elements found");
            }

        }

        WebElement endlogo = driver.findElement(By.tagName("h3"));
        String current = endlogo.getText();
        String actual ="Documents";

        List<WebElement> information = driver.findElements(By.cssSelector("div[class $='list-group']>*"));
        for(int i = 1; i <= 4; i++){
            if(information.size() == 4){
                System.out.println(list.size());
            }else{
                System.out.println("Information Elements are not found");
            }
        }



        Assert.assertTrue(logo.isDisplayed(),"Store Logo is not Present");

        Assert.assertTrue(searchelement.isDisplayed(),"Search Element is not Present");


        Assert.assertEquals(actual,current,"Text doesn't match");

    }


}
