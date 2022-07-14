package test;

import constant.IndexPageConstant;
import constant.SearchResultPageConstant;
import logger.LoggerHelper;
import objects.IndexPage;
import objects.SearchResultPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class SearchResultPageTest extends BaseTest {

    SearchResultPage searchResultPage;
    private Logger log= LoggerHelper.getLogger(SearchResultPageTest.class);
    @BeforeMethod
    public void setup(){
        init();
        page.getInstance(IndexPage.class).setAmount(IndexPageConstant.AMOUNT_VAL2);
        page.getInstance(IndexPage.class).setRegion(IndexPageConstant.SOUTH_REGION);
        page.getInstance(IndexPage.class).setCategory(IndexPageConstant.HOME_GIFT_CATEGORY);
        searchResultPage=page.getInstance(IndexPage.class).clickOnSearchBtn();
    }
    @Test
    public void TC_001_VerifySearchResultPageHeader(){
        var header=searchResultPage.getSearchResultPageHeader();
        log.info("Verify "+header+" Contains :"+IndexPageConstant.AMOUNT_VAL2
                +"&&"+IndexPageConstant.SOUTH_REGION+
                "&&" + ""+IndexPageConstant.HOME_GIFT_CATEGORY);
        Assert.assertTrue(header.contains(IndexPageConstant.AMOUNT_VAL2)
                && header.contains(IndexPageConstant.SOUTH_REGION)
                && header.contains(IndexPageConstant.HOME_GIFT_CATEGORY));

    }
    @Test
    public void TC_002_SelectProduct(){
        searchResultPage.setProductValue(SearchResultPageConstant.PRODUCT_TEVA_NAOT);
        log.info("Select Product : "+SearchResultPageConstant.PRODUCT_TEVA_NAOT);
    }
}
