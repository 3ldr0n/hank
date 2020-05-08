package repository

import domain.Data
import org.scalatest.FunSuite

class DataRepositoryTest extends FunSuite {

  test("Save and find data") {
    val dataRepository = new DataRepository()
    val data = Data(1L, "data")
    dataRepository.save(data)
    val dataFound = dataRepository.findById(data.id)

    assert(dataFound.get.id == data.id)
    assert(dataFound.get.content == data.content)
  }

  test("Try to find data not saved") {
    val dataRepository = new DataRepository()
    val data = Data(1L, "data")
    val dataFound = dataRepository.findById(data.id)

    assert(dataFound.isEmpty)
  }

  test("Find all data") {
    val dataRepository = new DataRepository()
    dataRepository.save(Data(1L, "data1"))
    dataRepository.save(Data(2L, "data2"))
    val dataFound = dataRepository.findAll()

    assert(dataFound.size == 2)
  }

  test("Find all data without any data") {
    val dataRepository = new DataRepository()

    val dataFound = dataRepository.findAll()

    assert(dataFound.isEmpty)
  }

}
