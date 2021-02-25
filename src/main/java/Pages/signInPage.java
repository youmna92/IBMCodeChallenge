package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

public class signInPage extends BasePage {


    public void clickCreateAccount(String email){
        WebElement emailTextField = driver.findElement(By.id("email_create"));
        elementSendKeys(emailTextField,email);

    }

    public void clickSignUp()
    {
        WebElement signUp = driver.findElement(By.id("SubmitCreate"));
        elementClick(signUp);
    }
}
