package com.mvi.simple.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {

    val progressVisibility=MutableLiveData(false)
    val errorMessage=MutableLiveData<Throwable>()
    val loginBtnDisable=MutableLiveData(false)
    val userToken=MutableLiveData<UserToken>()


    fun Login(userName:String,pass:String){
          try {
              progressVisibility.value =true
            userToken.value= userLogin(UserCredentials(userName,pass))
              progressVisibility.value =false

          }catch (e:Exception){
              progressVisibility.value =false
              errorMessage.value=e
          }
    }


}