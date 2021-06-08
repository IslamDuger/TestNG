package ornek.example1;

import Utilies.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ex03 extends TestBase {
    @Test
    public void softAssertTest() {
        //  Yeni bir Class Olusturun : D10_SoftAssertTest
        //1. "http://zero.webappsecurity.com/" Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        //2. Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //3. Login kutusuna "username" yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");
        //4. Password kutusuna "password." yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");
        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();
        driver.findElement(By.xpath("//*[@id='primary-button']")).click();
        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //7. "Purchase Foreign Currency" tusuna basin
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();
        //8. "Currency" drop down menusunden Eurozone'u secin
        WebElement dropdown=driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select=new Select(dropdown);
        select.selectByIndex(6);


        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        String expectedWord ="Eurozone (euro)";
        String actualWord = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualWord,expectedWord);
        List<String> list3 = Arrays.asList("Select One", "Australia (dollar)","Canada (dollar)","Switzerland (franc)","China (yuan)",
                "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
                "New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)");
        List<WebElement> list1 = select.getOptions();
        List<String> list2 = new ArrayList<>();
        for (WebElement each:list1){
            list2.add(each.getText());
        }
        System.out.println(list2);
        softAssert.assertEquals(list2,list3);
        //   6. Pay Bills sayfasina gidin
        softAssert.assertAll();

    }
}
