package com.example.aula804.dao

import androidx.room.Dao
import androidx.room.Ignore
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE

import androidx.room.Query
import com.example.aula804.model.Person
import kotlinx.coroutines.flow.Flow


@Dao
interface PersonDao {

  @Query("SELECT * FROM person_table order by name")
  fun getOrderPeople(): Flow<List<Person>>

  @Insert(onConflict = IGNORE)
  fun insert(person: Person)

  @Query("Delete From person_table")
  suspend fun deleteAll()
}
