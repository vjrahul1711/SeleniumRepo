package SeleniumLearning;




import common.configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Iterator;
import java.util.Set;


public class gameWindow {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get(configuration.TEST_URL);
        driver.manage().window().maximize();

        driver.findElement(By.id("wzrk-cancel")).click(); // Clicking on the popup button
        driver.findElement(By.linkText("LOGIN")).click();
        driver.findElement(By.linkText("Login with password instead")).click();
        driver.findElement(By.id("lusername")).sendKeys(configuration.USER_NAME);
        driver.findElement(By.id("lpassword")).sendKeys(configuration.PASSWORD);
        driver.findElement(By.xpath("/html/body/section[1]/div/form[1]/div[3]/div/button")).click();
        Thread.sleep(4000);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println(size + "iframe present");
        List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
        System.out.println("Total number of iframes are " + iframeElements.size());
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//*[@id=\"10430\"]")).click();
        Thread.sleep(4000);

        // code for switching between windows
        //driver.findElement(By.xpath("//*[@id=\"dynamic_common_message\"]/div/div/div[3]/ul/li/div/span[2]/a/button"));
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("parentwindow" +mainWindowHandle);
        Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> it = allWindowHandles.iterator();
        while(it.hasNext()) {
            String childWindow = it.next();
            System.out.println("childwindow is " + childWindow);
            if (!mainWindowHandle.equalsIgnoreCase(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println(childWindow);
                Thread.sleep(4000);
                driver.close();

            }


        }


    }
}
