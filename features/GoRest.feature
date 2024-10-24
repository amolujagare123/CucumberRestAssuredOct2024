Feature: all Go rest requests

  @CreateUserGoREST
  Scenario: to very the user is created successfully
    Given create user for GoRest is created
    When I send post request with create user for GoRest
    Then status code should for GoRest be "201"
    Then "email" should for GoRest be "amol@gmail.com"