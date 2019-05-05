package com.endava.booking.atf.utilities;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;


public class PageObjectUtilities {
    private WebDriver driver;

    public PageObjectUtilities(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage getPageByName(String pageName) {
        BasePage parentPage = null;
        try {
            Class < ? > clazz = Class.forName ( "com.endava.booking.atf.page." + pageName + "Page" );
            Constructor constructor = clazz.getConstructor ( WebDriver.class );
            parentPage = (BasePage) constructor.newInstance ( driver );
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace ();
        }
        return parentPage;
    }

    public Method getWriteMethod(Object page , String methodName) {
        Method method = null;
        try {
            method = page.getClass ().getMethod ( methodName , WebElement.class , String.class );
        } catch (NoSuchMethodException e) {
            e.printStackTrace ();
        }
        return method;
    }

    public Method getClickMethod(Object page , String methodName) {
        Method method = null;
        try {
            method = page.getClass ().getMethod ( methodName , WebElement.class );
        } catch (NoSuchMethodException e) {
            e.printStackTrace ();
        }
        return method;
    }

    public WebElement getWebElementByName(Object page , String elementName) {
        WebElement element = null;
        try {
            Field field = page.getClass ().getDeclaredField ( elementName );
            field.setAccessible ( true );
            element = (WebElement) field.get ( page );
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace ();
        }
        return element;
    }

    public void switchTab(int tabNr){
        ArrayList <String> tabs = new ArrayList <>();
        tabs.addAll(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabNr));
    }

}