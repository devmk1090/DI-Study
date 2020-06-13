//package com.devkproject.daggepractice.ui.auth;
//
//import android.util.Log;
//
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.LiveDataReactiveStreams;
//import androidx.lifecycle.MediatorLiveData;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModel;
//
//import com.devkproject.daggepractice.models.User;
//import com.devkproject.daggepractice.network.auth.AuthApi;
//
//import javax.inject.Inject;
//
//import io.reactivex.schedulers.Schedulers;
//
//public class test extends ViewModel {
//    private static final String TAG = "AuthViewModel";
//
//    private final AuthApi authApi;
//
//    private MediatorLiveData<User> authUser = new MediatorLiveData<>();
//
//    @Inject
//    public test(AuthApi authApi, AuthApi authApi1) {
//        this.authApi = authApi1;
//        Log.d(TAG, "AuthViewModel: viewmodel is working");
//    }
//
//    public void authenticateWithId(int userId) {
//        final LiveData<User> source = LiveDataReactiveStreams.fromPublisher(
//                authApi.getUser(userId)
//                .subscribeOn(Schedulers.io())
//        );
//        authUser.addSource(source, new Observer<User>() {
//            @Override
//            public void onChanged(User user) {
//                authUser.setValue(user);
//                authUser.removeSource(source);
//            }
//        });
//    }
//
//    public LiveData<User> observerUser() {
//        return authUser;
//    }
//}
