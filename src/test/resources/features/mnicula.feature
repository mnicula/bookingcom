Feature:booking
  @search @mnicula
  Scenario: User search a hotel room
    Given user is on 'Home' page
    When user completes the 'locationField' field with 'Moscow' value
    And user sets dates
    And user clicks on 'searchButton'
   # Then 'SearchResult' page is displayed