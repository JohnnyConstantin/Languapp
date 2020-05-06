package com.example.languapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.languapp.Adapter.MyAdapter;
import com.example.languapp.R;

public class TestsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Fragment ", "Если ты видишь эту надпись, значит я работаю");

        View v = inflater.inflate(R.layout.fragment_tests, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view);

        MyAdapter listAdapter = new MyAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        return v;
    }
}
