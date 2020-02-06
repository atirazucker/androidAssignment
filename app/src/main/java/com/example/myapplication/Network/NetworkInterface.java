package com.example.myapplication.Network;

import com.example.myapplication.DataSerialization.NumbersList;

public interface NetworkInterface {
    void onSuccess(NumbersList numbersList);

    void onFailure(String error);
}

