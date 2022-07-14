package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FireFoxBrowser {

    public FirefoxOptions getOptions(){
        FirefoxOptions option=new FirefoxOptions();
        option.addArguments("--incognito");
        option.addArguments("--disable-infobars");
        option.addArguments("start-maximized");
        option.addArguments("--disable-extensions");
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("marionette", true);
        option.merge(dc);
        return option;

    }
    public WebDriver getFireFoxDriver(){
        WebDriver driver= WebDriverManager.firefoxdriver().create();
        return driver;
    }


}
