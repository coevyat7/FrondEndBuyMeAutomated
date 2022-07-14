package test;

import constant.*;
import logger.LoggerHelper;
import objects.*;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import objects.HowToSendPage;
import test.base.BaseTest;



public class LoginPageTest extends BaseTest {
    IndexPage indexPage;
    SearchResultPage searchResultPageTest;
    ProductPage productPage;
    WhoToSendPage whoToSendPage;
    HowToSendPage howToSendPage;
    LoginPage loginPage;
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
        howToSendPage.clickOnLaterBtn();
        howToSendPage.setTimeToLater(HowToSendPageConstant.MONTH_VAL_11,HowToSendPageConstant.DAY_VAL_14,HowToSendPageConstant.HOUR_MINUTE_VAL_11_15);
        howToSendPage.setEmail(HowToSendPageConstant.EMAIL_SUGGESTION);
        howToSendPage.setSenderName(HowToSendPageConstant.SENDER_NAME);
        loginPage=howToSendPage.clickOnContinueBtn();
    }
    @Test
    public void TC_001_verifyPageHeader(){
        var title=loginPage.getLoginPageHeader();
        Assert.assertEquals(title,LoginPageConstant.PAGE_HEADER);
        log.info("Verify Login Page Header Equality: "+title+ " With "+LoginPageConstant.PAGE_HEADER);
    }
    @Test
    public void TC_002_ValidateLoginSuccess(){
        loginPage.setEmail(LoginPageConstant.EMAIL);
        loginPage.setPassword(LoginPageConstant.PASSWORD);
        loginPage.clickOnLoginBtn();
        Assert.assertTrue(loginPage.accountDisplay());
        log.info("Login Success..");
    }

}
