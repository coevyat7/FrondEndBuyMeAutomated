package test.base;

import browser.BrowserType;
import browser.ChromeBrowser;
import browser.FireFoxBrowser;
import config.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import page.BasePage;
import page.Page;

import java.time.Duration;

public class BaseTest {
   public static WebDriver driver;
    PropertyReader propertyReader;
    String URL="https://buyme.co.il/";
    public Page page;


    public void init() {
        propertyReader = new PropertyReader();
        setDriver(BrowserType.valueOf(String.valueOf(propertyReader.getBrowserType())));
        setImplicitTime(propertyReader.getImplicitTime());
        setPageLoadTime(propertyReader.getPageLoadTime());
        deleteAllCookies();
        page=new BasePage(driver);
        driver.get(URL);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver setDriver(BrowserType type) {
        try {
            switch (type) {
                case CHROME -> {
                    ChromeBrowser chrome = new ChromeBrowser().getClass().getDeclaredConstructor().newInstance();
                    driver = chrome.getChromeDriver();

                }
                case FIREFOX -> {
                    FireFoxBrowser firefox = new FireFoxBrowser().getClass().getDeclaredConstructor().newInstance();
                    driver = firefox.getFireFoxDriver();

                }
                default -> throw new IllegalStateException("Driver is Not Found..." + type.name());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
    public void setImplicitTime(int time){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }
    public void setPageLoadTime(int time){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
    }
    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
