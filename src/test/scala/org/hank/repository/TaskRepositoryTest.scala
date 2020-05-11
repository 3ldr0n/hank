package org.hank.repository

import java.time.LocalDateTime

import org.hank.domain.{Task, TaskStatus}
import org.scalatest.FunSuite

class TaskRepositoryTest extends FunSuite {

  test("Save and find task") {
    val taskRepository = new TaskRepository()
    val task = Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now())
    taskRepository.save(task)
    val taskFound = taskRepository.findById(task.id)

    assert(taskFound.get.id == task.id)
    assert(taskFound.get.content == task.content)
  }

  test("Try to find task not saved") {
    val taskRepository = new TaskRepository()
    val task = Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now())
    val taskFound = taskRepository.findById(task.id)

    assert(taskFound.isEmpty)
  }

  test("Find all tasks") {
    val taskRepository = new TaskRepository()
    taskRepository.save(Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now()))
    taskRepository.save(Task(content = "task", status = TaskStatus.OPEN, dueDate = LocalDateTime.now()))
    val tasksFound = taskRepository.findAll()

    assert(tasksFound.size == 2)
  }

  test("Find all tasks without any tasks") {
    val taskRepository = new TaskRepository()

    val tasksFound = taskRepository.findAll()

    assert(tasksFound.isEmpty)
  }

}
