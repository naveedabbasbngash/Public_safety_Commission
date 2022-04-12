
package com.example.publicsafetycommission;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class pojo {

    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    @SerializedName("user_profile")
    @Expose
    private UserProfile userProfile;
    public pojo() {
    }

    public pojo(Integer response, String responseMsg, UserProfile userProfile) {
        super();
        this.response = response;
        this.responseMsg = responseMsg;
        this.userProfile = userProfile;
    }

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public pojo withResponse(Integer response) {
        this.response = response;
        return this;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public pojo withResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
        return this;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public pojo withUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
        return this;
    }
    public class UserProfile {

        @SerializedName("complainant_name")
        @Expose
        private String complainantName;
        @SerializedName("complainant_cnic")
        @Expose
        private String complainantCnic;
        @SerializedName("complainant_gender")
        @Expose
        private String complainantGender;
        @SerializedName("complainant_guardian_name")
        @Expose
        private String complainantGuardianName;
        @SerializedName("complainant_email")
        @Expose
        private String complainantEmail;
        @SerializedName("complainant_district_id_fk")
        @Expose
        private String complainantDistrictIdFk;
        @SerializedName("complainant_district_name")
        @Expose
        private String complainantDistrictName;
        @SerializedName("complainant_council")
        @Expose
        private String complainantCouncil;
        @SerializedName("complainant_address")
        @Expose
        private String complainantAddress;
        @SerializedName("complainant_contact")
        @Expose
        private String complainantContact;
        @SerializedName("user_name")
        @Expose
        private String userName;
        @SerializedName("user_avatar")
        @Expose
        private String userAvatar;


        public UserProfile() {
        }
        public UserProfile(String complainantName, String complainantCnic, String complainantGender, String complainantGuardianName, String complainantEmail, String complainantDistrictIdFk, String complainantDistrictName, String complainantCouncil, String complainantAddress, String complainantContact, String userName, String userAvatar) {
            super();
            this.complainantName = complainantName;
            this.complainantCnic = complainantCnic;
            this.complainantGender = complainantGender;
            this.complainantGuardianName = complainantGuardianName;
            this.complainantEmail = complainantEmail;
            this.complainantDistrictIdFk = complainantDistrictIdFk;
            this.complainantDistrictName = complainantDistrictName;
            this.complainantCouncil = complainantCouncil;
            this.complainantAddress = complainantAddress;
            this.complainantContact = complainantContact;
            this.userName = userName;
            this.userAvatar = userAvatar;
        }

        public String getComplainantName() {
            return complainantName;
        }

        public void setComplainantName(String complainantName) {
            this.complainantName = complainantName;
        }

        public UserProfile withComplainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }

        public String getComplainantCnic() {
            return complainantCnic;
        }

        public void setComplainantCnic(String complainantCnic) {
            this.complainantCnic = complainantCnic;
        }

        public UserProfile withComplainantCnic(String complainantCnic) {
            this.complainantCnic = complainantCnic;
            return this;
        }

        public String getComplainantGender() {
            return complainantGender;
        }

        public void setComplainantGender(String complainantGender) {
            this.complainantGender = complainantGender;
        }

        public UserProfile withComplainantGender(String complainantGender) {
            this.complainantGender = complainantGender;
            return this;
        }

        public String getComplainantGuardianName() {
            return complainantGuardianName;
        }

        public void setComplainantGuardianName(String complainantGuardianName) {
            this.complainantGuardianName = complainantGuardianName;
        }

        public UserProfile withComplainantGuardianName(String complainantGuardianName) {
            this.complainantGuardianName = complainantGuardianName;
            return this;
        }

        public String getComplainantEmail() {
            return complainantEmail;
        }

        public void setComplainantEmail(String complainantEmail) {
            this.complainantEmail = complainantEmail;
        }

        public UserProfile withComplainantEmail(String complainantEmail) {
            this.complainantEmail = complainantEmail;
            return this;
        }

        public String getComplainantDistrictIdFk() {
            return complainantDistrictIdFk;
        }

        public void setComplainantDistrictIdFk(String complainantDistrictIdFk) {
            this.complainantDistrictIdFk = complainantDistrictIdFk;
        }

        public UserProfile withComplainantDistrictIdFk(String complainantDistrictIdFk) {
            this.complainantDistrictIdFk = complainantDistrictIdFk;
            return this;
        }

        public String getComplainantDistrictName() {
            return complainantDistrictName;
        }

        public void setComplainantDistrictName(String complainantDistrictName) {
            this.complainantDistrictName = complainantDistrictName;
        }

        public UserProfile withComplainantDistrictName(String complainantDistrictName) {
            this.complainantDistrictName = complainantDistrictName;
            return this;
        }

        public String getComplainantCouncil() {
            return complainantCouncil;
        }

        public void setComplainantCouncil(String complainantCouncil) {
            this.complainantCouncil = complainantCouncil;
        }

        public UserProfile withComplainantCouncil(String complainantCouncil) {
            this.complainantCouncil = complainantCouncil;
            return this;
        }

        public String getComplainantAddress() {
            return complainantAddress;
        }

        public void setComplainantAddress(String complainantAddress) {
            this.complainantAddress = complainantAddress;
        }

        public UserProfile withComplainantAddress(String complainantAddress) {
            this.complainantAddress = complainantAddress;
            return this;
        }

        public String getComplainantContact() {
            return complainantContact;
        }

        public void setComplainantContact(String complainantContact) {
            this.complainantContact = complainantContact;
        }

        public UserProfile withComplainantContact(String complainantContact) {
            this.complainantContact = complainantContact;
            return this;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public UserProfile withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public int getUserAvatar() {
            return Integer.parseInt(userAvatar);
        }

        public void setUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
        }

        public UserProfile withUserAvatar(String userAvatar) {
            this.userAvatar = userAvatar;
            return this;
        }

    }

}

