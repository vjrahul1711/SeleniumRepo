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
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html/body/div[3]/header/div/div/div/div[1]/div/div[3]/div/ul/li[6]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/ul/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/ul/li[4]/ul/li[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/form/div[8]/span[1]/img")).click();
        //driver.quit();

    }
}