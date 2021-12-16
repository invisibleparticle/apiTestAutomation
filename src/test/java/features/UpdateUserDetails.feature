Feature: Update existing user
Ability to update existing users

  @test
  Scenario Outline: Able to update user details
    Given To test the scenario- <scenarioName>
    Given I set 'PUT' api request details as <requestDetails>
    When I send PUT request using <payload>
    Then I receive response <responseCode> code for api response status code
    Then I receive response having successful validations <validations>
    Examples:
      | scenarioName          | requestDetails    | payload         | responseCode | validations                                                                                                                                       |
      | Able to update user 1 | resource:/users/1 | UpdateUser.json | 200          | id:1,-name:Jitendra Singh,-email:Richa@Jitu.Jitu,-address.street:Halfway Street,-address.suite:198A,-address.city:Sidcup,-address.zipcode:da158dj |
