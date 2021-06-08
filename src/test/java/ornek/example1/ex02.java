package ornek.example1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ex02 {
    WebDriver driver;
@BeforeClass
public void setup(){
    WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://the-internet.herokuapp.com/iframe");

}
@Test
    public void IframeTest(){

    //● Bir metod olusturun: iframeTest

    //○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda    yazdirin.
    //An iFrame containing the TinyMCE WYSIWYG Editor
    WebElement yazi=driver.findElement(By.tagName("h3"));
    String expectText="An iFrame containing the TinyMCE WYSIWYG Editor";
    String actualText= yazi.getText();
    Assert.assertTrue(actualText.contains(expectText));
    System.out.println(yazi.getText());
    //○ Text Box’a “Merhaba Dunya!” yazin.
    driver.switchTo().frame(0);
    WebElement kutu= driver.findElement(By.tagName("p"));
    kutu.clear();
    kutu.sendKeys("Merhba dunya");
    driver.switchTo().defaultContent();

    //○ TextBox’in altinda bulunan “Elemental Selenium”
    //linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
    WebElement linkYazisi=driver.findElement(By.linkText("Elemental Selenium"));
    String expectLinkYazisi="Elemental Selenium";
    String actualLink=linkYazisi.getText();
    Assert.assertTrue(actualLink.contains(expectLinkYazisi));
    System.out.println(linkYazisi.getText());
}
@AfterClass
    public void tearDown(){
    driver.close();
}
}
