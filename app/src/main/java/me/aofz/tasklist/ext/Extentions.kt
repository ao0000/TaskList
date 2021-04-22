package me.aofz.tasklist.ext

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard() }
}

fun Activity.hideKeyboard(): Unit = hideKeyboard(currentFocus ?: View(this))

fun Context.hideKeyboard(view: View) {
    val inputMethodManager: InputMethodManager =
        getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}