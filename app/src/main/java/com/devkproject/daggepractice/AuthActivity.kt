package com.devkproject.daggepractice

import android.os.Bundle
import android.util.Log
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var testString: String

    @set: Inject
    var isAppNull: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)
        Log.d("TEST", "onCreate: $testString")
        Log.d("TEST", "onCreate: is app null? $isAppNull" )
    }
}
