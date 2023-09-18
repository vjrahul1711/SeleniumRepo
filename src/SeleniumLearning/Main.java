package SeleniumLearning;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;




class Main{

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.rummypassion.com");
        driver.manage().window().maximize();
        Thread.sleep(4000);

        driver.findElement(By.id("wzrk-cancel")).click(); // Clicking on the popup button
        driver.findElement(By.linkText("LOGIN")).click();
        driver.findElement(By.linkText("Login with password instead")).click();

        //driver.quit();
    }
}