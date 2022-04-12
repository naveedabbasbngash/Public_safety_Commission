package com.example.publicsafetycommission;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class apiController
{
    private static final String url="https://ppsc.kp.gov.pk/Api_intern/";
    private static apiController clientobject;
    private static Retrofit retrofit;

    apiController()
    {


        retrofit=new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    Gson gson = new GsonBuilder().setLenient().create();

    public static synchronized apiController getInstance()
    {
        if(clientobject==null)
            clientobject=new apiController();
        return clientobject;
    }

    apiset getapi()
    {

        return retrofit.create(apiset.class);
    }
}
