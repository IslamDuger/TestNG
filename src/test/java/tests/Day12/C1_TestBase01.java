package tests.Day12;

import Utilies.TestBase;
import org.testng.annotations.Test;

public class C1_TestBase01 extends TestBase {
    //Public :herkes Ulasibilir
    //Protected:ayni package veya  child class
    //default(bir sey yazmayinca da default kabul edilir);package private
    //private:sadece class icinde kullanilir.
    @Test
    public void test01(){
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
}
