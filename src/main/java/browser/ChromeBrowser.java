package browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeBrowser {

    public ChromeOptions getOptions(){
        ChromeOptions option=new ChromeOptions();
        option.addArguments("--incognito");
        option.addArguments("--disable-infobars");
        option.addArguments("start-maximized");
        option.addArguments("--disable-extensions");
        return option;


    }
    public WebDriver getChromeDriver(){
        WebDriver driver=WebDriverManager.chromedriver().capabilities(getOptions()).create();
        return driver;
    }


}
