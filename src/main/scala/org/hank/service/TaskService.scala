package org.hank.service

import org.hank.domain.Task
import org.hank.exception.AlreadySavedException
import org.hank.repository.TaskRepository

class TaskService(
  private val taskRepository: TaskRepository = new TaskRepository()
) {

  def save(task: Task): Unit = {
    val taskOption = taskRepository.findById(task.id)
    if (taskOption.isDefined) {
      throw new AlreadySavedException()
    }
    taskRepository.save(task)
  }

  def findById(id: Long): Option[Task] =
    taskRepository.findById(id)
}
