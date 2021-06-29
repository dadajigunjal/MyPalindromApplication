package com.android.mypalindromapplication.utils

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager


object PalindromeChecker {

    fun isPalindrome(input: String): Boolean {
        var head = 0
        var tail = input.length - 1
        while (head < tail) {
            if (input[head] != input[tail]) {
                return false
            }
            head++
            tail--
        }
        return true
    }

    fun hideKeyboard(context : Activity, view: View) {
        val imm: InputMethodManager = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }
}