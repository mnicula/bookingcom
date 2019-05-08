Feature: booking

  @register @positive @aserbu @1
  Scenario Outline: verify that user is able to register with valid credentials
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
      | email               | password |
      | atftest123@mail.com | test1234 |


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
    Then user is authenticated
    And user is on 'Home' page
    And user clicks on 'yourAccountBlock'
    And user clicks on 'settingsOption'
    And user is on 'Settings' page
    And user clicks on 'addCreditCardButton'
    And user completes card data  with '<cardtype>' , '<expiryMonth>' , '<expiryYear>', '<cardNumber>' and '<cardHolder>'
    And user clicks on 'saveCreditChangesButton'
    Then credit card is added
    Examples:
      | email                | password  | cardtype | expiryMonth | expiryYear | cardNumber       | cardHolder  |
      | test1234@test123.com | 123123123 | Visa     | 03          | 2020       | 4111111111111111 | Test Tiesto |

  @negative @aserbu @4
  Scenario Outline: verify that user is not able to save credit card while providing no data
    Given user is on 'Home' page
    When user clicks on 'signIn'
    And user is on 'Login' page
    And  user completes the 'emailSignIn' field with '<email>' value
    And user clicks on 'nextSignInButton'
    And  user completes the 'passwordSignIn' field with '<password>' value
    And user clicks on 'signInButton'
    Then user is authenticated
    And user is on 'Home' page
    And user clicks on 'yourAccountBlock'
    And user clicks on 'settingsOption'
    And user is on 'Settings' page
    And user clicks on 'addCreditCardButton'
    And user clicks on 'saveCreditChangesButton'
    Then user is warned that saving card is not possible
    Examples:
      | email                | password  |
      | test1234@test123.com | 123123123 |