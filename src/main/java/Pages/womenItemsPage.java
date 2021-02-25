package Pages;

import BasePackage.BasePage;
import Utilities.ExcelUtils;
import com.codoid.products.exception.FilloException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static BasePackage.BaseTest.driver;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class womenItemsPage extends BasePage {


    public void clickOnWomenPage(){
        WebElement women = driver.findElement(By.xpath("//a[@title='Women']"));
        elementClick(women);
    }



    public void addToCart() throws FilloException {

        ExcelUtils.openExcelSheet();

        List<WebElement> allItems = driver.findElements(By.xpath("//*[@class='product-container']"));
        int i=0;
        int k=1;
        int length = allItems.size();
        System.out.println("Array size is: " + length);
        for (WebElement item : allItems){
            WebElement available = item.findElement(By.xpath("(//*[@class='available-now'])["+k+"]"));
            System.out.println("available element: "+available);
            String inStock = available.getText();
            System.out.println("availability: "+inStock);
            if(inStock.equals("In stock"))
            {
                scrollIntoView(item);
                elementHoverOver(item);
                WebElement addToCartBtn = driver.findElement(By.xpath("(//span[contains(text(),'Add to cart')])["+k+"]"));
                elementClick(addToCartBtn);
                WebElement nameOfItem = item.findElement(By.xpath("(//div[@class='right-block']//a[@class='product-name'])["+k+"]"));
                String Name = nameOfItem.getText();
                WebElement priceOfItem = item.findElement(By.xpath("(//div[@class='left-block']//*[@class='content_price']//*[@class='price product-price'])["+k+"]"));
                String Price = priceOfItem.getText();
                String priceNo$sign = Price.substring(1);
                System.out.println("Item Name is: "+Name);
                System.out.println("Item Price is: "+priceNo$sign);
                ExcelUtils.insertQuery("insert into womenPageItems (ID,Names,Prices) values ('"+k+"','"+Name+"','"+priceNo$sign+"')");
                WebElement continueShopping = driver.findElement(By.xpath("//span[@title='Continue shopping']"));
                elementClick(continueShopping);
            }

            i++;
            k++;
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        }

    }

    public static void addSheets() throws FilloException {

        ExcelUtils.openExcelSheet();
        String[] table1names = {"ID","Names","Prices"};
        ExcelUtils.createTable("womenPageItems",table1names);
    }
}
