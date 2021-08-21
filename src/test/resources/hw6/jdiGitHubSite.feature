Feature: Check of working the JDI GitHub Site
  Scenario: Check each element for existence on 'Index' page
    Given I open 'Index' page
    And I login as user 'Roman Iovlev'
    And I open the 'Different Elements' suboption in 'Service' option from the menu panel on the top
    When I select water, wind elements
    And I select selen metal
    And I select yellow color from drop-down list
    Then Selected elements should be visible in log field on 'Different Elements' page

  Scenario: User Table Page test
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    When I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    Then 'User Table' page should be opened
    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
    And 6 Usernames should be displayed on Users Table on User Table Page
    And 6 Description texts under images should be displayed on Users Table on User Table Page
    And 6 checkboxes should be displayed on Users Table on User Table Page
    And User table should contain following values:

      | Number | User             | Description                      |

      | 1      | Roman            | Wolverine                        |

      | 2      | Sergey Ivan      | Spider Man                       |

      | 3      | Vladzimir        | Punisher                         |

      | 4      | Helen Bennett    | Captain America some description |

      | 5      | Yoshi Tannamuri  | Cyclope some description         |

      | 6      | Giovanni Rovelli | Hulksome description             |

    And droplist should contain values in column Type for user Roman

      | Dropdown        |
      | Admin           |
      | User            |
      | Manager         |

  Scenario: Sergey status User Table Page test
    Given I open JDI GitHub site
    And I login as user 'Roman Iovlev'
    And I click on 'Service' button in Header
    And I click on 'User Table' button in Service dropdown
    When I select 'vip' checkbox for 'Sergey Ivan'
    Then 1 log row has 'Vip: condition changed to true' text in log section