package com.example.languapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.languapp.R;

public class MyAdapter extends RecyclerView.Adapter {


////////////////////////////////////   Отрисовка фрагмента     /////////////////////////////////////
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)  {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent,
                false);
        return new ListViewHolder(view);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder) holder).bindView(position);
    }

////////////////////////////////   Количество создаваемых карточек     /////////////////////////////
////////////////////             Зависит от количества Title-ов в Data           ///////////////////
    @Override
    public int getItemCount() {
        return Data.title.length;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////



    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView Title, word, word1, word2, word3, word4, description, description1,
                description2, description3, description4;


////////////////////////////////  Ищем по id куда записывать Data     //////////////////////////////

        public ListViewHolder(View itemView) {
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.title);

            word = (TextView) itemView.findViewById(R.id.word);
            word1 = (TextView) itemView.findViewById(R.id.word1);
            word2 = (TextView) itemView.findViewById(R.id.word2);
            word3 = (TextView) itemView.findViewById(R.id.word3);
            word4 = (TextView) itemView.findViewById(R.id.word4);

            description = (TextView) itemView.findViewById(R.id.description);
            description1 = (TextView) itemView.findViewById(R.id.description1);
            description2 = (TextView) itemView.findViewById(R.id.description2);
            description3 = (TextView) itemView.findViewById(R.id.description3);
            description4 = (TextView) itemView.findViewById(R.id.description4);

            itemView.setOnClickListener(this);
        }
////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////  Цепляем из Data Titlе, слова и перевод этих слов    /////////////////////

        public void bindView(int position){
            Title.setText(Data.title[position]);

            word.setText(Data.words[position]);
            word1.setText(Data.words[position+1]);
            word2.setText(Data.words[position+2]);
            word3.setText(Data.words[position+3]);
            word4.setText(Data.words[position+4]);

            description.setText(Data.descriptions[position]);
            description1.setText(Data.descriptions[position+1]);
            description2.setText(Data.descriptions[position+2]);
            description3.setText(Data.descriptions[position+3]);
            description4.setText(Data.descriptions[position+4]);
        }

////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////    На OnClick стоит заглушка, но без него нельзя,    /////////////////////
/////////           иначе компилятор ругается, т.к наследуемся от интерфейса                 ///////

        @Override
        public void onClick(View v) {
        }
////////////////////////////////////////////////////////////////////////////////////////////////////

    }
}
