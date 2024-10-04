package com.api.request_payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Login {

        @JsonProperty("username")
        private String username;

        @JsonProperty("password")
        private String password;

        @JsonProperty("expiresInMins")
        private String expiresInMins;

        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

        @JsonProperty("password")
        public String getPassword() {
            return password;
        }

        @JsonProperty("password")
        public void setPassword(String password) {
            this.password = password;
        }

        @JsonProperty("expiresInMins")
        public String getExpiresInMins() {
            return expiresInMins;
        }

        @JsonProperty("expiresInMins")
        public void setExpiresInMins(String expiresInMins) {
            this.expiresInMins = expiresInMins;
        }
}