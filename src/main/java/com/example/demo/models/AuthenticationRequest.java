package com.example.demo.models;

public class AuthenticationRequest {

    private String username;
    private String passwort;

    public AuthenticationRequest(String username, String passwort) {
        this.username = username;
        this.passwort = passwort;
    }

    public AuthenticationRequest() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
}
