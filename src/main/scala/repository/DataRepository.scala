package repository

import domain.Data

class DataRepository {
  private var dataList: List[Data] = List()

  def save(data: Data): Unit = dataList = dataList.appended(data)

  def findById(id: Long): Option[Data] = dataList.find(data => data.id == id)

  def findAll(): List[Data] = dataList
}
