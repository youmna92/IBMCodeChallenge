package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class signInPage extends BasePage {


    /*public signInPage(WebDriver driver) {
        super(driver);
    }*/

    public void clickCreateAccount(String email){
        //WebElement emailTextField = JsonParser.getObjectLocator("signInPage.emailField");
        WebElement emailTextField = driver.findElement(By.id("email_create"));
        elementSendKeys(emailTextField,email);

    }

    public void clickSignUp()
    {
        //WebElement signUp = JsonParser.getObjectLocator("signInPage.createAccount");
        WebElement signUp = driver.findElement(By.id("SubmitCreate"));
        elementClick(signUp);
    }
}
