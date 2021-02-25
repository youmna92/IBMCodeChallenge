package Pages;

import BasePackage.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import static BasePackage.BaseTest.driver;


public class signUpPage extends BasePage {


    /*public signUpPage(WebDriver driver) {
        super(driver);
    }*/

    public String getPageHeader(){
        //WebElement header = JsonParser.getObjectLocator("signInPage.header");
        WebElement header = driver.findElement(By.xpath("//h1[normalize-space()='Create an account']"));
        String headerText = header.getText();
        return headerText;
    }
    public void setTitleMrs(){

        //WebElement title = JsonParser.getObjectLocator("signUpPage.titleMrs");
        WebElement title = driver.findElement(By.id("id_gender2"));
        elementClick(title);
    }

    public void fillCustomerFirstName(String name){

        //WebElement firstName = JsonParser.getObjectLocator("signUpPage.customerFirstName");
        WebElement firstName = driver.findElement(By.id("customer_firstname"));
        elementSendKeys(firstName,"name");
    }

    public void fillCustomerLastName(String name){

        //WebElement lastName = JsonParser.getObjectLocator("signUpPage.customerLastName");
        WebElement lastName = driver.findElement(By.id("customer_lastname"));
        elementSendKeys(lastName,"name");
    }

    public void fillEmail(String emailAddress){

        //WebElement email = JsonParser.getObjectLocator("signUpPage.email");
        WebElement email = driver.findElement(By.id("email"));
        elementSendKeys(email,emailAddress);
    }

    public void fillPassword(String pass){

        //WebElement password = JsonParser.getObjectLocator("signUpPage.password");
        WebElement password = driver.findElement(By.id("passwd"));
        elementSendKeys(password,pass);
    }

    public void fillBirthDate(String d,String m,String y){

        //WebElement dayDropDown = JsonParser.getObjectLocator("signUpPage.dayPicker");
        //WebElement monthDropDown = JsonParser.getObjectLocator("signUpPage.monthPicker");
        //WebElement yearsDropDown = JsonParser.getObjectLocator("signUpPage.yearPicker");
        WebElement dayDropDown = driver.findElement(By.id("days"));
        WebElement monthDropDown = driver.findElement(By.id("months"));
        WebElement yearsDropDown = driver.findElement(By.id("years"));
        Select day = new Select(dayDropDown);
        Select month = new Select(monthDropDown);
        Select year = new Select(yearsDropDown);
        day.selectByValue(d);
        month.selectByValue(m);
        year.selectByValue(y);
    }

    public void fillAddressFirstName(String name){

        //WebElement firstName = JsonParser.getObjectLocator("signUpPage.firstName");
        WebElement firstName = driver.findElement(By.id("firstname"));
        elementSendKeys(firstName,name);
    }

    public void fillAdressLastName(String name){

        //WebElement lastName = JsonParser.getObjectLocator("signUpPage.lastName");
        WebElement lastName = driver.findElement(By.id("lastname"));
        elementSendKeys(lastName,name);
    }

    public void fillAddress(String add){

        //WebElement address = JsonParser.getObjectLocator("signUpPage.address");
        WebElement address = driver.findElement(By.id("address1"));
        elementSendKeys(address,add);
    }

    public void fillCity(String c){

        //WebElement city = JsonParser.getObjectLocator("signUpPage.city");
        WebElement city = driver.findElement(By.id("city"));
        elementSendKeys(city,c);
    }

    public void fillState(String value){

        //WebElement stateDropDown = JsonParser.getObjectLocator("signUpPage.state");
        WebElement stateDropDown = driver.findElement(By.id("id_state"));
        Select state = new Select(stateDropDown);
        state.selectByValue(value);
    }

    public void fillPostalCode(String code){

        //WebElement postCode = JsonParser.getObjectLocator("signUpPage.postCode");
        WebElement postCode = driver.findElement(By.id("postcode"));
        elementSendKeys(postCode,code);
    }

    public void fillCountry(String value){

        //WebElement countryDropDown = JsonParser.getObjectLocator("signUpPage.country");
        WebElement countryDropDown = driver.findElement(By.id("id_country"));
        Select country = new Select(countryDropDown);
        country.selectByValue(value);
    }

    public void fillMobilePhone(String phone){

        //WebElement mobile = JsonParser.getObjectLocator("signUpPage.mobile");
        WebElement mobile = driver.findElement(By.id("phone_mobile"));
        elementSendKeys(mobile,phone);
    }

    public void fillAddressAlias(String alias){

        //WebElement addressAlias = JsonParser.getObjectLocator("signUpPage.addressAlias");
        WebElement addressAlias = driver.findElement(By.id("alias"));
        elementSendKeys(addressAlias,alias);
    }

    public void clickSubmit(){

        //WebElement submit = JsonParser.getObjectLocator("signUpPage.submit");
        WebElement submit = driver.findElement(By.id("submitAccount"));
        elementClick(submit);
    }
}
