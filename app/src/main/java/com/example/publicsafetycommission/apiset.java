package com.example.publicsafetycommission;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface apiset
{
    @FormUrlEncoded
    @POST("complainant_registration")
    Call<responsemodel> getregister(
            @Field("user_name") String user_name,
            @Field("user_contact") String user_contact,
            @Field("user_password") String user_password,
            @Field("user_role_id_fk") String user_role_id_fk,
            @Field("user_status") String user_status,
            @Field("complainant_district_id_fk") String complainant_district_id_fk,
            @Field("complainant_email") String complainant_email,
            @Field("complainant_name") String complainant_name,
            @Field("complainant_address") String complainant_address,
            @Field("complainant_council") String complainant_council,
            @Field("complainant_guardian_name") String complainant_guardian_name,
            @Field("complainant_cnic") String complainant_cnic,
            @Field("complainant_gender") String complainant_gender
    );
    @FormUrlEncoded
    @POST("login_complainant")
    Call<responsemodel> getlogin(
            @Field("user_name") String user_name,
            @Field("user_password") String user_password
    );
    @FormUrlEncoded
    @POST("complaint_register")
    Call<responsemodel> getcompRegister(
            @Field("complaint_category_id_fk") String user_complaint_category_id_fk,
            @Field("complaint_detail") String user_complaint_detail,
            @Field("district_id_fk") String user_district_id_fk,
            @Field("complaint_council") String user_status,
            @Field("token") String user_token
    );

}
