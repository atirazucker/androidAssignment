package com.example.myapplication.Network;

import com.example.myapplication.DataSerialization.NumbersList;
import com.example.myapplication.Retrofit.RetrofitApi;
import com.example.myapplication.Retrofit.RetrofitData;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkService implements NetworkCallsInterface {

    public void fetchNumbersList(final NetworkInterface callback) {
        RetrofitApi retrofitApi = RetrofitData.getRetrofit().create(RetrofitApi.class);

        Call<NumbersList> call = retrofitApi.getNumbersData();

        call.enqueue(new Callback<NumbersList>() {
            @Override
            public void onResponse(Call<NumbersList> call, Response<NumbersList> response) {

                NumbersList list = response.body();
                callback.onSuccess(list);
            }

            @Override
            public void onFailure(Call<NumbersList> call, Throwable t) {
                callback.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
