/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.dev.auth.utils;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ResponseEntityTemplate {
    
    
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("status")
    private String status;

    public ResponseEntityTemplate(String accessToken, String status) {
        this.accessToken = accessToken;
        this.status = status;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
     
     
             
}
