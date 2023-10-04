package SeleniumLearning;

import common.configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;

public class amazon {

    public static void main (String[]args){

        WebDriver driver = new ChromeDriver();
        driver.get(configuration.TEST_URL2);
        driver.manage().window().maximize();
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();


    }





}
