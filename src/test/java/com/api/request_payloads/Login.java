package com.api.request_payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the payload for a login request, including username, password, and session expiration.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        @JsonProperty("expiresInMins")
        private String expiresInMins;

       /**
        * Gets the username.
        * @return the username
        */
        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

       /**
        * Sets the username.
        * @param username the username to set
        */
        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

       /**
        * Gets the password.
        * @return the password
        */
        @JsonProperty("password")
        public String getPassword() {
            return password;
        }

       /**
        * Sets the password.
        * @param password the password to set
        */
        @JsonProperty("password")
        public void setPassword(String password) {
            this.password = password;
        }

       /**
        * Gets the session expiration time in minutes.
        * @return the expiration time in minutes
        */
        @JsonProperty("expiresInMins")
        public String getExpiresInMins() {
            return expiresInMins;
        }

       /**
        * Sets the session expiration time in minutes.
        * @param expiresInMins the expiration time to set
        */
        @JsonProperty("expiresInMins")
        public void setExpiresInMins(String expiresInMins) {
            this.expiresInMins = expiresInMins;
        }
}