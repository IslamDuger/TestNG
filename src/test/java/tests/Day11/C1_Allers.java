package tests.Day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class C1_Allers {
    /*
    ● Bir class olusturun: D12_Alerts
● https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
● Bir metod olusturun: acceptAlert
 ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfuly clicked an alert” oldugunu test edin.
● Bir metod olusturun: dismissAlert
 ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
● Bir metod olusturun: sendKeysAlert
 ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

     */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }

    @AfterClass
    public void tearDown() {
       driver.close();
    }

    @Test
    public void acceptAlert() {


// ○ 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        driver.switchTo().alert().accept();
        WebElement sonucYasisi = driver.findElement(By.xpath("//*[@id='result']"));
        String expectYasisi = "You successfully clicked an alert";
        String actualYazisi = sonucYasisi.getText();
        Assert.assertEquals(actualYazisi, expectYasisi);
    }

//● Bir metod olusturun: dismissAlert
        @Test
       public void dismissAlert(){
         driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
         driver.switchTo().alert().dismiss();
         WebElement sonucYasisi = driver.findElement(By.xpath("//*[@id='result']"));
         String unExpectYasisi = "successfuly";
         String unActualYazisi = sonucYasisi.getText();
         Assert.assertFalse(unActualYazisi.contains(unExpectYasisi));

        }
// ○ 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.


//● Bir metod olusturun: sendKeysAlert
    @Test
    public void sendKeysAlert() throws InterruptedException {
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Islam");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        WebElement sonucYasisi = driver.findElement(By.xpath("//*[@id='result']"));
        String actuleResultYazisi=sonucYasisi.getText();
        String isim="Islam";
        Assert.assertTrue(actuleResultYazisi.contains(isim));

    }

// ○ 3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.


    }

