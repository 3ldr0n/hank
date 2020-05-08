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

  test("Find all data") {
    val dataService = new DataService()
    dataService.save(Data(1L, "data1"))
    dataService.save(Data(2L, "data2"))
    val dataFound = dataService.findAll()

    assert(dataFound.size == 2)
  }

  test("Find all data without any data") {
    val dataService = new DataService()

    val dataFound = dataService.findAll()

    assert(dataFound.isEmpty)
  }

}
