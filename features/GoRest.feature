Feature: all Go rest requests

  @CreateUserGoREST
  Scenario: to very the user is created successfully
    Given create user for GoRest is created
    When I send post request with create user for GoRest
    Then status code should for GoRest be "201"
    Then "email" should for GoRest be "amol@gmail.com"

  @CreateUserGoRESTMultiple
  Scenario Outline: to very the user is created successfully
    Given create user for GoRest is created with <name> , <email> , <gender> and <status>
    When I send post request with create user for GoRest
    Then status code should for GoRest be "201"
    Then "email" should for GoRest be <email>
    Examples:
      | name         | email                   | gender | status   |
      | Aarav Singh  | aarav.singh1@email.com  | Male   | Active   |
      | Nisha Patel  | nisha.patel1@email.com  | Female | Inactive |
      | Arjun Sharma | arjun.sharma1@email.com | Male   | Active   |
      | Kavya Iyer   | kavya.iyer1@email.com   | Female | Active   |

