package tests.Day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C2_IFrame {
    WebDriver driver;
    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
       // driver.close();
    }
    @Test
    public void iFrameTest(){
//● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
// ● Bir metod olusturun: iframeTest
// ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
        SoftAssert softAssert=new SoftAssert();
        WebElement iFrameYazisiWebElementi=driver.findElement(By.tagName("h3"));
        softAssert.assertTrue(iFrameYazisiWebElementi.isEnabled());
        System.out.println(iFrameYazisiWebElementi.getText());
        // ○ Text Box’a “Merhaba Dunya!” yazin.
        driver.switchTo().frame("mce_0_ifr");
       WebElement textBox= driver.findElement(By.tagName("p"));
       textBox.clear();
       textBox.sendKeys("Merhaba Dunya");
       //39.satirda Iframein icine girdik.Simdi iFRamenin disindan bir islem yapmak istiyorsak
        // Iframeden cikmamiz gerekiyor.
       driver.switchTo().defaultContent();

// ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.
      WebElement linkElement= driver.findElement(By.linkText("Elemental Selenium"));
      softAssert.assertTrue(linkElement.isDisplayed());
        System.out.println(linkElement.getText());



    softAssert.assertAll();
    }
}
