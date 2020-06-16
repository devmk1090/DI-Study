package com.devkproject.daggepractice

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import com.devkproject.daggepractice.ui.auth.AuthActivity
import com.devkproject.daggepractice.ui.auth.AuthResource
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    companion object {
        const val TAG = "BaseActivity"
    }

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        subscribeObservers()

    }

    private fun subscribeObservers() {
        sessionManager.getAuthUser().observe(this, Observer {
            if (it != null) {
                when (it.status) {
                    AuthResource.AuthStatus.LOADING -> {

                    }
                    AuthResource.AuthStatus.AUTHENTICATED -> {
                        Log.d(TAG, "onChanged: LOGIN SUCCESS: ${it.data!!.email}")
                    }
                    AuthResource.AuthStatus.ERROR -> {
                        Log.d(TAG, "onChanged: ${it.message}")
                    }
                    AuthResource.AuthStatus.NOT_AUTHENTICATED -> {
                        navigateToLoginScreen()
                    }
                }
            }
        })
    }

    private fun navigateToLoginScreen() {
        intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)
    }
}
