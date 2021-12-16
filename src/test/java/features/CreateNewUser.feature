Feature:Create new user
  Check ability to create new user

  @test
  Scenario Outline: Able to create new user
    Given To test the scenario- <scenarioName>
    Given I set 'POST' api request details as <requestDetails>
    When I send POST request using <payload>
    Then I receive response <responseCode> code for api response status code
    Then I receive response having successful validations <validations>
    Examples:
      | scenarioName                    | requestDetails  | payload         | responseCode | validations                                                                                                                                       |
      | Create user with normal details | resource:/users | createUser.json | 201          | id:11,-name:Jitendra Kumar,-email:Jitu@Jitu.Jitu,-address.street:Halfway Street,-address.suite:198A,-address.city:Sidcup,-address.zipcode:da158dj |
