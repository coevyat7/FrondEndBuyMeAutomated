package test;

import constant.IndexPageConstant;
import logger.LoggerHelper;
import objects.IndexPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import test.base.BaseTest;

public class IndexPageTest extends BaseTest {
    private Logger log= LoggerHelper.getLogger(IndexPageTest.class);
    @BeforeMethod
    public void setup(){
        init();
    }



    @Test
    public void TC001_VerifyIndexPageTitle() {
        String title = page.getInstance(IndexPage.class).getPageTitle();
        Assert.assertTrue(title.contains(IndexPageConstant.TITLE));
        log.info("Verify IndexPageTitle Equality With: "+title+" Contains "+IndexPageConstant.TITLE);
    }

    @Test
    public void TC_002_SetAmount() {
        page.getInstance(IndexPage.class).setAmount(IndexPageConstant.AMOUNT_VAL2);

    }

    @Test
    public void TC_003_SetRegion() {
        page.getInstance(IndexPage.class).setRegion(IndexPageConstant.SOUTH_REGION);
    }

    @Test
    public void TC_004_SetCategory() {
        page.getInstance(IndexPage.class).setCategory(IndexPageConstant.HOME_GIFT_CATEGORY);
    }

    @Test
    public void TC_005_AutoCompleteDropdown()  {
        page.getInstance(IndexPage.class).setAutoCompleteInputBox(IndexPageConstant.SPORT,IndexPageConstant.SPORT_SUGGEST_VAL1);
    }
}
