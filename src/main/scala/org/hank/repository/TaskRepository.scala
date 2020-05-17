package org.hank.repository

import java.util.UUID

import org.hank.domain.Task

import scala.collection.mutable.ListBuffer

class TaskRepository {
  private val tasks: ListBuffer[Task] = ListBuffer()

  def save(task: Task): Unit = tasks.addOne(task)

  def findById(id: UUID): Option[Task] = tasks.find(task => task.id == id)

  def findAll(): List[Task] = tasks.result()

  def removeAll(): Unit = tasks.clear()
}
