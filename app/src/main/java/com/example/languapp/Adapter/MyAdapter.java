package com.example.languapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.languapp.R;

public class MyAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

    @Override
    public int getItemCount() {
        return Data.title.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView Title, Description;

        public ListViewHolder(View itemView) {
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.title);
            Description = (TextView) itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }

        public void bindView(int position){
            Title.setText(Data.title[position]);
            Description.setText(Data.description[position]);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
