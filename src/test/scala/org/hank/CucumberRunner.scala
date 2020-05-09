package org.hank

import io.cucumber.junit.{Cucumber, CucumberOptions}
import org.junit.runner.RunWith

@RunWith(classOf[Cucumber])
@CucumberOptions(
  features = Array("classpath:feature"),
  glue = Array("classpath:org.hank.step")
)
class CucumberRunner