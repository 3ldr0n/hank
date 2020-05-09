Feature: Create todo

  Scenario: Create first todo
    Given there are no tasks registered
    When hank is asked to create a task
    Then the number of tasks hank created is 1
    And the task status is open

  Scenario: Create two todos
    Given there are no tasks registered
    When hank is asked to create a task
    And hank is asked to create a task
    Then the number of tasks hank created is 2
    And the task status is open
