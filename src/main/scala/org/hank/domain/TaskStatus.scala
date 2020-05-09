package org.hank.domain

object TaskStatus extends Enumeration {
  type TaskStatus = Value
  val CANCELLED, OPEN, DONE, IN_PROGRESS = Value
}
