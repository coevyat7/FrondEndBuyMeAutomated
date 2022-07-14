package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.List;

public class IndexPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(BasePage.class);
    private By amountTriggerBtn=By.cssSelector("form.form>label:first-of-type");
    private By amountList=By.cssSelector("form.form>label:first-of-type li>span");
    private By regionTriggerBtn=By.cssSelector("form.form>label:nth-of-type(2)");
    private By regionList=By.cssSelector("form.form>label:nth-of-type(2) li>span");
    private By categoryTriggerBtn=By.cssSelector("form.form>label:nth-of-type(3)");
    private By categoryList=By.cssSelector("form.form>label:nth-of-type(3) li span");
    private By inputBox=By.cssSelector("form.form label>input");
    private By autoSuggestedList=By.cssSelector("form.form >label:last-of-type ul>li>span");
    private By searchBtn=By.cssSelector("a[rel]");
    public IndexPage(WebDriver driver) {
        super(driver);
    }
    public String getIndexPageTitle(){
        var title=getPageTitle();
        log.info("Return Index Page Title: "+title);
        return title;
    }
    private void clickAmountTriggerBtn(){
        waitForElementToBeClickAble(amountTriggerBtn);
        clickOnElement(amountTriggerBtn);
        log.info("Clicking On Amount Dropdown");

    }
    private void clickOnRegionTriggerBtn(){
        waitForElementToBeClickAble(regionTriggerBtn);
        clickOnElement(regionTriggerBtn);
        log.info("Clicking On Region Dropdown");

    }
    private void clickOnCategoryBtn(){
        waitForElementToBeClickAble(categoryTriggerBtn);
        clickOnElement(categoryTriggerBtn);
        log.info("Clicking On Category Dropdown");

    }
    public void setAmount(String value){
        clickAmountTriggerBtn();
        List<WebElement> amount=getElements(amountList);
        selectValueFromBSDropdown(amount,value);
        log.info("Set Amount to: "+value+" From The Dropdown List");
    }
    public void setRegion(String value){
        clickOnRegionTriggerBtn();
        List<WebElement>region=getElements(regionList);
        selectValueFromBSDropdown(region,value);
        log.info("Set Region To: "+value+" From The Dropdown List");
    }
    public void setCategory(String value){
        clickOnCategoryBtn();
        List<WebElement>category=getElements(categoryList);
        selectValueFromBSDropdown(category,value);
        log.info("Set Category To: "+value+" From The Dropdown List");
    }
    public void setAutoCompleteInputBox(String s,String t){
        sendKeysToElement(inputBox,s);
        log.info("Sending Text To AutoComplete Input Box: "+s);
        waitForElementToBePresence(autoSuggestedList);
        List<WebElement>myList=getElements(autoSuggestedList);
        selectValueFromBSDropdown(myList,t);
        log.info("Auto Complete DropDown With Value1: "+s +" And Value2: "+t);


    }
    public SearchResultPage clickOnSearchBtn(){
        clickOnElement(searchBtn);
        log.info("Click On Search GiftBtn ");
        log.info("Moving To SearchResultPage ");
        return getInstance(SearchResultPage.class);
    }



}
