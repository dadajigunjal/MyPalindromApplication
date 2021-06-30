package com.android.mypalindromapplication

import com.android.mypalindromapplication.utils.PalindromeChecker
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test

class MainViewModelTest {

    companion object {
        @JvmStatic
        private lateinit var checker: PalindromeChecker

        @BeforeClass
        @JvmStatic
        fun init() {
            checker = PalindromeChecker
        }
    }

    @Test
    fun `check a palindrome string`(){
        Assert.assertEquals(true, checker.isPalindrome("madam"))
    }

    @Test
    fun `check a non-palindrome string`() {
        Assert.assertEquals(false, checker.isPalindrome("India"))
    }

    @Test
    fun `check a empty string`() {
        Assert.assertEquals(false, !checker.isPalindrome(""))
    }

}