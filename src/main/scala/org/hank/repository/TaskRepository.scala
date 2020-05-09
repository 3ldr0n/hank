package org.hank.repository

import org.hank.domain.Task

class TaskRepository {
  private var tasks: List[Task] = List()

  def save(task: Task): Unit = tasks = task :: tasks

  def findById(id: Long): Option[Task] = tasks.find(task => task.id == id)

  def findAll(): List[Task] = tasks
}
