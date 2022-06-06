package com.example.kursprogin.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kursprogin.myRef
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener


class HomeViewModel : ViewModel() {


    private val _text = MutableLiveData<List<DataFromList>>().apply {
        value = listOf<DataFromList>(DataFromList("https://firebasestorage.googleapis.com/v0/b/kursovaia-f942a.appspot.com/o/1.1.jpg?alt=media&token=1fb6724e-2bb9-415f-b7af-0be0ffd9d2e6","sdasd",1))
    }
    val text1: LiveData<List<DataFromList>> = _text


    fun readDb(){

        val tmp = mutableListOf<DataFromList>()
        myRef.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val disksCount = dataSnapshot.child("Disk").children
                for (i in disksCount){
                    Log.d("TAG1","${i.child("firstUrl").value.toString()} ${ i.child("Name").value.toString()} ${ i.key.toString().toInt()}")
                    tmp.add(DataFromList(i.child("firstUrl").value.toString(),i.child("Name").value.toString(),i.key.toString().toInt()))
                }
                Log.d("TAG1", "Value is: ${tmp.toString()}")
                _text.value = tmp
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value
                Log.w("TAG1", "Failed to read value.", error.toException())
            }
        })
        _text.value = tmp
    }

}