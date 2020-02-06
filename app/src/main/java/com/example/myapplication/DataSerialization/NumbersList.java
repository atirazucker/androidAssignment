package com.example.myapplication.DataSerialization;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

public class NumbersList {

    @Expose
    @SerializedName("numbers")
    private List<HashMap<String, Integer>> numbers;

    public List<HashMap<String, Integer>> getList() {
        return this.numbers;
    }
}


