package com.android.mypalindromapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.mypalindromapplication.R
import com.android.mypalindromapplication.databinding.ActivityMainBinding
import com.android.mypalindromapplication.utils.PalindromeChecker
import com.android.mypalindromapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    lateinit var bindingMainActivity: ActivityMainBinding
    lateinit var userInputString: String
    lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initUI()
    }

    private fun initUI(){
        bindingMainActivity = setContentView(this, R.layout.activity_main)
        bindingMainActivity.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.uiTextLiveData.observe(this, Observer { it ->
            Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
            bindingMainActivity.textViewPalindrome.text = it.toString()
        })

        setupClickListeners()
    }

    private fun setupClickListeners() {
        bindingMainActivity.buttonCheckPalindrome.setOnClickListener{
            userInputString = bindingMainActivity.editTextPalindrome.text.toString()
            PalindromeChecker.hideKeyboard(this, bindingMainActivity.buttonCheckPalindrome)

            if (userInputString.trim().isNotEmpty()) {
                viewModel.checkPalindromeString(userInputString)
            }else{
                bindingMainActivity.textViewPalindrome.text = applicationContext.getString(R.string.palindrome_string)
                bindingMainActivity.editTextPalindrome.error = applicationContext.getString(R.string.error_enter_input)
                bindingMainActivity.editTextPalindrome.requestFocus()
                return@setOnClickListener
            }
        }
    }


}


