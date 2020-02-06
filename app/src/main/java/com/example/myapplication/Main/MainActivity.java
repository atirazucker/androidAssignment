package com.example.myapplication.Main;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.Adapter.RecyclerViewAdapter;
import com.example.myapplication.DataSerialization.NumbersList;
import com.example.myapplication.Network.NetworkCallsInterface;
import com.example.myapplication.Network.NetworkInterface;
import com.example.myapplication.Network.NetworkService;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NetworkInterface {
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.my_recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(adapter);

        NetworkCallsInterface networkCallsInterface = new NetworkService();
        networkCallsInterface.fetchNumbersList(this);
    }

    @Override
    public void onSuccess(NumbersList numbersList) {
        List<Integer> joinedList = new ArrayList<>();
        List<Integer> equalZeroList = new ArrayList<>();
        List<Integer> notEqualZeroList = new ArrayList<>();

        for (HashMap<String, Integer> map : numbersList.getList()) {
            Integer number = map.get("number");
            joinedList.add(number);
        }

        while (joinedList.size() > 0) {
            Integer number = joinedList.get(0);

            if (number < 0) {
                Integer oppositeNumber = Math.abs(number);

                if (joinedList.contains(oppositeNumber)) {
                    equalZeroList.add(number);
                    equalZeroList.add(oppositeNumber);
                    joinedList.remove(oppositeNumber);
                } else {
                    notEqualZeroList.add(number);
                }
            } else {
                notEqualZeroList.add(number);
            }
            joinedList.remove(number);
        }

        adapter.setData(equalZeroList, notEqualZeroList);
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
