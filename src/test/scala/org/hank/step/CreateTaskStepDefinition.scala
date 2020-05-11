package org.hank.step

import io.cucumber.datatable.DataTable
import io.cucumber.scala.{EN, JacksonDefaultDataTableEntryTransformer, ScalaDsl}
import org.hank.entrypoint.TaskEntryPoint
import org.hank.vo.CreateTaskRequest

class CreateTaskStepDefinition extends ScalaDsl with EN with JacksonDefaultDataTableEntryTransformer {

  private val taskEntryPoint = new TaskEntryPoint()

  Given("""there are no tasks registered""") { () =>
    print("given")
  }

  Given("""there is one task created""") { () =>
    print("given")
  }

  When("""hank is asked to create a task""") { table: DataTable =>
    val request = dataTableToCreateTaskRequest(table)
    taskEntryPoint.createTask(request)
  }

  When("""hank is asked to create a task with an existing id""") { () =>
    val task = CreateTaskRequest("content", "2019/12/12 12:20:29")
    taskEntryPoint.createTask(task)
  }

  Then("""^the number of tasks hank created is (.*)$""") { numberOfTasks: Int =>

  }

  And("""^the task status is (.*)$""") { status: String =>
    print(status)
  }

  private def dataTableToCreateTaskRequest(table: DataTable) = {
    table.convert[CreateTaskRequest](classOf[CreateTaskRequest], false)
  }

}
