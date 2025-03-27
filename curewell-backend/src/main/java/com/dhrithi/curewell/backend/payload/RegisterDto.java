package com.dhrithi.curewell.backend.payload;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class RegisterDto {
    private String name;

    @NotEmpty(message = "Username is required")
    private String username;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotEmpty(message = "Role is required")
    private String role;
    public RegisterDto(){}
    public RegisterDto(String name, String username, String email, String password, String role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public @NotEmpty(message = "Username is required") String getUsername() {
        return username;
    }

    public void setUsername(@NotEmpty(message = "Username is required") String username) {
        this.username = username;
    }

    public @Email(message = "Email is not valid") @NotEmpty(message = "Email is required") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "Email is not valid") @NotEmpty(message = "Email is required") String email) {
        this.email = email;
    }

    public @NotEmpty(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotEmpty(message = "Password is required") @Size(min = 6, message = "Password must be at least 6 characters") String password) {
        this.password = password;
    }

    public @NotEmpty(message = "Role is required") String getRole() {
        return role;
    }

    public void setRole(@NotEmpty(message = "Role is required") String role) {
        this.role = role;
    }
}
