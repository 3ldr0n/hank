package org.hank.service

import java.time.LocalDateTime

import org.hank.domain.{Task, TaskStatus}
import org.hank.exception.AlreadySavedException
import org.scalatest.FunSuite

class TaskServiceTest extends FunSuite {
  test("Save and find task") {
    val taskService = new TaskService()
    val task = Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now())
    taskService.save(task)
    val taskFound = taskService.findById(task.id)

    assert(taskFound.get.id == task.id)
    assert(taskFound.get.content == task.content)
  }

  test("Try to save task with same id") {
    val taskService = new TaskService()
    val task = Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now())
    taskService.save(task)

    assertThrows[AlreadySavedException] {
      taskService.save(task)
    }

    val taskFound = taskService.findById(task.id)

    assert(taskFound.get.id == task.id)
    assert(taskFound.get.content == task.content)
  }

}
