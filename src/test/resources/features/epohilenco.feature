Feature: booking


  @travelcommunities @positive @epohilenco @12
  Scenario Outline: verify that user can post a question with questionType='Transport' on 'Ask a question" form
    Given user is on 'Home' page
    When user clicks on 'lnk_TravelCommunity'
    Then user is on 'TravelCommunities' page
    And user clicks on 'askQuestionBtn'
    Then user is on 'AskQuestion' page
    And user clicks on 'selectQuestionType'
    And user selects the 'Transport' value from question type dropdown
    And user completes the 'inputDestinationFrom' field with '<transportDestFrom>' value
    And user completes the 'inputDestinationTo' field with '<transportDestTo>' value
#    And user clicks on selector 'selectTravellersNumber' and  chooses data ByVisibleText '<travellersNum>'
#    And user clicks on selector 'selectPreferencesBy' and  chooses data ByVisibleText '<preferences>'
    And user clicks on 'selectTravellersNumber'
    And user from selector 'selectTravellersNumber' chooses value ByVisibleText '<travellersNum>'
#    And user selects the '<travellersNum>' value from question type dropdown
#    And user clicks on selector 'selectTravellersNumber'  and chooses value by string '<travellersNum>'
#    And user from selector '(.*)' chooses value ByVisibleText '(.*)'$")
    And user clicks on 'selectPreferencesBy'
    And user from selector 'selectPreferencesBy' chooses value ByVisibleText '<preferences>'
#    And user selects the '<preferences>' value from question type dropdown
#    And user completes transport data  with '<selectTravellersNumber>'

    And user clicks on 'chooseTravelCommunityInputBox'
    And My user clicks on 'searchCommunitiesPlaceHolder'
#    And user put in the searchCommunitiesPlaceHolder KKKKK
    And user completes the 'searchCommunitiesPlaceHolder' field with '<plhldr>' value
    And user clicks on 'franceCommunityWebElement'

    Examples:
      | plhldr |title  | transportDestFrom|transportDestTo|travellersNum| preferences|
      | Fr     |Paris  |  Chisinau        | Paris         | 2           |  Plane     |
      | Fr     |Paris  |  Roma            | Bucharest     | 4           |  Car       |


  @travelcommunities @positive @epohilenco @14
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
    Then user is on 'TravelCommunities' page
    When user clicks on 'giveTipBtn'
    Then My user is on 'GiveTip' page
    And My user completes the 'titleInputBox' field with '<title>' value
    And My user completes the 'yourTipTextArea' field with '<advice>' value
    And user fill explicitly Communities
#    And My user clicks on 'chooseTravelCommunityInputBox'
#    And My user clicks on 'searchCommunitiesPlaceHolder'
#    And My user completes the 'searchCommunitiesPlaceHolder' field with '<placeholder>' value
#    And My user clicks on 'franceCommunityWebElement'
    When My user clicks on 'postBtn'
    Then The new window is displayed and it is not possible to clicks 'postBtn' now
#    And  user completes the 'titleInputBox' field with '<title>' value

    Examples:
      | email                  | password   | placeholder |title  | advice              |
      | pohilenkoelena@mail.ru | booking2019|    Fr       |Paris  | Please, visit Paris.|

