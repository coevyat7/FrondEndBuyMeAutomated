package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;

import java.util.List;

public class HowToSendPage extends BasePage {
    private Logger log = LoggerHelper.getLogger(HowToSendPage.class);
    private By pageHeader = By.cssSelector(".step.active> div.label");
    private By laterBtn = By.cssSelector("div[class*='button-later']");
    private By dateTriggerBtn = By.cssSelector(".display-date");
    private By monthDate = By.cssSelector(".selected-month-name");
    private By chevronLeft = By.cssSelector("svg[id='chevron-left'][class*='rtl']");
    private By days = By.cssSelector("span[class*=day]");
    private By hourTriggerBtn = By.cssSelector(".selected-name");
    private By hourList = By.cssSelector(".selected-name+.dropdown span");
    private By emailTriggerBtn = By.cssSelector("svg[gtm='method-email']");
    private By email = By.id("email");
    private By sender = By.cssSelector("input[maxlength]");
    private By continueBtn = By.cssSelector(".mx-12>button");

    public HowToSendPage(WebDriver driver) {
        super(driver);
    }

    public String getHowToSendPageHeader() {
        waitForElementToBePresence(pageHeader);
        var title = getValueFromElement(pageHeader);
        log.info("Return HowToSendPage Header: " + title);
        return title;
    }

    public void clickOnLaterBtn() {
//        if (!getElement(laterBtn).isSelected()) {
//            clickOnElement(laterBtn);
//        }
        boolean status=isSelected(laterBtn);
        if(!status){
            clickOnElement(laterBtn);
            log.info("Clicking On Set gift Card To Later Option");
        }
    }

    public void setTimeToLater(String m, String d, String h) {
        waitForElementToBePresence(dateTriggerBtn);
        clickOnElement(dateTriggerBtn);
        log.info("Click On Date Picker");
        log.info("Set Time To: "+m+":"+d);
        while (true) {
            String mo = getValueFromElement(monthDate);
            if (mo.equalsIgnoreCase(m)) {
                break;
            } else {
                clickOnElement(chevronLeft);
            }

        }
        List<WebElement> days = getElements(this.days);
        selectValueFromBSDropdown(days, d);
        clickOnElement(hourTriggerBtn);
        List<WebElement> hours = getElements(hourList);
        selectValueFromBSDropdown(hours, h);
        log.info("Set Hour To: "+h);


    }

    public void setEmail(String value) {
        clickOnElement(emailTriggerBtn);
        sendKeysToElement(email, value);
    }

    public void setSenderName(String value) {
        sendKeysToElement(sender, value);
        log.info("Set Sender Name To: "+value);
    }

    public LoginPage clickOnContinueBtn() {
        clickOnElement(continueBtn);
        log.info("Clicking On Continue Button ");
        log.info("Moving To LoginPage");
        return getInstance(LoginPage.class);
    }




}
