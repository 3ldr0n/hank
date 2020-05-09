package org.hank

import java.time.LocalDateTime

import org.hank.domain.{Task, TaskStatus}

object HankApplication {
  def main(args: Array[String]): Unit = {
    val task = Task(1L, "content", TaskStatus.OPEN, LocalDateTime.now())
    print(task)
  }
}
