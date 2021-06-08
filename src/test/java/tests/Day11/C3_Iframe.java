package tests.Day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C3_Iframe {
    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void iframe(){
        // https://html.com/tags/iframe/ adresine gidin
        // youtube videosunu calistirin

        driver=new ChromeDriver();
        driver.get("https://html.com/tags/iframe/");
        WebElement iFrameclick=driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(iFrameclick);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();



    }
    @AfterMethod
    public void tearDouwn(){
        driver.close();
    }
}
