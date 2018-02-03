package com.vanni.spaApp.api;

import com.vanni.spaApp.results.ResultAccesso;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

//import com.peppe.popapp.results.ResultBiglietti;
//import com.peppe.popapp.results.ResultFilm;
//import com.peppe.popapp.results.ResultProgrammazione;
//import com.peppe.popapp.results.ResultRegistrazione;
//import com.peppe.popapp.results.ResultSale;

public interface APIService {

    @FormUrlEncoded
    @POST("utente/accesso")
    Call<ResultAccesso> accessoUtente(@Field("username") String username, @Field("password") String password);

//    @FormUrlEncoded //annotation
//    @POST("utente/registrazione")
//    Call<ResultRegistrazione> registrazioneUtente(@Field("username") String username, @Field("email") String email, @Field("password") String password, @Field("token") String token);
//
//    @GET("programmazione")
//    Call<ResultProgrammazione> getProgrammazione();
//
//    @GET("programmazione/{titolo_film}")
//    Call<ResultFilm> getFilm(@Path("titolo_film") String titolo);
//
//    @GET("info/sale")
//    Call<ResultSale> getSale();
//
//    @GET("info/prezzi")
//    Call<ResultBiglietti> getPrezzi();


}
