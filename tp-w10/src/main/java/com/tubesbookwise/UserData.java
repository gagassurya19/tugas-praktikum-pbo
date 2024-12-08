package com.tubesbookwise;

public class UserData {
    private final int userId;
    private final int password;
    private boolean isLoggedIn;

    public UserData(int userId, int password) {
        this.userId = userId;
        this.password = password;
        this.isLoggedIn = false;
    }

    public void login() throws LoginFailedException {
        int sum = this.userId + this.password;

        if (String.valueOf(this.userId).length() != 4 || String.valueOf(this.password).length() != 4) {
            throw new IllegalArgumentException("User ID and password must each be 4 digits.");
        }

        if(sum == 10000) {
            this.isLoggedIn = true;
            System.out.println("Login successful for user " + this.userId);
        } else {
            this.isLoggedIn = false;
            throw new LoginFailedException("Login user " + this.userId + " gagal", this.userId);
        }
    }
}
