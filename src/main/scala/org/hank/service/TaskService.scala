package org.hank.service

import java.util.UUID

import org.hank.domain.Task
import org.hank.exception.AlreadySavedException
import org.hank.repository.TaskRepository

class TaskService(
  private val taskRepository: TaskRepository = new TaskRepository()
) {

  def save(task: Task): Unit = {
    val maybeTask = taskRepository.findById(task.id)
    if (maybeTask.isDefined) {
      throw new AlreadySavedException()
    }
    taskRepository.save(task)
  }

  def findById(id: UUID): Option[Task] =
    taskRepository.findById(id)

  def removeAll(): Unit = taskRepository.removeAll()
}
