Feature: Index page check elements exist
  Scenario: Check each element for existence on 'Index' page
    Given I open 'Index' page
    And I login as user 'Roman Iovlev'
    And I open the 'Different Elements' suboption in 'Service' option from the menu panel on the top
    When I select water, wind elements
    And I select selen metal
    And I select yellow color from drop-down list
    Then Selected elements should be visible in log field on 'Different Elements' page