package BasePackage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.util.TimeUtils;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;

    @BeforeTest
    public void setup () {
        //Create a Chrome driver. All test classes use this.
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.getInstance(ChromeDriver.class).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
        WebDriverWait explicitWait = new WebDriverWait(driver,50);
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(150,TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php");
    }

    @AfterTest
    public void teardown () {
        driver.quit();
    }
}