Feature: Get user details based on search criteria
  Get existing user details based on different search criteria and verify
#Notes on how to write in requestDetails,searchCriteria,validations
# requestDetails-> we can write request details as key:value . Here, : is used as separator between key and its value.
#For multiple key: value we need to use ,- as separator  like key1:value1,-key2:value2


# searchCriteria-> we can write search criteria to used in queryParam for GET request like param1:value1 . Here, : is used as separator between param and its value.
#For multiple param: value we need to use ,- as separator  like param1:value1,-param2:value2

# validations-> Required validation for json response will go here.We need to write json path of response node and its expected value.
#Write it as jsonPathOfNode:expectedValue.Here, : is used as separator between jsonPathOfNode and expectedValue.
#For multiple validations we need to use ,- as separator  like jsonPathOfNode1:expectedValue1,-jsonPathOfNode2:expectedValue2


#We can write scenarios in BDD form as well.The way it is written here enables a developer to write more scenarios without modifying the
#step definition(Minimal code writing). More scenario coverage in quick time.


  @test
  Scenario Outline: Able to get user details based on different search criteria
    Given To test the scenario- <scenarioName>
    Given I set 'GET' api request details as <requestDetails>
    When I send GET request using <searchCriteria>
    Then I receive response <responseCode> code for api response status code
    Then I receive response having successful validations <validations>
    Examples:
      | scenarioName                          | requestDetails  | searchCriteria            | responseCode | validations                                                                                                                                                               |
      | able to search using id and name      | resource:/users | id:1,-name:Leanne Graham  | 200          | name[0]:Leanne Graham,-email[0]:Sincere@april.biz,-address[0].street:Kulas Light,-address[0].suite:Apt. 556,-address[0].city:Gwenborough,-address[0].zipcode:92998-3874   |
      | able to search using id only          | resource:/users | id:2                      | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |
      | able to search using username only    | resource:/users | username:Antonette        | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |
      | able to search using email only       | resource:/users | email:Shanna@melissa.tv   | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |
      | able to search using phonenumber only | resource:/users | phone:010-692-6593 x09125 | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |
      | able to search using website only     | resource:/users | website:anastasia.net     | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |
      | able to search using companyName only | resource:/users | company.name:Deckow-Crist | 200          | name[0]:Ervin Howell,-email[0]:Shanna@melissa.tv,-address[0].street:Victor Plains,-address[0].suite:Suite 879,-address[0].city:Wisokyburgh,-address[0].zipcode:90566-7771 |


