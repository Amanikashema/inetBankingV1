package com.inetbanking.utilities;

// Listener class used to generate Extent Reports
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.inetbanking.testCases.BaseClass.driver;

public class Reporting extends TestListenerAdapter {
    public ExtentSparkReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;

    @SneakyThrows
    public void onStart(ITestContext testContext) {
        // Creating Time Stamp
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
        String reportName = "Test-Report-"+timeStamp+".html";
        // Instantiating a html-reporter object
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/"+reportName);
//        htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

        // Instantiating a new  extent object
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment","QA");
        extent.setSystemInfo("user","Amani");

        htmlReporter.config().setDocumentTitle("InetBanking Test Project");//Setting the Title of Report Page
        htmlReporter.config().setReportName("Functional Automation Test Report");// Setting the name of the report
        htmlReporter.config().setTheme(Theme.DARK);// Setting Page Theme Dark
    }


    public void onTestSuccess(ITestResult results){
        logger = extent.createTest(results.getName());// create new entry in Report
        logger.log(Status.PASS, MarkupHelper.createLabel(results.getName(), ExtentColor.GREEN));
    }

    public void onTestFailure(ITestResult results){
        logger = extent.createTest(results.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(results.getName(), ExtentColor.RED));

        String screenShotPath = System.getProperty("user.dir")+ "\\Screenshots\\"+results.getName()+".png";

        File f = new File(screenShotPath);
        File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        if(f.exists()) {
            logger.fail("Screenshot is below: " + logger.addScreenCaptureFromBase64String(screenShotPath));
        }

    }

    public void onTestSkipped(ITestResult results){
        logger = extent.createTest(results.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(results.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext){
        extent.flush();
    }

}
