package Pages;

import BasePackage.BasePage;
import BasePackage.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class homePage extends BasePage {

    //WebDriver driver;

    //*********Constructor*********
    /*public homePage (WebDriver driver) {
        super(driver);
    }*/

    //*********Page Variables*********
    String baseURL = "http://www.n11.com/";



    public void clickSignIn(){
        //WebElement signIn = JsonParser.getObjectLocator("$homePage.signInButton");
        WebElement signIn = driver.findElement(By.xpath("//a[contains(text(),'Sign in')]"));
        elementClick(signIn);
    }

}
