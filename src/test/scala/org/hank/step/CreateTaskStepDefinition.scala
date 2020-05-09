package org.hank.step

import cucumber.api.scala.{EN, ScalaDsl}

class CreateTaskStepDefinition extends ScalaDsl with EN {

  Given("""there are no tasks registered""") { () =>
    print("given")
  }

  When("""hank is asked to create a task""") { () =>
    print("when")
  }

  Then("""^the number of tasks hank created is (.*)$""") { numberOfTasks: Int =>
    print(numberOfTasks)
  }

   And("""the task status is (.*)""") { status: String =>
    print(status)
  }

}
