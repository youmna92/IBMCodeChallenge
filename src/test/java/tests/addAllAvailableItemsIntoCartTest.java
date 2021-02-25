package tests;

import BasePackage.BaseTest;
import Pages.womenItemsPage;
import com.codoid.products.exception.FilloException;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class addAllAvailableItemsIntoCartTest extends BaseTest {


    public static womenItemsPage womenItemsPageObject;

    @BeforeClass
    public void initialization(){
        womenItemsPageObject = new womenItemsPage();
    }

    @Test(description="adding all items available into cart")
    public void addAllAvailableItemsIntoCart() throws FilloException, InterruptedException {

        womenItemsPageObject.addSheets();
        womenItemsPageObject.clickOnWomenPage();
        Reporter.log("Women Items Page is now opened");
        //womenItemsPageObject.checkInStockbutton();
        //String[] ProductNamesAndPrices = womenItemsPageObject.addAllAvailableItemsToCart();
        //float totalPrice = womenItemsPageObject.calculateTotalPrice(ProductNamesAndPrices);
        //String[] listOfItemsNamesOnly = womenItemsPageObject.returnItemsNamesOnly(ProductNamesAndPrices);
        womenItemsPageObject.addToCart();
        Reporter.log("All available Items are addedd to cart successfully");



    }
}
