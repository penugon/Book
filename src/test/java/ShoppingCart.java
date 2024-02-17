import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShoppingCart {
    public WebDriver driver;

    @BeforeMethod
    public void  setUp(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Lenovo\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.bookhaven.ie/");


        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[4]/a"));
        element.click();

        WebElement login = driver.findElement(By.name("login"));
        login.sendKeys("rahul2021@gmail.com");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("rahul@2021");

        WebElement loginbutton = driver.findElement(By.xpath("//button[text()='Log in']"));
        loginbutton.submit();


    }

    @Test(priority = 1)
    public void ShoppingCartElement(){
        WebElement cart = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div[3]/ul/li[3]/a/i"));
        cart.click();
        driver.navigate().back();

        WebElement findingBooks = driver.findElement(By.linkText("Secondary"));
        findingBooks.click();

        WebElement add = driver.findElement(By.xpath("//td[@class ='oe_product'][2]"));
        add.click();

        WebElement addTo = driver.findElement(By.linkText("ADD TO CART"));
        addTo.click();

        WebElement append = driver.findElement(By.className("input-group-append"));
        append.click();

        WebElement prepend = driver.findElement(By.className("input-group-prepend"));
        prepend.click();

    }
    @Test(priority = 2)
    public void BookDetails(){
        WebElement findingBooks = driver.findElement(By.linkText("Primary"));
        findingBooks.click();

        WebElement add = driver.findElement(By.xpath("//td[@class ='oe_product'][1]"));
        add.click();

        WebElement image = driver.findElement(By.xpath("/html/body/div[1]/main/div/section/div[2]/div[1]/div/div[1]/div/div/div/img"));
        Assert.assertTrue(image.isDisplayed(),"Image Element is not Present");

        WebElement heading = driver.findElement(By.tagName("h1"));
        String text = heading.getText();
        System.out.println(text);
        String exepected = "Grow in Love 2nd Class (Book 4)";
        Assert.assertEquals(exepected,text,"Text doesn't match");

        WebElement price = driver.findElement(By.className("css_editable_mode_hidden"));
        System.out.println(price.getText());
        Assert.assertTrue(price.isDisplayed(),"price Element is not present");


        WebElement sentence = driver.findElement(By.id("o_product_terms_and_share"));
        Assert.assertTrue(sentence.isDisplayed(),"Sentence Element is not Present");



    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
