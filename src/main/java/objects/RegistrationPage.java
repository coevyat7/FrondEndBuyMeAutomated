package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;

public class RegistrationPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(RegistrationPage.class);
    private By name= By.cssSelector("input[type='text']");
    private By email=By.cssSelector(".option.oldschool input[type='email']");
    private By password=By.cssSelector("input[name='valPass']");
    private By confirmPw=By.cssSelector("input[data-parsley-equalto]");
    private By termsRadioBtn=By.cssSelector("div[class*='login-options']:not([class*='bottom-lr'])>div");
    private By addsAgreement=By.cssSelector("div.grid.bottom-lr>div");
    private By registerBtn=By.cssSelector(".option.oldschool button");
    private By myAccount= By.cssSelector(".menu-parent.signed");
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }
    public void setName(String value){
        log.info("Set Name To "+value);
        sendKeysToElement(name,value);
    }
    public void setEmail(String value){
        log.info("Set Email To: "+value);
        sendKeysToElement(email,value);
    }
    public void setPassword(String value){
        log.info("Set PassWord To: "+value);
        sendKeysToElement(password,value);
    }
    public void setConfirmPassword(String value){
        log.info("Set Confirm PassWord To: "+value);
        sendKeysToElement(confirmPw,value);
    }
    public void clickOnTerms(){
        log.info("Click On Agree To Terms");
        clickOnElement(termsRadioBtn);
    }
    public void clickOnAddsAgreement(){
        log.info("Click On Agree To Adds ");
        clickOnElement(addsAgreement);
    }
    public  PaymentPage clickOnRegisterBtn(){
        log.info("Clicking On Complete Registration Button");
        clickOnElement(registerBtn);
        return getInstance(PaymentPage.class);
    }
    public boolean accountDisplay(){
        waitForElementToBePresence(myAccount);
        WebElement element=getElement(myAccount);
        log.info("Waiting To Account Setting Display On Site...");
       boolean status= element.isDisplayed();
        log.info("Account Data Display Registration Complete");
       return status;

    }



}
