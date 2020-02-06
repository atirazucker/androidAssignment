package com.example.myapplication.Retrofit;

import com.example.myapplication.DataSerialization.NumbersList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitApi {

    @GET("raw/8wJzytQX")
    Call<NumbersList> getNumbersData();
}
