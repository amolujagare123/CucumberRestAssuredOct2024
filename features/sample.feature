Feature: all reqres.in related scenarios

  Background: base url
    Given base url is set

    @createUserSample
  Scenario: verify user is created successfully
    Given create user payload is created
    When I send post request with create user resource
    Then status code should be "201"
    Then "name" should be "Amol"

  @UpdateUserSample
  Scenario: verify user is updated successfully
    Given update user payload is created
    When I send put request with update user resource
    Then status code should be "200"
    Then "name" should be "Amol2"