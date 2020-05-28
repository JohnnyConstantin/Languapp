package com.example.languapp.Fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.languapp.Adapter.MyAdapterTest;
import com.example.languapp.R;

public class TestsFragment extends Fragment implements View.OnClickListener {
    EditText test;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Fragment Tests", "Если ты видишь эту надпись, значит я работаю");

        View v = inflater.inflate(R.layout.fragment_tests, container, false);

////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////  Создание адаптера и подвязка его к этому фрагменту     //////////////////
///////////                                                                              ///////////
///////////             my_recycler_view - id контейнера в fragment_tests.xml            ///////////


        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.my_recycler_view_test);

        MyAdapterTest listAdapter = new MyAdapterTest();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        Button butt = (Button) v.findViewById(R.id.Check);

        butt.setOnClickListener(this);

////////////////////////////////////////////////////////////////////////////////////////////////////

        return v;
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(getActivity(), "Пока в разработке", Toast.LENGTH_LONG).show();
    }
}
