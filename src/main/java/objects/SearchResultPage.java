package objects;

import logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import page.BasePage;


import java.util.List;

public class SearchResultPage extends BasePage {
    private Logger log= LoggerHelper.getLogger(SearchResultPage.class);
    private By pageHeader = By.cssSelector(".title-xxl");
    private By productList = By.cssSelector("span.name.bm-subtitle-1");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public String getSearchResultPageHeader() {
        waitForElementToBePresence(pageHeader);
        var title= getValueFromElement(pageHeader);
        log.info("Return Search Result Page Header:"+title);
        return title;
    }

    public ProductPage setProductValue(String value) {
        waitForElementToBePresence(productList);
        List<WebElement> products = getElements(this.productList);
        selectValueFromBSDropdown(products, value);
        log.info("Set Product Gift Card to: "+value);
        log.info("Moving To ProductPage");
        return getInstance(ProductPage.class);

    }



}
