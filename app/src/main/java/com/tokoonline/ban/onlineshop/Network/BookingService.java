package com.tokoonline.ban.onlineshop.Network;



import com.tokoonline.ban.onlineshop.Jenisproduk.data_item_spa;
import com.tokoonline.ban.onlineshop.Model.BookingResponse;
import com.tokoonline.ban.onlineshop.Model.Profile;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BookingService {

    @GET("api/product/ala_carte_treatment")
    Call<List<data_item_spa>> getAlaCarteTreatment();

    @GET("api/product/package_treatment")
    Call<List<data_item_spa>> getPackageTreatment();

//    @GET("api/busy")
//    Call<ResonWaktuFalse> dataWaktu();

    @POST("api/user/login")
    @FormUrlEncoded
    Call<BookingResponse> login(
            @Field("email") String email,
            @Field("password") String password,
            @Field("fcm_token") String token
    );
//    @FormUrlEncoded
//    @POST("api/user/signup")
//    Call<RegisterRespon> signup(
//            @Field("email") String email,
//            @Field("name") String name,
//            @Field("password") String password,
//            @Field("phone") String phone,
//            @Field("fcm_token") String token
//    );


    @FormUrlEncoded
    @POST("api/user")
    Call<Profile> userprofile(
            @Field("id") int id
    );


    @FormUrlEncoded
    @POST("api/user/phone")
    Call<BookingResponse> insertPhone(
            @Field("id") int userId,
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST("api/user/medsos")
    Call<BookingResponse> loginMedsos(
            @Field("name") String name,
            @Field("email") String email,
            @Field("provider") String provider,
            @Field("avatar") String avatar,
            @Field("fcm_token") String token
    );


    @FormUrlEncoded
    @POST("api/booking")
    Call<BookingResponse> booking(
            @Field("user_id") int userId,
            @Field("order") int order,
            @Field("date") String date

    );


    @FormUrlEncoded
    @POST("api/available-time")
    Call<BookingResponse> getAvailableTimeList(
            @Field("date") String date,
            @Field("ordername") String ordername
    );


    @FormUrlEncoded
    @POST("api/booking/history")
    Call<BookingResponse> getHistoryBookingList(
            @Field("user_id") int userId
    );

    @FormUrlEncoded
    @POST("api/refresh")
    Call<Void> refreshToken(
            @Field("id") int id,
            @Field("fcm_token") String token
    );

//    @FormUrlEncoded
//    @POST("api/inbox")
//    Call<ArrayList<NotificationModel>> getListNotification(
//            @Field("user_id") int userId
//    );
}
