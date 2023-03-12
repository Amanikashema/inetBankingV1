package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import java.util.logging.Logger;
//import org.testng.log4testng.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String basUrl = readConfig.getApplicationURL();

    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static  Logger logger;

    @Parameters("browsers")
    @BeforeClass
    public void setup(String br){

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (br.equals("ie")) {
            System.setProperty("webdriver.ie.driver", readConfig.getIepath());
            driver = new InternetExplorerDriver();
            driver.manage().window().maximize();
        }
        driver.get(basUrl);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
