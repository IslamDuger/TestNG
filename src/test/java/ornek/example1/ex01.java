package ornek.example1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ex01 {
     /*
      ● https://www.amazon.com/ adresine gidin.
      - Test 1
          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
      -Test 2
          1. Kategori menusunden Books secenegini  secin
          2. Arama kutusuna Java yazin ve aratin
          3. Bulunan sonuc sayisini yazdirin
          4. Sonucun Java kelimesini icerdigini test edin
   */
    WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }
    @Test
    // https://www.amazon.com/ adresine gidin.
    //      - Test 1
    //          Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
    //
    public void kategoriSayisi(){
        WebElement kategori= driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select kagegoriSay=new Select(kategori);
        List<WebElement> tumKategori=kagegoriSay.getOptions();
        int actualSayi=tumKategori.size();
        int expectedSati=45;
        Assert.assertEquals(actualSayi,expectedSati,"beklenen sayi yanlis");


    }
    @Test
public void javaYazdir(){
    /*
     -Test 2
          1. Kategori menusunden Books secenegini  secin
          2. Arama kutusuna Java yazin ve aratin
          3. Bulunan sonuc sayisini yazdirin
          4. Sonucun Java kelimesini icerdigini test edin

     */
        WebElement kategori= driver.findElement(By.xpath("//*[@class='nav-search-dropdown searchSelect nav-progressive-attrubute nav-progressive-search-dropdown']"));
        Select book=new Select(kategori);
        book.selectByIndex(5);
        WebElement aramaKutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        WebElement sonucSayisi= driver.findElement(By.xpath("(//*[@dir='auto'])[2]"));
        System.out.println(sonucSayisi.getText());
        Assert.assertTrue(sonucSayisi.getText().contains("Java"));
    }
    @AfterMethod
    public void kapama(){
        driver.close();
    }
}




