Feature: Login page aplikasi kasir aja

  Scenario: Success login
    Given Navigate in Login Page
    And Input valid username
    And Input valid password
    When Click login button
    Then User in dashboard menu

  Scenario: Unsuccessfull login
    Given Navigate in Login Page
    And Input valid username
    And Input invalid password
    When Click login button
    Then User can't login and get error message