package com.isa.fishingbooker.dto;

// DTO za login
public class JwtAuthenticationRequest {
	
	private String email;
    private String username;
    private String password;

    public JwtAuthenticationRequest() {
        super();
    }

    public JwtAuthenticationRequest(String email, String password) {
        this.setEmail(email);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
    	return this.email;
    }
    public void setEmail(String email) {
    	this.email=email;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
