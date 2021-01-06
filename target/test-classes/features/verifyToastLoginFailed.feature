@LogInPage @Smoke
Feature: Verify Toast Message popup failed login

  @ToastPopUp
  Scenario: Verify Toast
    When user is launching the app
    And user is not providing sufficient input to log int
    Then user should be able to see Toast Message

    @PositiveLogIn
    Scenario: Verify positive Log In
      When user is launching the app2
      And user is providing sufficient input
      Then user should be able to verify log in info


