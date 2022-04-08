package com.example.aula804.repositorio

import androidx.annotation.WorkerThread
import com.example.aula804.dao.PersonDao
import com.example.aula804.model.Person
import kotlinx.coroutines.flow.Flow

class PersonRepositotio(private val personDao: PersonDao) {

  val allPeople: Flow<List<Person>> = personDao.getOrderPeople()

  @Suppress("RedudantSuspendModifier")
  @WorkerThread
  suspend fun insert(person: Person) {
    personDao.insert(person)
  }
}
