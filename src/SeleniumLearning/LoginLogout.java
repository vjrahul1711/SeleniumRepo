package SeleniumLearning;

import common.configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;
import java.util.Iterator;
import java.util.Set;



class LoginLogout{

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(configuration.TEST_URL_LIVE);
        driver.manage().window().maximize();
        Thread.sleep(6000);

        driver.findElement(By.id("wzrk-cancel")).click(); // Clicking on the popup button
        driver.findElement(By.linkText("LOGIN")).click(); //Clicking on the login
        driver.findElement(By.linkText("Login with password instead")).click();
        driver.findElement(By.cssSelector("input[id=lusername]")).sendKeys(configuration.USER_NAME_LIVE);
        driver.findElement(By.cssSelector("input[id=lpassword]")).sendKeys(configuration.PASSWORD_LIVE);
        driver.findElement(By.cssSelector("button[type=submit]")).click();
        Thread.sleep(4000);

        //Below commented code is for navigating to my profile and change avtar
        /*driver.findElement(By.xpath("/html/body/div[3]/header/div/div/div/div[1]/div/div[3]/div/ul/li[6]/a")).click();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/ul/li[4]/a")).click();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[1]/ul/li[4]/ul/li[3]/a")).click();
        //driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/div[2]/div/form/div[8]/span[1]/img")).click();
        Thread.sleep(3000);*/

        driver.findElement(By.xpath("//*[@id=\"Wrapper\"]/header/div/div/div/div[1]/div/div[4]/div/div/a[2]")).click();
        driver.findElement(By.linkText("OK")).sendKeys(Keys.ENTER);



        // code for switching between windows
        //driver.findElement(By.xpath("//*[@id=\"dynamic_common_message\"]/div/div/div[3]/ul/li/div/span[2]/a/button"));
        String mainWindowHandle =driver.getWindowHandle();
        System.out.println(mainWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            System.out.println(childWindow);
            if (!mainWindowHandle.equalsIgnoreCase(childWindow))
            {
                driver.switchTo().window(childWindow);
                driver.findElement(By.linkText("OK"));
            }
        }

        driver.quit();

    }
}