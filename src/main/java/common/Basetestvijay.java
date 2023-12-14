package common;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Basetestvijay {

    private WebDriver driver = null;
    //WebDriver driver = new ChromeDriver();
    @BeforeEach
     public void browserLaunch() throws Exception {
        //WebDriver driver = new ChromeDriver();
        setDriver(new ChromeDriver());
        getDriver().get(configuration.TEST_URL_LIVE);
        getDriver().manage().window().maximize();
        Thread.sleep(2000);


    }

    @AfterEach
    void tearDown() {
        getDriver().quit();
    }
    //Getter
    public WebDriver getDriver() {
        return driver;
    }

    // Setter
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }







}
