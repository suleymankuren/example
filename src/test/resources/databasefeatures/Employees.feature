Feature: Employee Information Test

  @hrTest @regression @smoke
  Scenario Outline: Positive test for employee information
    Given User connect to database
    When User gets the first employee from the table
    Then User validates employee information with the following data: "<employeeId>","<firstName>","<lastName>","<email>"
    And User validates employee information with the data: "<phoneNumber>","<hireDate>","<jobId>","<salary>","<comissionPct>"
    And User validates employee information with the employee data: "<managerId>","<departmentId>"

    Examples:
      | employeeId | firstName | lastName | email | phoneNumber  | hireDate  | jobId   | salary | comissionPct | managerId | departmentId |
      | 100        | Steven    | King     | SKING | 515.123.4567 | 17-JUN-87 | AD PRED | 24000  | null         | null      | 90           |