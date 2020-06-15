package com.devkproject.daggepractice.ui.auth;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.devkproject.daggepractice.models.User;
import com.devkproject.daggepractice.network.auth.AuthApi;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

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

//public class test<T> {
//
//    @NonNull
//    public final AuthStatus status;
//
//    @Nullable
//    public final T data;
//
//    @Nullable
//    public final String message;
//
//
//    public test(@NonNull AuthStatus status, @Nullable T data, @Nullable String message) {
//        this.status = status;
//        this.data = data;
//        this.message = message;
//    }
//
//    public static <T> test<T> authenticated (@Nullable T data) {
//        return new test<>(AuthStatus.AUTHENTICATED, data, null);
//    }
//
//    public static <T> test<T> error(@NonNull String msg, @Nullable T data) {
//        return new test<>(AuthStatus.ERROR, data, msg);
//    }
//
//    public static <T> test<T> loading(@Nullable T data) {
//        return new test<>(AuthStatus.LOADING, data, null);
//    }
//
//    public static <T> test<T> logout () {
//        return new test<>(AuthStatus.NOT_AUTHENTICATED, null, null);
//    }
//
//    public enum AuthStatus { AUTHENTICATED, ERROR, LOADING, NOT_AUTHENTICATED}
//}

//public class AuthViewModel extends ViewModel {
//
//    private static final String TAG = "AuthViewModel";
//
//    // inject
//    private final AuthApi authApi;
//
//    private MediatorLiveData<AuthResource<User>> authUser = new MediatorLiveData<>();
//
//    @Inject
//    public AuthViewModel(AuthApi authApi) {
//        this.authApi = authApi;
//        Log.d(TAG, "AuthViewModel: viewmodel is working...");
//    }
//
//    public void authenticateWithId(int userId){
//        authUser.setValue(AuthResource.loading((User)null));
//
//        final LiveData<AuthResource<User>> source = LiveDataReactiveStreams.fromPublisher(authApi.getUser(userId)
//
//                // instead of calling onError, do this
//                .onErrorReturn(new Function<Throwable, User>() {
//                    @Override
//                    public User apply(Throwable throwable) throws Exception {
//                        User errorUser = new User();
//                        errorUser.setId(-1);
//                        return errorUser;
//                    }
//                })
//
//                // wrap User object in AuthResource
//                .map(new Function<User, AuthResource<User>>() {
//                    @Override
//                    public AuthResource<User> apply(User user) throws Exception {
//                        if(user.getId() == -1){
//                            return AuthResource.error("Could not authenticate", null);
//                        }
//                        return AuthResource.authenticated(user);
//                    }
//                })
//                .subscribeOn(Schedulers.io()));
//
//        authUser.addSource(source, new Observer<AuthResource<User>>() {
//            @Override
//            public void onChanged(AuthResource<User> userAuthResource) {
//                authUser.setValue(userAuthResource);
//                authUser.removeSource(source);
//            }
//        });
//    }
//
//    public LiveData<AuthResource<User>> observeUser(){
//        return authUser;
//    }
//}
