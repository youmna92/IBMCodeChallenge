package tests;

import BasePackage.BaseTest;
import Pages.homePage;
import Pages.signInPage;
import Pages.signUpPage;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class signUpTest extends BaseTest {


    public static homePage homePageObject;
    public static signInPage signInPageObject;
    public static signUpPage signUpPageObject;

    @BeforeClass
    public void initialization(){
        homePageObject = new homePage();
        signInPageObject = new signInPage();
        signUpPageObject = new signUpPage();
    }

    @Test(priority = 1, description = "Click on Sign In button from Home Page to navigate to Sign up page")
    public void navigateToSignUpPage() {

        homePageObject.clickSignIn();
        Reporter.log("Navigated to Sign in page successfully");
        Random rand = new Random();
        int rand_int1 = rand.nextInt(1000);
        signInPageObject.clickCreateAccount("email"+rand_int1+"@gmail.com");
        signInPageObject.clickSignUp();
        String signUpPageTitle = signUpPageObject.getPageHeader();
        String expectedTitle = "CREATE AN ACCOUNT";
        Assert.assertEquals(signUpPageTitle, expectedTitle);
        Reporter.log("User on Sign Up Page");
    }

    @Test (priority = 2,description = "Fill Sign up Form")
    public void fillSignUpForm(){

        signUpPageObject.setTitleMrs();
        signUpPageObject.fillCustomerFirstName("Youmna");
        signUpPageObject.fillCustomerLastName("Elsayed");
        //signUpPageObject.fillEmail("newemail12@gmail.com");
        signUpPageObject.fillPassword("pass12345");
        signUpPageObject.fillBirthDate("1","1","1992");
        //signUpPageObject.fillAddressFirstName("Youmna");
        //signUpPageObject.fillAdressLastName("Elsayed");
        signUpPageObject.fillAddress("123 street");
        signUpPageObject.fillCity("Nevada");
        signUpPageObject.fillState("1");
        signUpPageObject.fillPostalCode("00202");
        signUpPageObject.fillCountry("21");
        signUpPageObject.fillMobilePhone("0123456789");
        //signUpPageObject.fillAddressAlias("my address");
        signUpPageObject.clickSubmit();
        String expectedURL = "http://automationpractice.com/index.php?controller=my-account";
        String expectedTitle ="My account - My Store" ;
        Assert.assertEquals(driver.getCurrentUrl(),expectedURL);
        Assert.assertEquals(driver.getTitle(),expectedTitle);
        Reporter.log("User Registered successfully");

    }
}
