package org.launchcode.models;

import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

    @NotNull
    @Size(min=5, max=15, message = "Username must be between 5-15 characters.")
    private String username;

    @Email
    private String email;

    @NotNull
    @Size(min=6, message = "Password must be more than 6 characters.")
    private String password;

    private int userID;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID = userID; }
}
