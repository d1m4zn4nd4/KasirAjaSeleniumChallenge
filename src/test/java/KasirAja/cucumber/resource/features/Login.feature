Feature: Login page aplikasi kasir aja

  @Regression @positive
  Scenario: Success login
    Given Navigate in Login Page
    And Input valid username
    And Input valid password
    When Click login button
    Then User in dashboard menu

  @Regresion @negative
  Scenario: Unsuccessfull login
    Given Navigate in Login Page
    And Input valid username
    And Input invalid password
    When Click login button
    Then User can't login and get error message

  @TDD
  Scenario Outline: Login user to KasirAja
    Given Navigate in Login Page
    And Input <email> as email
    And Input <password> as password
    When Click login button
    Then I Verify <status> login result

    Examples:
      | email         | password | status  |
      | admin@sel.com | test321  | success |
      | admin@sel.com | 321      | failed  |





