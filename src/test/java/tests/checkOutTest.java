package tests;

import BasePackage.BaseTest;
import Pages.checkOutPage;
import Utilities.ExcelUtils;
import com.codoid.products.exception.FilloException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkOutTest extends BaseTest {

    public static checkOutPage checkOutPageObject;

    @BeforeClass
    public void initialization(){
        checkOutPageObject = new checkOutPage();
    }
    @Test(description="counting items returning names and prices for each item and total price")
    public void validateCheckOutItems() throws FilloException {

        checkOutPageObject.addSheets();
        checkOutPageObject.clickOnShoppingCart();
        Reporter.log("Navigated to shopping cart page successfully");

        int numberOfItems = checkOutPageObject.storeCheckOutItemsNames();
        ExcelUtils.openExcelSheet();
        int k=1;
        for (int i=0; i<numberOfItems; i++) {

            String itemInHomePageName = ExcelUtils.SelectCell("Select * from womenPageItems where ID='"+k+"'","Names");
            String itemInCheckOutName = ExcelUtils.SelectCell("Select * from checkOutItems where ID='"+k+"'","Names");
            Assert.assertEquals(itemInCheckOutName,itemInHomePageName);
            Reporter.log("The item no."+k+" matches the selection in home page");
            k++;
        }


        float[] itemsPriceInHomePage = checkOutPageObject.putHomePagePricesInArray(numberOfItems);
        float[] itemsPriceInCheckOut = checkOutPageObject.putcheckOutPricesInArray(numberOfItems);


        float Sum = checkOutPageObject.findSumArray(itemsPriceInHomePage);
        float finalSum = checkOutPageObject.roundUpFloat(Sum);
        String totalPrice = ExcelUtils.SelectCell("Select * from checkOutItems where ID=101","totalPrice");
        float f = Float.parseFloat(totalPrice);

        //Assertions on items prices separately and total
        Assert.assertEquals(itemsPriceInHomePage,itemsPriceInCheckOut);
        Reporter.log("Each item price in cart matches each item selected in home Page");
        Assert.assertEquals(finalSum,f);
        Reporter.log("total price in cart matches total price of items added from home Page");

        checkOutPageObject.deleteSheets();
    }
}
