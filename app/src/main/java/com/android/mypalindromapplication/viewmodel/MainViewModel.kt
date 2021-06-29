package com.android.mypalindromapplication.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.mypalindromapplication.R
import com.android.mypalindromapplication.model.DataModel
import com.android.mypalindromapplication.utils.PalindromeChecker


class MainViewModel: ViewModel() {

    private val model = DataModel(textForUI = "Palindrome Status!")
    val uiTextLiveData = MutableLiveData<String>()

    // Get the updated text from our model and post the value to MainActivity
    fun checkPalindromeString(context: Context, inputString: String) {
        var updatedMsgStr: String = this.model.textForUI
        if (PalindromeChecker.isPalindrome(inputString)){
            updatedMsgStr = context.getString(R.string.input_is_palindrom)
        }else{
            updatedMsgStr = context.getString(R.string.input_is_not_palindrom)
        }
        uiTextLiveData.postValue(updatedMsgStr)
    }
}