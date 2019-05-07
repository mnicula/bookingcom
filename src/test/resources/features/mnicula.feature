Feature:booking
  @searchCar @mnicula
  Scenario: User search a car rental
    Given user is on 'Home' page
    And user clicks on 'carRentals' button
    Then user is on 'CarRentals' page
    When user completes the 'pickUpLocation' field with 'Domodedovo Airport' value
    And user clicks on 'firstResult'
    And user clicks on 'searchButton'
    Then user is redirected on 'CarSearchResults' Page
    When user clicks on orderByPrice
    Then results are ordered ascending by price

    @bookCar @mnicula
    Scenario: User books a car rental
      Given user is on 'Home' page
      And user clicks on 'carRentals' button
      Then user is on 'CarRentals' page
      When user completes the 'pickUpLocation' field with 'Otopeni ' value
      And user clicks on 'firstResult'
      And user clicks on 'searchButton'
      Then user is redirected on 'CarSearchResults' Page
      When user clicks on first chooseCar button
      Then user is on 'CarBooking' page
      When user clicks on goToBook button
      And user enters personal info
      And user clicks on BookNow button
      And user enters payment details
      And user clicks on 'BookNow'
