package com.endava.booking.atf.page;

import com.endava.booking.atf.common.action.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultsPage extends BasePage {



    @FindBy(xpath="//div[@class='destination-sr-header__col destination-sr-header__content']")
    WebElement searchHeader;

    @FindBy(xpath="//div[contains(@class,'compset_loaded')]" +
            "//div[contains(@class,'sr_item_content sr_item_content_slider_wrapper')]" +
            "//div[contains(@class,'sr_rooms_table_block clearfix')]" +
            "//div[contains(@class,'room_details')]" +
            "//div[contains(@class,'featuredRooms sr_room_table sr_room_table_flex sr_rt_wider_urgency_msg')]//div" +
            "//div[contains(@class,'roomrow roomrow_flex entire_row_clickable')]")
    WebElement HotelName;


    //div[@id='hotellist_inner']
    //body[@id='b2searchresultsPage']/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[@id='searchresultsTmpl']/div[@id='basiclayout']/div[@id='right']/div[@id='ajaxsrwrap']/div[@id='search_results_table']/div[contains(@class,'hotellist sr_double_search')]/div[@id='hotellist_inner']/div[1]

    //div[contains(@class,'compset_loaded')]//div[contains(@class,'featuredRooms sr_room_table sr_room_table_flex sr_rt_wider_urgency_msg')]

    //body[@id='b2searchresultsPage']/div[@id='bodyconstraint']/div[@id='bodyconstraint-inner']/div[@id='searchresultsTmpl']/div[@id='basiclayout']/div[@id='right']/div[@id='ajaxsrwrap']/div[@id='search_results_table']/div[contains(@class,'hotellist sr_double_search')]/div[@id='hotellist_inner']/div[5]/div[2]/div[2]/div[1]/div[1]
    //div[@id='search_results_table'] - table containing all the hotels from the search results


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isElementDisplayed() {
        try {
            return this.searchHeader.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }









}


