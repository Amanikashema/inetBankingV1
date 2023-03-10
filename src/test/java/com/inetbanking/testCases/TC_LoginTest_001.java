package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest(){
        driver.get(basUrl);
        logger.info("URL is Opened");

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        logger.info("Entered Username");
        lp.setPassword(password);
        logger.info("Entered Password");
        lp.clickSubmit();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            Assert.assertTrue(true);
            logger.info("Login Test Passed");
            System.out.println(driver.getTitle());
        }
        else{
            Assert.fail();
            logger.info("Login Test Failed");
        }

    }
}
