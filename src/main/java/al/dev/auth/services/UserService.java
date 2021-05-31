/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package al.dev.auth.services;

import al.dev.auth.utils.ResponseEntityTemplate;

import java.security.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserService {
    
    @Autowired
    private TokenStore tokenStore;
    
    @RequestMapping("/user")
    public Principal getUser(Principal user) {
        return user;
    }

    @RequestMapping(value = "/tokens/revokeAccessToken/{accessToken}", method = RequestMethod.POST)
    public ResponseEntity<Object> revokeToken (@RequestHeader(value = "Authorization") String accessToken) {
        ResponseEntityTemplate response = new ResponseEntityTemplate("", "");
        int statusCode = 200;
        String bearerToken = accessToken.replace("Bearer ", "");
        
        if (tokenStore instanceof JdbcTokenStore) {
            ((JdbcTokenStore) tokenStore).removeAccessToken(bearerToken);
        }
        
        response.setAccessToken(bearerToken);
        response.setStatus("expired");
        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));
    }
  }
