Feature: Test PetStore APIs

  @postPetStore @smoke @regression
  Scenario: Create new pet
    Given User checks pet is not created before
    When User executes post request
    Then Status code is 200
    And Pet has following attributes
      | petId  | petName | petStatus            |
      | 301030 | Ted     | successfully created |

  @getPetStore @smoke @regression
  Scenario: Get pet by id
    When User executes get call
    Then User validates status code is 200
    And Pet has following items
      | petId  | petName | petStatus            |
      | 201020 | Max     | successfully created |

  @deletePetStore @smoke @regression
  Scenario: Delete existing pet
    Given User checks pet is created
    When User executes delete request for pet
    Then User validates status code is 200 for pet
    And User executes get request to check status code is 404

  @putPetStore @smoke @regression
  Scenario: Update existing pet
    Given User creates a pet
    When User executes put request for pet
    Then Status code is 200 or not
    And Pet has following data
      | petId  | petName | petStatus            |
      | 205010 | Mark    | successfully updated |
    And User deletes updated pet