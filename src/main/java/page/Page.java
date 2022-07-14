package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }
    protected  abstract  String getPageTitle();



    protected abstract WebElement getElement(By locator);

    protected abstract List<WebElement> getElements(By locator);

    protected abstract void sendKeysToElement(By locator, String value);

    protected abstract void clickOnElement(By locator);

    protected abstract void selectValueFromBSDropdown(List<WebElement> list, String value);

    protected abstract String getValueFromElement(By locator);

    protected abstract void clearSuggestedTextFromElement(By locator);

    protected abstract void waitForElementToBePresence(By locator);

    protected abstract void waitForElementToBeClickAble(By locator);

    protected abstract boolean isSelected(By locator);

    public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {
        try {
            return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}





