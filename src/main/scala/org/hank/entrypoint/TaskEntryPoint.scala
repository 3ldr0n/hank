package org.hank.entrypoint

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

import org.hank.domain.{Task, TaskStatus}
import org.hank.service.TaskService
import org.hank.vo.CreateTaskRequest

class TaskEntryPoint(
  private val taskService: TaskService = new TaskService()
) {
  private val format = DateTimeFormatter.ofPattern("yyyy/MM/d HH:mm:ss", Locale.US)

  def createTask(createTaskRequest: CreateTaskRequest): Unit = {
    val date = LocalDateTime.parse(createTaskRequest.dueDate, format)
    val task = Task(content = createTaskRequest.content, status = TaskStatus.OPEN, dueDate = date)
    taskService.save(task)
  }

  def findTask(task: Task): Option[Task] = {
    taskService.findById(task.id)
  }

}
