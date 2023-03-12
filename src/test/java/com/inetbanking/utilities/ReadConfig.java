package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.Properties;

public class ReadConfig {
    Properties pro;

    public ReadConfig(){
        // Declaring the Source Variable
        File src = new File("./configurations/config.properties");

        try{
            //Create a new Instance of FileInputStream
            FileInputStream fis = new FileInputStream(src);
            pro = new Properties();
            pro.load(fis);
        }catch (Exception e){
          System.out.println("Exception is " + e.getMessage());
        }
    }

    public String getApplicationURL(){
        String baseUrl;
        baseUrl = pro.getProperty("baseUrl");
        return baseUrl;
    }

    public String getUsername(){
        String username;
        username = pro.getProperty("username");
        return username;
    }

    public String getPassword(){
        String password;
        password = pro.getProperty("password");
        return password;
    }

    public String getChromepath(){
        String chromepath;
        chromepath = pro.getProperty("chromepath");
        return chromepath;
    }

    public String getIepath(){
        String iepath;
        iepath = pro.getProperty("iepath");
        return iepath;
    }

    public String getFirefoxPath(){
        String firefoxpath;
        firefoxpath = pro.getProperty("firefoxpath");
        return firefoxpath;
    }


}
