package com.buddhabhushan.b.mobisysassignment.app;

import android.app.Application;
import android.content.Context;

import com.buddhabhushan.b.mobisysassignment.data.api.APIInterface;
import com.buddhabhushan.b.mobisysassignment.domain.Constants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Buddhabhushan on 17-Sep-17.
 */

public class MoviesApp extends Application {

    private static MoviesApp INSTANCE;
    private static Context CONTEXT;

    public void onCreate() {
        super.onCreate();

        MoviesApp.CONTEXT = getApplicationContext();
    }

    public static Context getContext() {
        return MoviesApp.CONTEXT;
    }

    public static MoviesApp getInstance() {
        if (INSTANCE == null) {
            return INSTANCE = new MoviesApp();
        }
        return INSTANCE;
    }

    Retrofit getRetrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();

        return new Retrofit.Builder()
                .baseUrl(Constants.URL_BASE)
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public APIInterface getApiInterface() {
        return getRetrofit().create(APIInterface.class);
    }
}
