package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.BasePage;

import java.time.Duration;

public class PaymentPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(PaymentPage.class);
    private By pageHeader=By.cssSelector(".step.active> div.label");
    private By price=By.cssSelector(".total-price>span");
    public PaymentPage(WebDriver driver) {
        super(driver);
    }
    public String getPaymentPageHeader(){
      //  waitForElementToBePresence(pageHeader);
        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(price));
         var header=getValueFromElement(pageHeader);
         log.info("Return PaymentPage Header: "+header);
         return header;
    }
 
    public int getTotalPrice(){
        String value=getValueFromElement(price);
        int coin=Integer.valueOf(value.replace("₪",""));
        log.info("Verify Total Money Amount : "+coin);
        return coin;
    }


    
}
