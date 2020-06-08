package com.devkproject.daggepractice

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.RequestManager
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class AuthActivity : DaggerAppCompatActivity() {

    @set: Inject
    var logo: Drawable? = null

    @Inject
    lateinit var requestManager: RequestManager
//    @Inject
//    lateinit var testString: String
//
//    @set: Inject
//    var isAppNull: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        setLogo()
//        Log.d("TEST", "onCreate: $testString")
//        Log.d("TEST", "onCreate: is app null? $isAppNull" )
    }

    private fun setLogo() {
        requestManager
            .load(logo)
            .into(findViewById(R.id.login_logo))
    }
}
