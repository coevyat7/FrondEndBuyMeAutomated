package test;

import constant.IndexPageConstant;
import constant.ProductPageConstant;
import constant.SearchResultPageConstant;
import logger.LoggerHelper;
import objects.IndexPage;
import objects.ProductPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class ProductPageTest extends BaseTest {
    ProductPage productPage;
    private Logger log= LoggerHelper.getLogger(ProductPageTest.class);
    @BeforeMethod
    public void setup(){
        init();
        page.getInstance(IndexPage.class).setAmount(IndexPageConstant.AMOUNT_VAL2);
        page.getInstance(IndexPage.class).setRegion(IndexPageConstant.SOUTH_REGION);
        page.getInstance(IndexPage.class).setCategory(IndexPageConstant.HOME_GIFT_CATEGORY);
        productPage=page.getInstance(IndexPage.class).clickOnSearchBtn().setProductValue(SearchResultPageConstant.PRODUCT_TEVA_NAOT);

    }
    @Test
    public void TC_001_ProductPageHeader(){
        var header=productPage.getProductPageHeader();
        Assert.assertEquals(header, ProductPageConstant.TEVA_NAOT_TITLE);
        log.info("Verify "+header+" With "+ProductPageConstant.TEVA_NAOT_TITLE);
    }
    @Test
    public void TC_002_SetGiftCardAmount(){
        productPage.setMoneyBox(ProductPageConstant.AMOUNT);

    }
}
