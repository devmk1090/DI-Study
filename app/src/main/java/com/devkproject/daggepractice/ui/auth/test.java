//package com.devkproject.daggepractice.ui.auth;
//
//import android.util.Log;
//
//import androidx.lifecycle.ViewModel;
//
//import com.devkproject.daggepractice.network.auth.AuthApi;
//
//import javax.inject.Inject;
//
//public class test extends ViewModel {
//    private static final String TAG = "AuthViewModel";
//
//    private final AuthApi authApi;
//
//    @Inject
//    public test(AuthApi authApi, AuthApi authApi1) {
//        this.authApi = authApi1;
//        Log.d(TAG, "AuthViewModel: viewmodel is working");
//
//        if(this.authApi == null) {
//            Log.d(TAG, "AuthViewModel: auth api is NULL");
//        }
//        else {
//            Log.d(TAG, "AuthViewModel: auth api is NOT NULL");
//
//        }
//    }
//}
