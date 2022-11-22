Feature: basic math
  Does the JVM know how to do math?


  Scenario: Finding some cheese
    Given I am on the Google search page
    When I search for "Cheese!"
    Then the page title should start with "cheese"