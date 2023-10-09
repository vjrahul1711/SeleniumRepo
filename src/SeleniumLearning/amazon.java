package SeleniumLearning;

import common.configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class amazon {

    public static void main (String[]args){

        WebDriver driver = new ChromeDriver();
        driver.get(configuration.TEST_URL2);
        driver.manage().window().maximize();
    //Login
        driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        driver.findElement(By.id("ap_email")).sendKeys(configuration.USER_NAME_AMAZON);
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys(configuration.PASSWORD_AMAZON);
        driver.findElement(By.id("signInSubmit")).click();

        //driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
        Actions hover = new Actions(driver);
        WebElement signInOptions = driver.findElement(By.id("nav-link-accountList-nav-line-1"));
        hover.moveToElement(signInOptions).perform();
        WebElement accountOption = driver.findElement(By.linkText("Sign Out"));
        hover.moveToElement(accountOption).perform();
        accountOption.click();




    }





}
