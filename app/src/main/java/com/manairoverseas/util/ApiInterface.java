package com.manairoverseas.util;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {

    @FormUrlEncoded
    @POST("login")
    Call<CandidateResponse> userLogin(@Field("applicationno") String ApplicationNumber,
                                   @Field("password") String Password);

    @FormUrlEncoded
    @POST("logout")
    Call<SignoutResponse> userLogOut(@Field("candidateid") String Candidateid);
}
