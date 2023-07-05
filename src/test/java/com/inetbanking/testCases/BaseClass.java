package com.inetbanking.testCases;

import com.inetbanking.utilities.ReadConfig;
import org.apache.log4j.PropertyConfigurator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.log4j.Logger;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String basUrl = readConfig.getApplicationURL();

    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    public static WebDriver driver;
    public static  Logger logger;

    @Parameters("browser")
    @BeforeClass
    public void setup(String br){

        logger = Logger.getLogger("ebanking");
        PropertyConfigurator.configure("log4j.properties");

        // Create a Chrome options object
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        if(br.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", readConfig.getChromepath());
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            logger.info("Chrome Browser Opened");
        }
        else if(br.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", readConfig.getFirefoxPath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver", readConfig.getEdgePath());
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }
        driver.get(basUrl);

    }

//    @AfterClass
//    public void tearDown(){
//        driver.quit();
//   }
}
