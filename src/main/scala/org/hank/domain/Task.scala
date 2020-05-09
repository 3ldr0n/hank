package org.hank.domain

import java.time.LocalDateTime

import org.hank.domain.TaskStatus.TaskStatus

case class Task(id: Long,
                content: String,
                status: TaskStatus,
                dueDate: LocalDateTime)
