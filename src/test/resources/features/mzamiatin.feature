Feature: accommodations

  @mzamiatin @Test1
  Scenario: User searches and books a room

    Given user is on 'Home' page
    When user completes the 'locationField' field with 'Budapest' value
    And user selects '21' and '25' dates from 'Home' page
    And user clicks on 'searchButton'
    Then user is on 'AccommodationsSearchResults' page
    When user clicks on 'HotelName' link
    Then user is on 'Booking' page
#    When user clicks on 'Quantity' dropdown
#    And user clicks on '1'
#    And user clicks on 'I'll reserve'
#    And user clicks 'Close' in alert message
#    And user completes the 'Last Name' field with 'Chatterley' value
#    And user completes the 'Email Address' field with 'morceaug@gmail.com' value
#    And user completes the 'Confirm Email Address' field with 'morceaug@gmail.com' value
#    And user clicks on 'Next: Final Details'
#    And user clicks 'Close' in alert message
#    And user completes the 'Address' field with 'Green avenue, 19' value
#    And user completes the 'City' field with 'Chisinau' value
#    And user completes the 'Telephone' field with '6999999' value
#    And user clicks on 'Card Type' dropdown
#    And user clicks on 'Visa'
#    And user completes the 'Card Number' field with '4111 5543 6754 1111' value
#    And user clicks on 'Expiration date/Year' dropdown
#    And user clicks on '2028'
#    And user completes the 'CVC code' field with '345' value
#    And user clicks on 'Complete booking'
#    And user clicks 'Close' in alert message
#    Then user is on 'Confirmation' page

#


  @mzamiatin @Test2
  Scenario: User clicks on 'Great Getaway Sale' banner image to see the deals with summer season discounts

    Given user is on 'Home' page
    When user clicks on 'The Great Getaway Sale [View deals] button'
    And user clicks on ''Rome' banner image'
    And user clicks on ''Parking' checkbox'
    And user clicks on ''Only show available properties' checkbox'
    Then user is on ''SearchResults' with 'Getaway Deal' and 'Parking' labels' page