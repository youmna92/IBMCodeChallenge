package Pages;

import BasePackage.BasePage;
import Utilities.ExcelUtils;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;


public class checkOutPage extends BasePage {


    public void clickOnShoppingCart(){

        WebElement cart = driver.findElement(By.xpath("//b[normalize-space()='Cart']"));
        scrollIntoView(cart);
        elementHoverOver(cart);
        ClickByAction(cart);
    }

    public int storeCheckOutItemsNames() throws FilloException {
        ExcelUtils.openExcelSheet();
        int i=0;
        int k=1;
        List<WebElement> items = driver.findElements(By.xpath("//tbody//tr"));
        int listLength = items.size();
        System.out.println("Found Table");
        for (WebElement item : items)
        {
            WebElement nameOfItem = item.findElement(By.xpath("(//td[@class='cart_description']//p//a)["+k+"]"));
            String Name = nameOfItem.getText();
            WebElement priceOfItem = item.findElement(By.xpath("(//td[@class='cart_total']//span)["+k+"]"));
            String Price = priceOfItem.getText();
            String priceNo$sign = Price.substring(1);
            System.out.println("Checkout Item Name is: "+Name);
            System.out.println("Checkout Item Price is: "+priceNo$sign);
            ExcelUtils.insertQuery("insert into checkOutItems (ID,Names,Prices) values ('"+k+"','"+Name+"','"+priceNo$sign+"')");

            i++;
            k++;
        }

        WebElement totalProduct = driver.findElement(By.xpath("//td[@id='total_product']"));
        String totalPrice = totalProduct.getText();
        String totalPriceNo$sign = totalPrice.substring(1);
        ExcelUtils.insertQuery("insert into checkOutItems (ID,Names,totalPrice) values ('101','totalPrice','"+ totalPriceNo$sign+"')");

        return listLength;
    }

    public static float findSumArray(float[] array) {
        float sum = 0;
        for (float value : array) {
            sum += value;
        }
        return sum;
    }

    public static void deleteSheets() throws FilloException {

        ExcelUtils.openExcelSheet();
        ExcelUtils.deleteTable("womenPageItems");
        ExcelUtils.deleteTable("checkOutItems");
    }

    public static void addSheets() throws FilloException {

        ExcelUtils.openExcelSheet();
        String[] table2names = {"ID","Names","Prices","totalPrice"};
        ExcelUtils.createTable("checkOutItems",table2names);
    }

    public static float roundUpFloat(float number){

        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        float f = Float.parseFloat(df.format(number));

        return f;
    }

    public static float[] putHomePagePricesInArray(int arrayLength) throws FilloException {

        int k=1;
        float[] itemsPriceInHomePage = new float[arrayLength];
        for (int i=0;i<arrayLength;i++){
            String itemPrice = ExcelUtils.SelectCell("Select * from womenPageItems where ID='"+k+"'","Prices");
            float f = Float.parseFloat(itemPrice);
            itemsPriceInHomePage[i] = f;
            k++;
        }

        return itemsPriceInHomePage;
    }


    public static float[] putcheckOutPricesInArray(int arrayLength) throws FilloException {

        int k=1;
        float[] itemsPriceInCheckOut = new float[arrayLength];
        for (int i=0;i<arrayLength;i++){
            String itemPrice = ExcelUtils.SelectCell("Select * from checkOutItems where ID='"+k+"'","Prices");
            float f = Float.parseFloat(itemPrice);
            itemsPriceInCheckOut[i] = f;
            k++;
        }

        return itemsPriceInCheckOut;
    }


}
