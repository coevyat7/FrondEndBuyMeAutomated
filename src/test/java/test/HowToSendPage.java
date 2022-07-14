package test;

import constant.*;
import logger.LoggerHelper;
import objects.IndexPage;
import objects.ProductPage;
import objects.SearchResultPage;
import objects.WhoToSendPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class HowToSendPage extends BaseTest {
    IndexPage indexPage;
    SearchResultPage searchResultPageTest;
    ProductPage productPage;
    WhoToSendPage whoToSendPage;
    objects.HowToSendPage howToSendPage;
    private Logger log= LoggerHelper.getLogger(ProductPageTest.class);


    @BeforeMethod
    public void setup(){
        init();
        indexPage=page.getInstance(IndexPage.class);
        indexPage.setAmount(IndexPageConstant.AMOUNT_VAL2);
        indexPage.setRegion(IndexPageConstant.SOUTH_REGION);
        indexPage.setCategory(IndexPageConstant.HOME_GIFT_CATEGORY);
        searchResultPageTest=indexPage.clickOnSearchBtn();
        productPage=searchResultPageTest.setProductValue(SearchResultPageConstant.PRODUCT_TEVA_NAOT);
        productPage.setMoneyBox(ProductPageConstant.AMOUNT);
        whoToSendPage=productPage.clickOnConfirmMoneyButton();
        whoToSendPage.setReceiverName(WhoToSendPageConstant.receiverNAME);
        whoToSendPage.setPickBlessing(WhoToSendPageConstant.BLESSING_POOL_VAL7);
        whoToSendPage.setOwnBlessing(WhoToSendPageConstant.OWN_BLESSING_VALUE);
        whoToSendPage.setPhoto(WhoToSendPageConstant.PHOTO_SUGGEST);
        howToSendPage=whoToSendPage.clickOnContinueBtn();
    }
    @Test
    public void TC_001_verifyHowToSendPageHeader(){
        var header=howToSendPage.getHowToSendPageHeader();
        Assert.assertEquals(header, HowToSendPageConstant.PAGE_HEADER);
        log.info("Verify Page Header: "+header+" With "+HowToSendPageConstant.PAGE_HEADER);
    }
    @Test
    public void TC_002_setLater(){
        howToSendPage.clickOnLaterBtn();
        howToSendPage.setTimeToLater(HowToSendPageConstant.MONTH_VAL_11,HowToSendPageConstant.DAY_VAL_14,HowToSendPageConstant.HOUR_MINUTE_VAL_11_15);
    }
    @Test
    public void TC_003_setEmail(){
        howToSendPage.setEmail(HowToSendPageConstant.EMAIL_SUGGESTION);
    }
    @Test
    public void TC_004_setSenderName(){
        howToSendPage.setSenderName(HowToSendPageConstant.SENDER_NAME);
    }


}
