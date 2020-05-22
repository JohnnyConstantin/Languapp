package com.example.languapp;

////////////////////////////////////////////////////////////////////////////////////////////////////
//
//                                      LANGUAPP
//  App for learning english using cards with words in case of finishing itacademy Samsung
//  Special thanks to Leonid Sergeevich Sheshukov
//
//  Database: Firebase google (maybe will move db and server to Spring lately)
//
// @Made by JohnnyConstantin
// Copying and posting the code in the public domain is prohibited
//
////////////////////////////////////////////////////////////////////////////////////////////////////

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.languapp.Models.Users;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Button btnSignIn, btnRegister;

    EditText Sign_mail, Sign_pass;
    RelativeLayout relative;
    private static final String BASE_URL = "https://languapp.herokuapp.com";
    private JSONPlaceHolderApi JSONPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnRegister = findViewById(R.id.btnRegister);

        relative = findViewById(R.id.root_element);

        Sign_mail = findViewById(R.id.mail);
        Sign_pass = findViewById(R.id.pass);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .addInterceptor(interceptor);

        Gson gs = new GsonBuilder().setLenient().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gs))
                .client(client.build())
                .build();

        JSONPlaceHolderApi = retrofit.create(JSONPlaceHolderApi.class);

        btnRegister.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ShowRegisterWindow();
        }
    });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Login();
        }
    });
    }


/////////////////////////////           Registration window            /////////////////////////////

private void ShowRegisterWindow() {
        AlertDialog.Builder  dialog = new AlertDialog.Builder(this);

////////////////////             Создание диалога с регистрацией             ///////////////////////

        dialog.setTitle("Регистрация");
        dialog.setMessage("Введите ваши данные для регистрации");

        LayoutInflater inflater = LayoutInflater.from(this);
        View register_window = inflater.inflate(R.layout.register_window, null);
        dialog.setView(register_window);

        final MaterialEditText email = register_window.findViewById(R.id.emailField);
        final MaterialEditText pass = register_window.findViewById(R.id.passField);
        final MaterialEditText name = register_window.findViewById(R.id.nameField);
        final MaterialEditText phone = register_window.findViewById(R.id.phoneField);

////////////////////////////         Диалоговое окно для регистрации        ////////////////////////

        dialog.setNegativeButton("Назад", new DialogInterface.OnClickListener() {

            ///////     Закрытие окна регистрации по нажатию кнопки "Назад"     ///////

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.dismiss();
            }
        });


        dialog.setPositiveButton("Зарегистрироваться", new DialogInterface.OnClickListener() {

            ///////   Регистрация успешная, если все условия ниже выполнены     ///////

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                if(TextUtils.isEmpty(email.getText().toString())){
                    Snackbar.make(relative, "Введите Ваш email", Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(name.getText().toString())){
                    Snackbar.make(relative, "Введите Ваше имя",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(pass.getText().toString().length() < 5){
                    Snackbar.make(relative, "Введите Ваш пароль (5 символов)",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(phone.getText().toString())){
                    Snackbar.make(relative, "Введите Ваш телефон",
                            Snackbar.LENGTH_SHORT).show();
                    return;
                }
////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////                      регистрируем пользователя в бд             ////////////////////
                Users user = new Users(email.getText().toString(),pass.getText().toString(),phone.getText().toString(),name.getText().toString());

                Call<Users> call = JSONPlaceHolderApi.postData(user);

                call.enqueue(new Callback<Users>() {
                    @Override
                    public void onResponse(Call<Users> call, Response<Users> response) {
                        System.out.println(response);
                    }

                    @Override
                    public void onFailure(Call<Users> call, Throwable t) {
                    }
                });
            }
        });
        dialog.show();
}

////////////////////////////////////////////////////////////////////////////////////////////////////




///////////////////////////////          Logging in              ///////////////////////////////////

    private void Login(){
        Users log = new Users(Sign_mail.getText().toString(), Sign_pass.getText().toString());
        Call<String> ask = JSONPlaceHolderApi.login(log);
        ask.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.body() == null){
                    Toast.makeText(MainActivity.this, "There is no such user. Check your mail and password",
                            Toast.LENGTH_LONG).show();
                }
                else if(response.body().equals("Login"))
                {
                    Call<Users> dataUser = JSONPlaceHolderApi.getData(Sign_mail.getText().toString());
                    dataUser.enqueue(new Callback<Users>() {
                        @Override
                        public void onResponse(Call<Users> call, Response<Users> response) {
                            try {
                                assert response.body() != null;
                                System.out.println(response.toString());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<Users> call, Throwable t) {
                        }
                    });
                    startActivity(new Intent(MainActivity.this, Home.class));
                    finish();
                }
                else if(response.body().equals("Mail"))
                {
                    Toast.makeText(MainActivity.this, "Incorrect email", Toast.LENGTH_LONG).show();
                } else{
                    Toast.makeText(MainActivity.this, "Incorrect password", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "Something went wrong, check your connection",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

////////////////////////////////////////////////////////////////////////////////////////////////////

}
