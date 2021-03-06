package com.example.languapp;

import com.example.languapp.Models.Users;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.HEAD;
import retrofit2.http.HTTP;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface JSONPlaceHolderApi {


    @GET("/posts/{id}")
    Call<Users> getPostWithID(@Path("id") int id);

    @POST("/data")
    Call<Users> getData(@Body String mail);


    @POST("/addUser")
    Call<Users> postData(@Body Users data);

    @POST("/login")
    Call<String> login(@Body Users log);
}
