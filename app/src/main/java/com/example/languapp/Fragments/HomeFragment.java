package com.example.languapp.Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import com.example.languapp.R;
import com.squareup.picasso.Picasso;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class HomeFragment extends Fragment implements View.OnClickListener{

    final static int GALLERY_RES = 1;
    Button btn;
    ImageView imageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       View v = inflater.inflate(R.layout.fragment_home, container, false);

       btn = (Button) v.findViewById(R.id.add);
       imageView = (ImageView) v.findViewById(R.id.profile_image);

       btn.setOnClickListener(this);
       return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        /////// Функция вытаскивания фото из галлереи и засовывания его в Im view ///////

        Bitmap bitmap = null;

        switch (requestCode) {
            case GALLERY_RES:
                if(resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    try{
                        bitmap = MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }

    @Override
    public void onClick(View v) {

        /////// Отправляем интент в галлерею ///////

        //Toast.makeText(getActivity(), "Проверка", Toast.LENGTH_SHORT).show();
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, GALLERY_RES);
    }
}