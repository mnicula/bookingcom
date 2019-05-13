Feature: booking

  @travelcommunities @positive @epohilenco @15
  Scenario Outline: verify that user can post a tip on 'Give a tip' form on 'TravelCommunities' page
    Given user is on 'Home' page
    When user clicks on 'signIn'
    And user is on 'Login' page
    And  user completes the 'emailSignIn' field with '<email>' value
    And user clicks on 'nextSignInButton'
    And  user completes the 'passwordSignIn' field with '<password>' value
    And user clicks on 'signInButton'
    Then user is on 'Home' page
    When user clicks on 'lnk_TravelCommunity'
    Then user is on TravelCommunities page
    And user clicks on 'giveTipBtn' on 'TravelCommunities' page
    Then user is on 'GiveTip' page
    And user clicks on 'chooseTravelCommunityInputBox' on 'GiveTip' page
    And user select community by name '<community>' on GiveTip page
    And user completes the 'titleInputBox' field with '<title>' value on 'GiveTip' page
    And user completes the 'yourTipTextArea' field with '<advice>' value on 'GiveTip' page
    When user clicks on 'postBtn' on 'GiveTip' page
    Then user is on 'ConfirmationPost' page
    And confirmation has done on corresponding Community page

    Examples:
      | email                  | password   | community   |title  | advice              |
#      | pohilenkoelena@mail.ru | booki|   France    |Paris  | Please, visit Paris.|
      | icovaci@inbox.ru        | icovaci1962|   Egypt     |Cairo  | Please, visit Egyptian Museum.|
#      | icovaci@inbox.ru        | icovaci1962|   Egypt     |Giza | Please, visit Giza.|


  @travelcommunities @negative @epohilenco @16
  Scenario Outline: verify that unauthorized user cann't post a question with questionType='Transport'
  on 'Ask a question" form
    Given user is on 'Home' page
    When user clicks on 'lnk_TravelCommunity'
    Then user is on TravelCommunities page
    And user clicks on 'askQuestionBtn' on 'TravelCommunities' page
    Then user is on 'AskQuestion' page
    And user clicks on 'chooseTravelCommunityInputBox' on 'AskQuestion' page
    And user select community by name '<community>' on AskQuestion page
    And user selects the 'Transport' value from question type dropdown
    And user completes the 'inputDestinationFrom' field with '<transportDestFrom>' value
    And user selects city from list begining at '<transportDestFrom>'
    And user completes the 'inputDestinationTo' field with '<transportDestTo>' value
    And user selects city from list begining at '<transportDestTo>'
    And user selects any data from 'selectTravellersNumber' field on AskQuestionPage
    And user selects any data from 'selectPreferencesBy' field on AskQuestionPage
    And user completes the 'textAreaforTransportQuestion' field with '<questionText>' value
    When user clicks on 'postBtn' on 'AskQuestion' page
    Then user is on 'LoginNeeded' page
    Examples:
     |community | transportDestFrom |transportDestTo|questionText|
     |Georgia   |  Tb                | Ch           |How can I faster get it?|
     |France    |  Le                | Ro           |How can I cheaper get it?|

  @travelcommunities @negative @epohilenco @17
  Scenario Outline: verify that unauthorized user cann't post a question with questionType='Places to stay' 
  on 'Ask a question" form
    Given user is on 'Home' page
    When user clicks on 'lnk_TravelCommunity'
    Then user is on TravelCommunities page
    And user clicks on 'askQuestionBtn' on 'TravelCommunities' page
    Then user is on 'AskQuestion' page
    And user clicks on 'chooseTravelCommunityInputBox' on 'AskQuestion' page
    And user select community by name '<community>' on AskQuestion page
    And user selects the 'Places to stay' value from question type dropdown
    And user completes the 'inputProperty' field with '<propertyPlaceHolder>' value
    And user selects city from list begining at '<propertyPlaceHolder>'
    And user selects any data from 'selectTravellingAs' field on AskQuestionPage
    And user selects any data from 'selectBudget' field on AskQuestionPage
    And user completes the 'textAreaforplacesToStayQuestion' field with '<advice>' value on 'AskQuestion' page
    When user clicks on 'postBtn' on 'AskQuestion' page
    Then user is on 'LoginNeeded' page

    Examples:
      |community | propertyPlaceHolder|advice|
      |Italy     | B                  | Don't worry!|


  @travelcommunities @positive @epohilenco @18
  Scenario Outline: verify that authorized user can post a question with questionType='Transport'
  on 'Ask a question" form
    Given user is on 'Home' page
    When user clicks on 'signIn'
    And user is on 'Login' page
    And  user completes the 'emailSignIn' field with '<email>' value
    And user clicks on 'nextSignInButton'
    And  user completes the 'passwordSignIn' field with '<password>' value
    And user clicks on 'signInButton'
    Then user is on 'Home' page
    When user clicks on 'lnk_TravelCommunity'
    Then user is on TravelCommunities page
    And user clicks on 'askQuestionBtn' on 'TravelCommunities' page
    Then user is on 'AskQuestion' page
    And user clicks on 'chooseTravelCommunityInputBox' on 'AskQuestion' page
    And user select community by name '<community>' on AskQuestion page
    And user selects the 'Transport' value from question type dropdown
    And user completes the 'inputDestinationFrom' field with '<transportDestFrom>' value
    And user selects city from list begining at '<transportDestFrom>'
    And user completes the 'inputDestinationTo' field with '<transportDestTo>' value
    And user selects city from list begining at '<transportDestTo>'
    And user selects any data from 'selectTravellersNumber' field on AskQuestionPage
    And user selects any data from 'selectPreferencesBy' field on AskQuestionPage
    And user completes the 'textAreaforTransportQuestion' field with '<questionText>' value
    When user clicks on 'postBtn' on 'AskQuestion' page
    Then user is on 'ConfirmationPost' page
    And confirmation has done on corresponding Community page

    Examples:
      |community | transportDestFrom |transportDestTo|questionText            |   email                 | password   |
      |Georgia   |  Tb                | Ch           |How can I faster get it?| icovaci@inbox.ru        | icovaci1962|
#     |France    |  Le                | Ro           |How can I cheaper get it?| icovaci@inbox.ru        | icovaci1962|




