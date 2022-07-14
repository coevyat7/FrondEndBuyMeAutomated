package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.List;

public class WhoToSendPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(WhoToSendPage.class);
    private By pageHeader=By.cssSelector(".step.active> div.label");
    private By someoneElse = By.cssSelector("div[class*='forSomeone']");
    private By receiverName = By.cssSelector("input[maxlength]");
    private By blessingTriggerBtn = By.cssSelector(".selected-name");
    private By blessingPoolList = By.cssSelector(".selected-name+.dropdown span");
    private By ownBlessing = By.cssSelector("textarea[rows]");
    private By photo = By.cssSelector("input[type='file']");
    private By continueBtn = By.cssSelector(".mx-12>button");

    public WhoToSendPage(WebDriver driver) {
        super(driver);
    }
    public String getWhoToSendPageHeader(){
        waitForElementToBePresence(pageHeader);
         var title=getValueFromElement(pageHeader);
         log.info("Return WhoToSendPageHeader: "+title);
         return title;
    }

    public boolean selectSomeOneElse() {
        waitForElementToBePresence(someoneElse);
        boolean status=isSelected(someoneElse);
        if(status){
            log.info("Already Selected");
        }
        else{
            log.info("Clicking On SomeoneElse Option");
            clickOnElement(someoneElse);
        }
        return status;
    }


    public void setReceiverName(String value)  {
        waitForElementToBePresence(receiverName);
        sendKeysToElement(receiverName, value);
        log.info("Set Receiver Name To: "+value);
    }

    private void clickOnBlessingPool() {
        clickOnElement(blessingTriggerBtn);
        log.info("Clicking On Blessing DropDown");
    }

    public void setPickBlessing(String value) {
        clickOnBlessingPool();
        waitForElementToBePresence(blessingPoolList);
        List<WebElement> bless = getElements(blessingPoolList);
        selectValueFromBSDropdown(bless, value);
        log.info("Set Blessing To: "+value);
    }

    public void setOwnBlessing(String value) {
        clearSuggestedTextFromElement(ownBlessing);
        sendKeysToElement(ownBlessing, value);
        log.info("Set Own Blessing To : "+value);
    }

    public void setPhoto(String value) {
        log.info("Set Photo Path: "+value );
        sendKeysToElement(photo, value);
    }

    public HowToSendPage clickOnContinueBtn() {
        log.info("Clicking On Continue Button +\n"+" Moving To HowToSendPage");
        clickOnElement(continueBtn);
        return getInstance(HowToSendPage.class);
    }





}