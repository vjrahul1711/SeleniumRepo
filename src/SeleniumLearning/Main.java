package SeleniumLearning;

import common.configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





class Main{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(configuration.TEST_URL);
        driver.manage().window().maximize();
        Thread.sleep(4000);

        driver.findElement(By.id("wzrk-cancel")).click(); // Clicking on the popup button
        driver.findElement(By.linkText("LOGIN")).click();
        driver.findElement(By.linkText("Login with password instead")).click();
        driver.findElement(By.id("lusername")).sendKeys(configuration.USER_NAME);
        driver.findElement(By.id("lpassword")).sendKeys(configuration.PASSWORD);
        driver.findElement(By.xpath("/html/body/section[1]/div/form[1]/div[3]/div/button")).click();
        //driver.quit();
    }
}