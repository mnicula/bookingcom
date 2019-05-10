Feature: accommodations1

  Background:
    Given user is on 'Home' page
    And user clicks on 'signIn'
    And user is on 'Login' page
    And  user completes the 'emailSignIn' field with 'test1234@test123.com' value
    And user clicks on 'nextSignInButton'
    And  user completes the 'passwordSignIn' field with '123123123' value
    And user clicks on 'signInButton'
    And user is authenticated and is on home page
    And user is on 'Home' page

  @accommodations1
  Scenario: User searches and books a room
    When user completes the 'locationField' field with 'Budapest' value
    And user selects '21' and '25' dates from 'Home' page
    And user clicks on 'searchButton'
    Then user is on 'AccommodationsSearchResults' page
    When user clicks on first 'AccommodationName' link
    Then user is on 'Booking' page
    And user selects '1' room
    And user clicks on 'illreserveButton'
    Then user is on 'SecureBooking2' page
    And user completes the 'firstName' field with 'Denis' value
    And user completes the 'lastName' field with 'Danilov' value
    And user scrolls down the page and clicks Next
    Then user is on 'SecureBooking3' page
    And user scrolls down the page and fills in with '345' CVC code field if it appears on the page
    And user scrolls down the page and clicks Complete
    Then user is on 'Confirmation' page





