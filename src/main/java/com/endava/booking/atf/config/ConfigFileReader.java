package com.endava.booking.atf.config;


import com.endava.booking.atf.enums.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

    private final String PROPERTY_FILE_PATH = "configs//Configuration.properties";
    private Properties properties;

    public ConfigFileReader() {

        try (
                BufferedReader reader = new BufferedReader(new FileReader(PROPERTY_FILE_PATH))) {
            properties = new Properties();
            properties.load(reader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }

    public String getDriverPath() {
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null) {
            return driverPath;
        } else {
            throw new RuntimeException("Driver Path not specified in the " + PROPERTY_FILE_PATH + " file for the Key:driverPath");
        }
    }

    public String getURLLanguage() {
        String language = properties.getProperty("language");
        if (language != null) return language;
        else
            throw new RuntimeException("Application language not specified in the " + PROPERTY_FILE_PATH + " file for the Key:langauge");
    }

    public String getApplicationHomeURL() {
        String homeURL = properties.getProperty("homeURL");
        if (homeURL != null) return homeURL;
        else
            throw new RuntimeException("Application Url not specified in the " + PROPERTY_FILE_PATH + " file for the Key:homeURL");
    }

    public Browser getBrowser() {
        String browserName = properties.getProperty("browser");
        switch (browserName.toLowerCase()) {
            case "chrome":
                return Browser.CHROME;
            case "ie":
                return Browser.INTERNETEXPLORER;
            default:
                throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);

        }
    }
    public Boolean getBrowserWindowSize() {
        String windowSize = properties.getProperty("windowMaximize");
        return (windowSize != null) ? Boolean.valueOf(windowSize) : true;
    }


    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " to Long value");
            }
        }
        return 15;
    }

    public ChromeOptions getUserDataOption(){
        String userDataOption = properties.getProperty("userdata");
        if(userDataOption.equals("true")){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=target/custom/profile");
        return options;}
        else if (userDataOption.equals("false")){
           return new ChromeOptions();
        }
        else throw new RuntimeException("Chrome userdata option not specified in the " + PROPERTY_FILE_PATH + " file for the Key:userdata");
    }

    }






