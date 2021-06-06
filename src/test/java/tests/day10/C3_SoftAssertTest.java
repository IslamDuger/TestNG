package tests.day10;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_SoftAssertTest {
    /*
    Yeni bir Class Olusturun : D10_SoftAssertTest
1. “http://zero.webappsecurity.com/” Adresine gidin
  2.Sign in butonuna basin
 3. Login kutusuna “username” yazin
 4. Password kutusuna “password.” yazin
 5. Sign in tusuna basin
 6. Pay Bills sayfasina gidin
 7. “Purchase Foreign Currency” tusuna basin
 8. “Currency” drop down menusunden Eurozone’u secin
 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
     */
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void DropdownTesti() {
       // 1. “http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com");
       // 2.Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
       //3. Login kutusuna “username” yazin
        WebElement loginKutusu= driver.findElement(By.xpath("//input[@type='text']"));
        loginKutusu.sendKeys("username");
       // 4. Password kutusuna “password.” yazin
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("password");
       // 5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
       // // guvenlik icin
        driver.findElement(By.xpath("//button[@id='details-button']")).click();
        driver.findElement(By.xpath("//a[@id='proceed-link']")).click();
       // 6. Pay Bills sayfasina gidin
       // 7. “Purchase Foreign Currency” tusuna basin
       // 8. “Currency” drop down menusunden Eurozone’u secin
       // 9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
       // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"







    }
}
