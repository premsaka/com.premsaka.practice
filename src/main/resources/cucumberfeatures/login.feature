Feature: Login page applicaton

  @tag1
  Scenario: Login to application
    Given Open browser and navigate to application
    And I check the login page is lunch sucessfully
    When I enter the <username> and <password> and clickon login button
    Then I see the home page is loading sucessfully
    And I logout from the application

    Examples:
		|username|	password|
		|Admin|	admin123|
		