package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;

public class ProductPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(ProductPage.class);
    private By productPageHeader=By.cssSelector("h2.title");
    private By moneyBox= By.cssSelector("input[type='tel']");
    private By moneyBtn=By.cssSelector(".mx-12>button");
    public ProductPage(WebDriver driver) {
        super(driver);
    }
    public String getProductPageHeader(){
        waitForElementToBePresence(productPageHeader);
        var header=getValueFromElement(productPageHeader);
        log.info("Return Product Page Header: "+header);
        return  header;
    }
    public void setMoneyBox(String value){
        sendKeysToElement(moneyBox,value);
        log.info("Set Gift Card Amount To: "+value);

    }
    public WhoToSendPage clickOnConfirmMoneyButton(){
        clickOnElement(moneyBtn);
        log.info("Clicked On Confirm Money Button");
        log.info("Moving To WhoToSendPage ");
        return getInstance(WhoToSendPage.class);
    }


}
