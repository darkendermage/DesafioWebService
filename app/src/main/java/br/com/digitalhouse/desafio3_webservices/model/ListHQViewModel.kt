package br.com.digitalhouse.desafio3_webservices.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.desafio3_webservices.comicsHQ.Result
import br.com.digitalhouse.desafio3_webservices.repository.Repository
import br.com.digitalhouse.desafio3_webservices.repository.repo
import kotlinx.coroutines.launch

class ListHQViewModel(repo: Repository) : ViewModel() {

    val listComics = MutableLiveData<List<Result>>()

    fun getListHQs(offset: Int) {
        viewModelScope.launch {
            listComics.value = repo.getAllHQRepo(offset).data.results
        }
    }

}