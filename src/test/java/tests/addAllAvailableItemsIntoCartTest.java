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
    public void addAllAvailableItemsIntoCart() throws FilloException {

        womenItemsPageObject.addSheets();
        womenItemsPageObject.clickOnWomenPage();
        Reporter.log("Women Items Page is now opened");
        womenItemsPageObject.addToCart();
        Reporter.log("All available Items are added to cart successfully");



    }
}
