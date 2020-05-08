package service

import domain.Data
import exception.AlreadySavedException
import repository.DataRepository

class DataService {
  private val dataRepository = new DataRepository()

  def save(data: Data): Unit = {
    val dataOption = dataRepository.findById(data.id)
    if (dataOption.isDefined) {
      throw new AlreadySavedException()
    }
    dataRepository.save(data)
  }

  def findById(id: Long): Option[Data] =
    dataRepository.findById(id)
}
