package tests.day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C1_Priority {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Before method calisti");

    }
    @AfterMethod
    public void tearDouwn(){
        driver.close();
        System.out.println("After method calsti");
    }
    @Test (priority = 2)
    public void test01(){
        System.out.println("test01 calisti");
    }
    @Test
    public void ikinciTest(){
        System.out.println("Ikinci calisti");
    }
    @Test (priority = 8)
    public void selam(){
        System.out.println("Selam calisti");
    }
}
