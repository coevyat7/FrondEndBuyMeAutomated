package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;

public class LoginPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(LoginPage.class);
    private By myAccount= By.cssSelector(".menu-parent.signed");
    private By header=By.cssSelector(".lightbox-head>h1");
    private By mail= By.cssSelector("form[action='recaptchaAuth'] input[ type*=email]");
    private By password=By.cssSelector("form[action='recaptchaAuth'] input[ type*=password]");
    private By  loginBtn=By.cssSelector("form[action='recaptchaAuth'] button");
    private By registerBtn=By.cssSelector("div[class*='register']>span");
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public String getLoginPageHeader(){
        var text=getValueFromElement(header);
        log.info("Return LoginPage Header: "+text);
        return text;
    }
    public void setEmail(String value){
       sendKeysToElement(mail,value);
       log.info("Set Email To: "+value);
    }
    public void setPassword(String value){
        sendKeysToElement(password,value);
        log.info("Set PassWord To: "+value);
    }
    public PaymentPage clickOnLoginBtn(){
        clickOnElement(loginBtn);
        log.info("Clicking On Login Button");
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
    public RegistrationPage gotoRegisterPage(){
        clickOnElement(registerBtn);
        log.info("Clicking On GoToRegistration Button"+"\n"+ "Moving To RegistrationPage");
        log.info("Moving To RegistrationPage");
        return getInstance(RegistrationPage.class);
    }


}
