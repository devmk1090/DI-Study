package com.devkproject.daggepractice.ui.auth

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.RequestManager
import com.devkproject.daggepractice.R
import com.devkproject.daggepractice.models.User
import com.devkproject.daggepractice.viewmodels.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity(), View.OnClickListener {

    private lateinit var viewModel: AuthViewModel

    @Inject
    lateinit var providerFactory: ViewModelProviderFactory

    @set: Inject
    var logo: Drawable? = null

    @Inject
    lateinit var requestManager: RequestManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        login_button.setOnClickListener (this)

        viewModel = ViewModelProvider(this, providerFactory).get(AuthViewModel::class.java)

        setLogo()

        subscribeObservers()
    }

    private fun subscribeObservers() {
        viewModel.observerUser().observe(this, Observer<User> { t ->
                if (t != null) {
                    Log.d("AuthActivity", "onChanged: ${t.email}")
                }
            })
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into(findViewById(R.id.login_logo))
    }

    override fun onClick(v: View?) {
        when(v!!.id) {
            R.id.login_button -> {
                attemptLogin()
            }
        }
    }

    private fun attemptLogin() {
        if(TextUtils.isEmpty(user_id_input.text.toString())) {
            return
        }
        viewModel.authenticateWithId(Integer.parseInt(user_id_input.text.toString()))
    }
}
