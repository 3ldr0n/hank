package service

import domain.Data
import org.scalatest.FunSuite

class DataServiceTest extends FunSuite {

  test("Save and find data") {
    val dataService = new DataService()
    val data = Data(1L, "data")
    dataService.save(data)
    val dataFound = dataService.findById(data.id)

    assert(dataFound.get.id == data.id)
    assert(dataFound.get.content == data.content)
  }

  test("Try to find data not saved") {
    val dataService = new DataService()
    val data = Data(1L, "data")
    val dataFound = dataService.findById(data.id)

    assert(dataFound.isEmpty)
  }

}
