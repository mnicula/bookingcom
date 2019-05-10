Feature: accommodations2

@accommodations2
Scenario: User clicks on 'Great Getaway Sale' banner to see the deals with summer season discounts and filter them

Given user is on 'Home' page
When user clicks on 'viewDealsOnGreatGetaway'
Then user is on 'GetawayDeals' page
And user clicks on 'romeCardImage'
Then user is on 'GetawayDealsSearchResults' page
When user filters the deals with checkboxes in the filter section
Then user can check if the filter works OK


@accommodations3
Scenario: User looks for vacation rentals in Spain and clicks on 'Guest Reviews' tab to read the reviews about a property he likes

Given user is on 'Home' page
When user completes the 'locationField' field with 'Spain' value
And user clicks on 'searchButton'
Then user is on 'AccommodationsSearchResults' page
When user filters the deals by clicking a button in the search table
And user clicks on first 'AccommodationName' link
Then user is on 'Booking' page
When user clicks on 'guestReviewsTab'
Then 'reviewsWidget' slides from the side of the page