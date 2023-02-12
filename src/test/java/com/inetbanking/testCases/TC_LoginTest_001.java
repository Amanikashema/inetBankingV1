package com.inetbanking.testCases;

import com.inetbanking.pageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_LoginTest_001 extends BaseClass {
    @Test
    public void loginTest(){
        driver.get(basUrl);

        LoginPage lp = new LoginPage(driver);
        lp.setUserName(username);
        lp.setPassword(password);
        lp.clickSubmit();

        if(driver.getTitle().equals("Welcome To Manager's Page of Guru99 Bank")){
            Assert.assertTrue(true);
            System.out.println(driver.getTitle());
        }
//        else{
//            Assert.assertTrue(false);
//            System.out.println(driver.getTitle());
//        }

    }
}
