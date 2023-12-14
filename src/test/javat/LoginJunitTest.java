package javat;

import common.configuration;
import common.Basetestvijay;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

class LoginJunitTest extends Basetestvijay {
    @Test
    public void test01() throws Exception {
        // WebDriver driver = new ChromeDriver();
        //driver.get(configuration.TEST_URL);
        //driver.manage().window().maximize();
        //Thread.sleep(6000);

        getDriver().findElement(By.id("wzrk-cancel")).click(); // Clicking on the popup button
        getDriver().findElement(By.linkText("LOGIN")).click(); //Clicking on the login
        getDriver().findElement(By.linkText("Login with password instead")).click();
        getDriver().findElement(By.id("lusername")).sendKeys(configuration.USER_NAME_LIVE);
        getDriver().findElement(By.id("lpassword")).sendKeys(configuration.PASSWORD_LIVE);
        getDriver().findElement(By.xpath("/html/body/section[1]/div/form[1]/div[3]/div/button")).click();
        Thread.sleep(4000);
        getDriver().findElement(By.xpath("//*[@id=\"Wrapper\"]/header/div/div/div/div[1]/div/div[4]/div/div/a[2]")).click();
        getDriver().findElement(By.linkText("OK")).sendKeys(Keys.ENTER);
        //String mainWindowHandle =getDriver().getWindowHandle();
        //System.out.println(mainWindowHandle);
        //Set<String> allWindowHandles = getDriver().getWindowHandles();
        //Iterator<String> it = allWindowHandles.iterator();
        //while (it.hasNext()) {
        //    String childWindow = it.next();
        //    System.out.println(childWindow);
        //    if (!mainWindowHandle.equalsIgnoreCase(childWindow))
        //    {
        //        getDriver().switchTo().window(childWindow);
        //        getDriver().findElement(By.linkText("OK"));
        //    }
        //}


    }
}
