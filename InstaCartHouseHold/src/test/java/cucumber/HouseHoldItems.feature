@tag
Feature: List HouseHold Items and check deliver time of stores
  I want to use this template for my feature file



  @tag2
  Scenario Outline: Positive test for getting household item details
    Given Instacart Application is launched
    When HouseHold Essential page is opened
    Then List of products is listed
    And List of stores with their delivery time is listed

