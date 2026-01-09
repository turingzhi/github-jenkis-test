Feature: String Calculator

  Scenario: Empty string returns zero
    Given the input is ""
    When I add the numbers
    Then the result should be 0

  Scenario: Multiple numbers are summed
    Given the input is "1,2,3"
    When I add the numbers
    Then the result should be 6

  Scenario: Newlines are treated as commas
    Given the input is "1\n2,3"
    When I add the numbers
    Then the result should be 6

  Scenario: Custom delimiter is supported
    Given the input is "//;\n1;2"
    When I add the numbers
    Then the result should be 3

  Scenario: Negative numbers are not allowed
    Given the input is "1,-2,3"
    When I add the numbers
    Then an error should be thrown
