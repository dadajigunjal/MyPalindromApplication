package com.android.mypalindromapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mypalindromapplication.model.DataModel
import com.android.mypalindromapplication.utils.PalindromeChecker


class MainViewModel: ViewModel() {

    private val model = DataModel(textForUI = "Palindrome Status!")
    val uiTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainActivity
    fun checkPalindromeString(inputString: String) {
        var updatedMsgStr: String = this.model.textForUI
        if (PalindromeChecker.isPalindrome(inputString)){
            updatedMsgStr = "The input string is palindrome..!"
        }else{
            updatedMsgStr = "The input string is not palindrome..!"
        }
        uiTextLiveData.postValue(updatedMsgStr)
    }
}