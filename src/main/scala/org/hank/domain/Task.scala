package org.hank.domain

import java.time.LocalDateTime
import java.util.UUID

import org.hank.domain.TaskStatus.TaskStatus

case class Task(id: UUID = UUID.randomUUID(),
                content: String,
                status: TaskStatus,
                dueDate: LocalDateTime)
