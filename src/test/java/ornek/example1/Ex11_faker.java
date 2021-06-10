package ornek.example1;

import Utilies.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Ex11 extends TestBase {
    @Test
    public void faker(){
            /*
        1."https://facebook.com" Adresine gidin
2.“create new account” butonuna basin
3.“firstName” giris kutusuna bir isim yazin
4.“surname” giris kutusuna bir soyisim yazin
5.“email” giris kutusuna bir email yazin
6.“email” onay kutusuna emaili tekrar yazin
7.Bir sifre girin
8.Tarih icin gun secin
9.Tarih icin ay secin
10.Tarih icin yil secin
11.Cinsiyeti secin
12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
13.Sayfayi kapatin
         */

// 1."https://facebook.com" Adresine gidin
   driver.get("https://facebook.com");
   driver.findElement(By.xpath("//*[@title='Alles accepteren']")).click();
//2.“create new account” butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();

//3.“firstName” giris kutusuna bir isim yazin
        Actions actions=new Actions(driver);
        WebElement firstname= driver.findElement(By.name("firstname"));
        Faker faker=new Faker();
        String email=faker.internet().emailAddress();
        actions.click(firstname).
                sendKeys(faker.name().name()).
                sendKeys(Keys.TAB).
                sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(email).
                sendKeys(Keys.TAB).
                sendKeys(faker.internet().password()).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("15").
                sendKeys(Keys.TAB).
                sendKeys("Feb").
                sendKeys(Keys.TAB).
                sendKeys("1980").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ARROW_RIGHT).
                sendKeys(Keys.ARROW_LEFT).
                perform();
//7.Bir sifre girin
//8.Tarih icin gun secin
//9.Tarih icin ay secin
//10.Tarih icin yil secin
//11.Cinsiyeti secin
//12.Isaretlediginiz cinsiyetin secili, diger cinsiyet kutusunun secili olmadigini test edin.
        WebElement radio1=driver.findElement(By.xpath(("(//input[@class='_8esa'])[1]")));
        Assert.assertTrue(radio1.isSelected());
        WebElement radio2=driver.findElement(By.xpath("(//input[@class='_8esa'])[2]"));
        Assert.assertFalse(radio2.isSelected());
        WebElement radio3=driver.findElement(By.xpath(("(//input[@class='_8esa'])[3]")));
        Assert.assertFalse(radio3.isSelected());
        //13.Sayfayi kapatin
//

    }

}
