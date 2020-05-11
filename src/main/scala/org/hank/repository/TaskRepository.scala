package org.hank.repository

import java.util.UUID

import org.hank.domain.Task

class TaskRepository {
  private var tasks: List[Task] = List()

  def save(task: Task): Unit = tasks = task :: tasks

  def findById(id: UUID): Option[Task] = tasks.find(task => task.id == id)

  def findAll(): List[Task] = tasks
}
