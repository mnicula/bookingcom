Feature: booking

  @register @positive @aserbu @1
  Scenario Outline: verify that user is able to register
    Given user is on 'Home' page
    And user clicks on 'registerButton'
    Then user is on 'Register' page
    And  user completes the 'mailInput' field with '<email>' value
    And user clicks on 'getStartedButton'
    When  user completes the 'password1Input' field with '<password>' value
    And  user completes the 'password2Input' field with '<password>' value
    And user clicks on 'createAccountButton'
    Then user is registered
    Examples:
      | email              | password |
      | atftest13@mail.com | test1234 |


  @register @negative @aserbu @2
  Scenario Outline: verify that user is not able to register while providing invalid data
    Given user is on 'Home' page
    And user clicks on 'registerButton'
    Then user is on 'Register' page
    And user fills in duplicate account mail
    And user clicks on 'getStartedButton'
    Then user is warned about duplicate mail
    And  user completes the 'mailInput' field with '<email>' value
    And user clicks on 'getStartedButton'
    When user fills in different passwords
    Then user is warned about password mismatch
    Examples:
      | email              | password |
      | atftest09@mail.com | test1234 |


  @login @positive @aserbu @3
  Scenario Outline: Check if registered user is able to add valid credit card to profile
    Given user is on 'Home' page
    When user clicks on 'signIn'
    And user is on 'Login' page
    And  user completes the 'emailSignIn' field with '<email>' value
    And user clicks on 'nextSignInButton'
    And  user completes the 'passwordSignIn' field with '<password>' value
    And user clicks on 'signInButton'
    Then user is authenticated and is on home page
    And user is on 'Home' page
    And user clicks on 'yourAccountBlock'
    And user clicks on 'settingsOption'
    And user is on 'Settings' page
    And user clicks on 'addCreditCardButton'
    And user completes the 'Settings' form with following data
      | cardNumber       | cardHolder |
      | 4111111111111111 | Test 123   |
    And user sets cardtype with '<cardtype>'and expiry month '<expiryMonth>' and year '<expiryYear>'
    And user clicks on 'saveCreditChangesButton'
    Then credit card is added
    Examples:
      | email                | password  | cardtype | expiryMonth | expiryYear |
      | test1234@test123.com | 123123123 | Visa     | 03          | 2020       |