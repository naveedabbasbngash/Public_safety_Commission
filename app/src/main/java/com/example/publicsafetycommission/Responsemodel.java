

package com.example.publicsafetycommission;

import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
public class Responsemodel {

    @SerializedName("response")
    @Expose
    private Integer response;
    @SerializedName("user_id")
    @Expose
    private Integer user_id;
    @SerializedName("response_msg")
    @Expose
    private String responseMsg;
    @SerializedName("complaints")
    @Expose
    private List<Complaint> complaints = null;

    public Integer getResponse() {
        return response;
    }

    public void setResponse(Integer response) {
        this.response = response;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer response) {
        this.user_id = user_id;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    public List<Complaint> getComplaints() {
        return complaints;
    }

    public void setComplaints(List<Complaint> complaints) {
        this.complaints = complaints;
    }

    public class Complaint {

        @SerializedName("complaint_id")
        @Expose
        private String complaintId;
        @SerializedName("complaint_source")
        @Expose
        private String complaintSource;
        @SerializedName("complainant_id_fk")
        @Expose
        private String complainantIdFk;
        @SerializedName("registered_by_user")
        @Expose
        private String registeredByUser;
        @SerializedName("district_id_fk")
        @Expose
        private String districtIdFk;
        @SerializedName("complaint_council")
        @Expose
        private Object complaintCouncil;
        @SerializedName("complaint_category_id_fk")
        @Expose
        private String complaintCategoryIdFk;
        @SerializedName("complaint_detail")
        @Expose
        private String complaintDetail;
        @SerializedName("complaint_entry_timestamp")
        @Expose
        private String complaintEntryTimestamp;
        @SerializedName("complaint_status_id_fk")
        @Expose
        private String complaintStatusIdFk;
        @SerializedName("complainant_name")
        @Expose
        private String complainantName;
        @SerializedName("district_name")
        @Expose
        private String districtName;
        @SerializedName("complaint_status_title")
        @Expose
        private String complaintStatusTitle;
        @SerializedName("complaint_status_color")
        @Expose
        private String complaintStatusColor;
        @SerializedName("complaint_category_name")
        @Expose
        private String complaintCategoryName;

        public String getComplaintId() {
            return complaintId;
        }

        public void setComplaintId(String complaintId) {
            this.complaintId = complaintId;
        }

        public Complaint withComplaintId(String complaintId) {
            this.complaintId = complaintId;
            return this;
        }

        public String getComplaintSource() {
            return complaintSource;
        }

        public void setComplaintSource(String complaintSource) {
            this.complaintSource = complaintSource;
        }

        public Complaint withComplaintSource(String complaintSource) {
            this.complaintSource = complaintSource;
            return this;
        }

        public String getComplainantIdFk() {
            return complainantIdFk;
        }

        public void setComplainantIdFk(String complainantIdFk) {
            this.complainantIdFk = complainantIdFk;
        }

        public Complaint withComplainantIdFk(String complainantIdFk) {
            this.complainantIdFk = complainantIdFk;
            return this;
        }

        public String getRegisteredByUser() {
            return registeredByUser;
        }

        public void setRegisteredByUser(String registeredByUser) {
            this.registeredByUser = registeredByUser;
        }

        public Complaint withRegisteredByUser(String registeredByUser) {
            this.registeredByUser = registeredByUser;
            return this;
        }

        public String getDistrictIdFk() {
            return districtIdFk;
        }

        public void setDistrictIdFk(String districtIdFk) {
            this.districtIdFk = districtIdFk;
        }

        public Complaint withDistrictIdFk(String districtIdFk) {
            this.districtIdFk = districtIdFk;
            return this;
        }

        public Object getComplaintCouncil() {
            return complaintCouncil;
        }

        public void setComplaintCouncil(Object complaintCouncil) {
            this.complaintCouncil = complaintCouncil;
        }

        public Complaint withComplaintCouncil(Object complaintCouncil) {
            this.complaintCouncil = complaintCouncil;
            return this;
        }

        public String getComplaintCategoryIdFk() {
            return complaintCategoryIdFk;
        }

        public void setComplaintCategoryIdFk(String complaintCategoryIdFk) {
            this.complaintCategoryIdFk = complaintCategoryIdFk;
        }

        public Complaint withComplaintCategoryIdFk(String complaintCategoryIdFk) {
            this.complaintCategoryIdFk = complaintCategoryIdFk;
            return this;
        }

        public String getComplaintDetail() {
            return complaintDetail;
        }

        public void setComplaintDetail(String complaintDetail) {
            this.complaintDetail = complaintDetail;
        }

        public Complaint withComplaintDetail(String complaintDetail) {
            this.complaintDetail = complaintDetail;
            return this;
        }

        public String getComplaintEntryTimestamp() {
            return complaintEntryTimestamp;
        }

        public void setComplaintEntryTimestamp(String complaintEntryTimestamp) {
            this.complaintEntryTimestamp = complaintEntryTimestamp;
        }

        public Complaint withComplaintEntryTimestamp(String complaintEntryTimestamp) {
            this.complaintEntryTimestamp = complaintEntryTimestamp;
            return this;
        }

        public String getComplaintStatusIdFk() {
            return complaintStatusIdFk;
        }

        public void setComplaintStatusIdFk(String complaintStatusIdFk) {
            this.complaintStatusIdFk = complaintStatusIdFk;
        }

        public Complaint withComplaintStatusIdFk(String complaintStatusIdFk) {
            this.complaintStatusIdFk = complaintStatusIdFk;
            return this;
        }

        public String getComplainantName() {
            return complainantName;
        }

        public void setComplainantName(String complainantName) {
            this.complainantName = complainantName;
        }

        public Complaint withComplainantName(String complainantName) {
            this.complainantName = complainantName;
            return this;
        }

        public String getDistrictName() {
            return districtName;
        }

        public void setDistrictName(String districtName) {
            this.districtName = districtName;
        }

        public Complaint withDistrictName(String districtName) {
            this.districtName = districtName;
            return this;
        }

        public String getComplaintStatusTitle() {
            return complaintStatusTitle;
        }

        public void setComplaintStatusTitle(String complaintStatusTitle) {
            this.complaintStatusTitle = complaintStatusTitle;
        }

        public Complaint withComplaintStatusTitle(String complaintStatusTitle) {
            this.complaintStatusTitle = complaintStatusTitle;
            return this;
        }

        public String getComplaintStatusColor() {
            return complaintStatusColor;
        }

        public void setComplaintStatusColor(String complaintStatusColor) {
            this.complaintStatusColor = complaintStatusColor;
        }

        public Complaint withComplaintStatusColor(String complaintStatusColor) {
            this.complaintStatusColor = complaintStatusColor;
            return this;
        }

        public String getComplaintCategoryName() {
            return complaintCategoryName;
        }

        public void setComplaintCategoryName(String complaintCategoryName) {
            this.complaintCategoryName = complaintCategoryName;
        }

        public Complaint withComplaintCategoryName(String complaintCategoryName) {
            this.complaintCategoryName = complaintCategoryName;
            return this;
        }
    }
}
