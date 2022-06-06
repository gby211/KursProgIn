package com.example.kursprogin.ui.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kursprogin.data.room.dto.FavouriteDto
import com.example.kursprogin.ui.home.DataFromList
import kotlinx.coroutines.launch

class FavoriteViewModel : ViewModel() {

    private val _text = MutableLiveData<List<DataFromList>>().apply {
    }
    val text1: LiveData<List<DataFromList>> = _text


    suspend fun readDbRoom() {

        var tmp = mutableListOf<DataFromList>()
        var tmpDto = listOf<FavouriteDto>()
        viewModelScope.launch{
            tmpDto = dbbbb.getFavouriteDao().getSavedFavourites()
            for (i in tmpDto){
                tmp.add(DataFromList(i.imageUrl,i.nameDisk,i.id))
            }
            _text.value = tmp
        }
    }
}