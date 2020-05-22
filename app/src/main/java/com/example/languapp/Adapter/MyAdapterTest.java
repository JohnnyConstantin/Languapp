package com.example.languapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.languapp.R;

public class MyAdapterTest extends RecyclerView.Adapter {


    ////////////////////////////////////   Отрисовка фрагмента     /////////////////////////////////////
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_test, parent,
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

        private TextView Title, word, word1, word2, word3, word4;
        private EditText editText, editText1, editText2, editText3, editText4;


////////////////////////////////  Ищем по id куда записывать Data     //////////////////////////////

        public ListViewHolder(View itemView) {
            super(itemView);

            Title = (TextView) itemView.findViewById(R.id.title);

            word = (TextView) itemView.findViewById(R.id.word);
            word1 = (TextView) itemView.findViewById(R.id.word1);
            word2 = (TextView) itemView.findViewById(R.id.word2);
            word3 = (TextView) itemView.findViewById(R.id.word3);
            word4 = (TextView) itemView.findViewById(R.id.word4);

            editText = (EditText) itemView.findViewById(R.id.editText);
            editText1 = (EditText) itemView.findViewById(R.id.editText2);
            editText2 = (EditText) itemView.findViewById(R.id.editText3);
            editText3 = (EditText) itemView.findViewById(R.id.editText4);
            editText4 = (EditText) itemView.findViewById(R.id.editText5);

            itemView.setOnClickListener(this);
        }
////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////  Цепляем из Data Titlе и слова    /////////////////////

        public void bindView(int position) {
            Title.setText(Data.titleTests[position]);

            word.setText(Data.tests[position]);
            word1.setText(Data.tests[position + 1]);
            word2.setText(Data.tests[position + 2]);
            word3.setText(Data.tests[position + 3]);
            word4.setText(Data.tests[position + 4]);
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
