package com.example.aula804.viewModel

import androidx.lifecycle.*
import com.example.aula804.model.Person
import com.example.aula804.repositorio.PersonRepositotio
import kotlinx.coroutines.launch

class PersonViewModel(private val repositotio: PersonRepositotio) : ViewModel() {

  val allPeople: LiveData<List<Person>> = repositotio.allPeople.asLiveData()

  fun insert(person: Person) = viewModelScope.launch {
    repositotio.insert(person)
  }
}

class PersonViewModelFactory(private val repositotio: PersonRepositotio) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): PersonViewModel {
    if (modelClass.isAssignableFrom(PersonViewModel::class.java)) {
      @Suppress("UNCHEKED_CAST")
      return PersonViewModel(repositotio)
    }
    throw IllegalAccessException("Unknow view model class")
  }

}
