Feature: accommodations

  @accommodations1
  Scenario: User searches and books a room

    Given user is on 'Home' page
    When user completes the 'locationField' field with 'Budapest' value
    And user selects '21' and '25' dates from 'Home' page
    And user clicks on 'searchButton'
    Then user is on 'AccommodationsSearchResults' page
    When user clicks on first 'HotelName' link
    Then user is on 'Booking' page
    And user selects '1' room
    And user clicks on 'illreserveButton'
    Then user is on 'SecureBooking2' page
#    And user completes the 'firstName' field with 'Ian' value
#    And user completes the 'lastName' field with 'Chatterley' value
#    And user clicks on 'nextFinalDetailsButton'
#    Then user is on 'SecureBooking3' page
#    And user completes the 'CVC code' field with '345' value
#    And user clicks on 'Complete booking'
#    Then user is on 'Confirmation' page

#


  @accommodations2
  Scenario: User clicks on 'Great Getaway Sale' banner image to see the deals with summer season discounts and filter them

    Given user is on 'Home' page
    When user clicks on 'viewDealsOnGreatGetaway'
    Then user is on 'GetawayDeals' page
    And user clicks on 'romeCardImage'
    Then user is on 'GetawayDealsSearchResults' page
    When user filters the deals by criteria in the filter section
    Then user can check if the filter works OK