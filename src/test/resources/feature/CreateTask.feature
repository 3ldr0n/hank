Feature: Create task

  Scenario: Create first task
    Given there are no tasks registered
    When hank is asked to create a task
      | content | dueDate             |
      | task    | 2020/12/04 12:00:00 |
    Then the number of tasks hank created is 1
    And the task status is open

  Scenario: Create two tasks
    Given there are no tasks registered
    When hank is asked to create a task
      | content | dueDate             |
      | task 1  | 2020/12/04 12:00:00 |
    And hank is asked to create a task
      | content | dueDate             |
      | task 2  | 2020/12/04 12:00:00 |
    Then the number of tasks hank created is 2
    And the task status is open

  Scenario: Create task with existing id
    Given there is one task created
    When hank is asked to create a task with an existing id
    Then the number of tasks hank created is 0
