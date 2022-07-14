package test;

import constant.IndexPageConstant;
import constant.ProductPageConstant;
import constant.SearchResultPageConstant;
import constant.WhoToSendPageConstant;
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

public class WhoToSendPageTest extends BaseTest {
    IndexPage indexPage;
    SearchResultPage searchResultPageTest;
    ProductPage productPage;
    WhoToSendPage whoToSendPage;
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
    }
    @Test
    public void TC_001_verifyWhoToSendPageTitle(){
        var title=whoToSendPage.getPageTitle();
        Assert.assertEquals(title, WhoToSendPageConstant.TEVA_NAOT_TITLE);
        log.info("Verify Page title: "+title+" With "+WhoToSendPageConstant.TEVA_NAOT_TITLE);
    }
    @Test
    public void TC_002_verifyWhoToSendPageHeader(){
        var header=whoToSendPage.getWhoToSendPageHeader();
        Assert.assertEquals(header,WhoToSendPageConstant.PAGE_HEADER);
        log.info("Verify Page Header: "+header+" With "+WhoToSendPageConstant.PAGE_HEADER);
    }
    @Test
    public void TC_003_setReceiverName(){
       whoToSendPage.setReceiverName(WhoToSendPageConstant.receiverNAME);

    }
    @Test
    public void TC_004_selectBlessingFromPool(){
        whoToSendPage.setPickBlessing(WhoToSendPageConstant.BLESSING_POOL_VAL7);
    }
    @Test
    public void TC_005_addBlessingText(){
        whoToSendPage.setOwnBlessing(WhoToSendPageConstant.OWN_BLESSING_VALUE);
    }
    @Test
    public  void TC_006_uploadPhoto(){
        whoToSendPage.setPhoto(WhoToSendPageConstant.PHOTO_SUGGEST);
    }

}
