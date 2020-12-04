package br.com.digitalhouse.desafio3_webservices.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.digitalhouse.desafio3_webservices.comicsHQ.Result
import br.com.digitalhouse.desafio3_webservices.repository.Service
import br.com.digitalhouse.desafio3_webservices.repository.serv
import kotlinx.coroutines.launch

class ListHQViewModel(serv: Service) : ViewModel() {

    val listComics = MutableLiveData<List<Result>>()

    fun getListHQs(offset: Int) {
        viewModelScope.launch {
            listComics.value = serv.getAllHQRepo(offset).data.results
        }
    }

}