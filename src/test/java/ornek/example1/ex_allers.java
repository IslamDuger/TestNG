package ornek.example1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ex_allers {
    WebDriver driver;

@BeforeMethod
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

}
@Test
    public void acceptAllerts() {

//● Bir class olusturun: D12_Alerts
//https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//Bir metod olusturun: acceptAlert
// 1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının “You successfuly clicked an alert” oldugunu test edin.
    driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
    driver.switchTo().alert().accept();
}
//Bir metod olusturun: dismissAlert
@Test
public void dismissAlert() throws InterruptedException {
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
// 2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının   “successfuly” icermedigini test edin.
driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();
driver.switchTo().alert().dismiss();
WebElement sonucYazisi= driver.findElement(By.id("result"));
String expectSonuc="successfuly";
String actualSonuc=sonucYazisi.getText();
Assert.assertTrue(actualSonuc.contains(expectSonuc));
System.out.println(sonucYazisi.getText());
    }
    @Test
    public void sendKeys() {

        //Bir metod olusturun: sendKeysAlert

//3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna  tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        driver.switchTo().alert().sendKeys("Islam");
        driver.switchTo().alert().accept();
        WebElement sonucYaiz= driver.findElement(By.xpath("//p[@id='result']"));
        String expectYazi="Islam";
        String actualYazi=sonucYaiz.getText();
        Assert.assertTrue(actualYazi.contains(expectYazi));
        System.out.println(sonucYaiz.getText());
}
@AfterMethod
    public void tearDown(){
    driver.close();
}

}

