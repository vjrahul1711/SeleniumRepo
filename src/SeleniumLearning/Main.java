package SeleniumLearning;

import org.openqa.selenium.chrome.ChromeDriver;


class Main{

    public static void main(String[] args) throws InterruptedException {

        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.rummypassion.in");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.quit();
    }
}