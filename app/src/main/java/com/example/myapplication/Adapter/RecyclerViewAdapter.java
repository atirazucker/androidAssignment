package com.example.myapplication.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static int EQUAL_ZERO_VIEW_TYPE = 1;
    private static int NOT_EQUAL_ZERO_VIEW_TYPE = 2;
    private List<Integer> equalZeroList;
    private List<Integer> notEqualZeroList;

    @Override
    public int getItemCount() {
        if (equalZeroList != null && notEqualZeroList != null &&
                equalZeroList.size() > 0 && notEqualZeroList.size() > 0) {
            return 2;
        } else {
            return 0;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return EQUAL_ZERO_VIEW_TYPE;
        } else {
            return NOT_EQUAL_ZERO_VIEW_TYPE;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == EQUAL_ZERO_VIEW_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.equal_zero_item, parent, false);
            return new RecyclerViewHolder(view);
        } else if (viewType == NOT_EQUAL_ZERO_VIEW_TYPE) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.not_equal_zero_item, parent, false);
            return new RecyclerViewHolder2(view);
        } else {
            return null;
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position == 0) {
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) holder;
            recyclerViewHolder.textView.setText(equalZeroList.toString());
        } else if (position == 1) {
            RecyclerViewHolder2 recyclerHolder = (RecyclerViewHolder2) holder;
            recyclerHolder.textView.setText(notEqualZeroList.toString());
        }
    }

    public void setData(List<Integer> equalZeroList, List<Integer> notEqualZeroList) {
        this.equalZeroList = equalZeroList;
        this.notEqualZeroList = notEqualZeroList;
        notifyDataSetChanged();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.retrofit_test_view);
        }
    }

    class RecyclerViewHolder2 extends RecyclerView.ViewHolder {

        TextView textView;

        RecyclerViewHolder2(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.retrofit_test_view);
        }
    }
}
