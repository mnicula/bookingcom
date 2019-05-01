package com.endava.booking.atf.enums;

/**
 * Created by Mihai
 * Date: 01.05.2019
 * Time: 10:08
 */
public enum Browser {

    CHROME("webdriver.chrome.driver"),
    INTERNETEXPLORER("webdriver.ie.driver");

    private final String driverProperty;

    Browser(String driverProperty) {
        this.driverProperty = driverProperty;
    }

    public String getDriverProperty() {
        return driverProperty;
    }
}
