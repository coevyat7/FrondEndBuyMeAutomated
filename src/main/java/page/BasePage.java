package page;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage extends Page{
    private Logger log= LoggerHelper.getLogger(BasePage.class);
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTitle() {
        return driver.getTitle();
    }

    @Override
    protected WebElement getElement(By locator) {
        WebElement element=null;
        try{
            element=driver.findElement(locator);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            log.info("Cannot Locate Element ");
        }return element;
    }

    @Override
    protected List<WebElement> getElements(By locator) {
        List<WebElement>list=null;
        waitForElementToBePresence(locator);
        try{
            list=driver.findElements(locator);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            log.info("Cannot Locate Element ");
        }return  list;
    }

    @Override
    protected void sendKeysToElement(By locator, String value) {

          WebElement element=getElement(locator);
          element.sendKeys(value);
    }

    @Override
    protected void clickOnElement(By locator) {

       WebElement element=getElement(locator);
       element.click();
    }

    @Override
    protected void selectValueFromBSDropdown(List<WebElement> list, String value) {
         for(WebElement element:list){
             String target=element.getText();
             if(target.contains(value)){
                 element.click();
                 break;

             }

         }
    }

    @Override
    protected String getValueFromElement(By locator) {
        WebElement element=getElement(locator);
        var value=element.getText();
        return value;
    }

    @Override
    protected void clearSuggestedTextFromElement(By locator) {
           WebElement element=getElement(locator);
           element.clear();

    }

    @Override
    protected void waitForElementToBePresence(By locator) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        log.info("Element Is Presence.");
    }

    @Override
    protected void waitForElementToBeClickAble(By locator) {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(StaleElementReferenceException.class);
        wait.ignoring(NoSuchFrameException.class);
        wait.pollingEvery(Duration.ofMillis(500));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    @Override
    protected boolean isSelected(By locator) {
        WebElement element=getElement(locator);
        boolean status;
        try{
            status=element.isSelected();

        }catch (NoSuchElementException e){
            e.printStackTrace();
            status=false;
        }return  status;
    }
}