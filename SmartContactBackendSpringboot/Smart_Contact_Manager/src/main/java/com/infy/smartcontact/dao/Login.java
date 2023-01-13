package com.infy.smartcontact.dao;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Login {

    @NotBlank(message="username address is required")
    @Size(min = 5,max = 40,message = "username Address Length should be 5 to 40")
    @Email(message = "Not a Valid username Address")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 4,max = 40,message = "Password must have 4 char and max 40 char")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{4,40}$",message = "One lowercase one uppercase one number one special char and max length 40")
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Login() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
