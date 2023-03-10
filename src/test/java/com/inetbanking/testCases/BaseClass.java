package com.inetbanking.testCases;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.logging.Logger;

public class BaseClass {
    public String basUrl = "https://demo.guru99.com/v3/index.php";
    public String username = "mngr484312";
    public String password = "AdunUhA";
    public static WebDriver driver;
    public static  Logger logger;

    @BeforeClass
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
