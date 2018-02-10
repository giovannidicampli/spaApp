package com.vanni.spaApp.api;

import com.vanni.spaApp.results.ResultAccesso;
import com.vanni.spaApp.results.ResultOfferta;
import com.vanni.spaApp.results.ResultOfferte;
import com.vanni.spaApp.results.ResultRegistrazione;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface APIService {

    @FormUrlEncoded
    @POST("utente/accesso")
    Call<ResultAccesso> accessoUtente(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("utente/registrazione")
    Call<ResultRegistrazione> registrazioneUtente(@Field("nome") String nome, @Field("cognome") String cognome, @Field("username") String username, @Field("email") String email, @Field("password") String password);

    @GET("offerte")
    Call<ResultOfferte> getOfferte();

    @GET("offerta/{nome}")
    Call<ResultOfferta> getOfferta(@Path("nome") String nome);


}
