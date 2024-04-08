Feature: get single resource functionality
  As a user
  I want to be able to get single resource by id

  Scenario: get resource by existing id
    When I send request to get single resource by existing id
    Then I should receive 'resourceSuccessBody.json' resource data

  Scenario Outline: get resource by unexisting id
    When I send request to get resource by unexisting id
    Then I should receive <string> resource data with empty body
    Examples:
      | string|
      | "resourceUnSuccessBody.json"|
