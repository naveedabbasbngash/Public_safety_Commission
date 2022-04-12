package com.example.publicsafetycommission;

import java.io.File;
import java.util.List;
import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface apiset
{
    @FormUrlEncoded
    @POST("complainant_complaints")
    Call<Responsemodel> showDetail(
            @Field("user_id") int user_id
    );

    @FormUrlEncoded
    @POST("profile_get")
    Call<pojo> showProfile(
            @Field("user_id") int user_id
    );

    @FormUrlEncoded
    @POST("complainant_registration")
    Call<Responsemodel> getregister(
            @Field("user_name") String user_name,
            @Field("user_contact") String user_contact,
            @Field("user_password") String user_password,
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
    @POST("complainant_profile_update")
    Call<Responsemodel> getUpdate(
            @Field("complainant_name") String complainantName,
            @Field("complainant_cnic") String com_cnic,
            @Field("complainant_gender") String gender,
            @Field("complainant_guardian_name") String guardian,
            @Field("complainant_email") String email,
            @Field("complainant_district_name") String complainantDistrict,
            @Field("complainant_council") String complainantCouncil,
            @Field("complainant_address") String address,
            @Field("complainant_contact") String contact,
            @Field("user_name") String username,
            @Field("user_id") int userid
    );

    @FormUrlEncoded
    @POST("login_complainant")
    Call<Responsemodel> getlogin(
            @Field("user_name") String user_name,
            @Field("user_password") String user_password
    );
    @Multipart
    @POST("complaint_register")
    Call<pojo> addComplaint(
            @Part MultipartBody.Part Attachment,
            @Part("district_id_fk") RequestBody user_district_id_fk,
            @Part("complaint_category_id_fk") RequestBody user_complaint_category_id_fk,
            @Part("complaint_detail") RequestBody user_complaint_detail,
            @Part("user_id") RequestBody user_id
    );

}
