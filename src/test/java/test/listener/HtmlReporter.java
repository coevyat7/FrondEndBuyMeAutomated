package test.listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;
import test.base.BaseTest;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.name;

public class HtmlReporter extends TestListenerAdapter {
    ExtentReports extent;
    File file;
    ExtentSparkReporter spark;
    ExtentTest test;
    String name;


    public void onStart(ITestContext context) {
        extent = new ExtentReports();
         name = new SimpleDateFormat("yyyy.MM.dd--HH.mm.ss").format(new Date());
        file = new File(name + ".html");
        spark = new ExtentSparkReporter("./reports/" + file);
        try {
            spark.loadJSONConfig(new File("C:\\Users\\coevy\\IdeaProjects\\FrondEndBuyMeAutomation\\configs\\extentReportConfig.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        extent.attachReporter(spark);


    }
    public void onTestSuccess(ITestResult tr){
        test=extent.createTest(tr.getName());
        test.log(Status.PASS,"Test Pass");

    }
    public void onTestSkipped(ITestResult tr){
       test= extent.createTest(tr.getName());
        test.log(Status.SKIP, "Test Skipped");
    }
    public void onTestFailure(ITestResult tr) {
        test = extent.createTest(tr.getName());
        test.log(Status.FAIL, capScreenShot(tr.getName()+".png"));
        Reporter.log(capScreenShot(tr.getName()+name+".png"));
    }



        public void onFinish(ITestContext context){
            extent.flush();

    }

        public static String capScreenShot(String fileName){
            TakesScreenshot takesScreenshot=(TakesScreenshot) BaseTest.getDriver();
            File src=takesScreenshot.getScreenshotAs(OutputType.FILE);
            File dest=new File("./screenshots/"+fileName);
            try {
                FileUtils.copyFile(src,dest);
            }catch (IOException e){
                e.getCause();
            }

            return dest.getAbsolutePath();

        }
    }






