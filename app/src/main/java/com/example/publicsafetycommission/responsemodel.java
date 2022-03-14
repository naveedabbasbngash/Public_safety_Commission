package com.example.publicsafetycommission;

public class responsemodel
{
    String response_msg;
    String token;
    int response;


   /* public responsemodel(String response_msg) {

        this.response_msg = response_msg;
    }*/

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {

        this.response = response;
    }

    public String getMessage() {

        return response_msg;
    }

    public void setMessage(String response_msg) {

        this.response_msg = response_msg;
    }
    public String getToken() {

        return token;
    }

}

