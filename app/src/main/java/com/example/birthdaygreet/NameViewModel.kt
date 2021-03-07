package com.example.birthdaygreet

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel : ViewModel() {


    private val _name = MutableLiveData<String>()
    var name :LiveData<String> = _name

    fun hasNoNameSet():Boolean {
        return _name.value.isNullOrEmpty()
    }

     fun setName(nameInput:String){
        _name.value = nameInput
    }

}