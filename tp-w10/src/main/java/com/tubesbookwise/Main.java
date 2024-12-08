package com.tubesbookwise;

public class Main {
    public static void main(String[] args) {
        UserData usr1 = new UserData(1234, 8766);
        UserData usr2 = new UserData(1113, 8888);

        try {
            usr1.login();
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }

        try {
            usr2.login();
        } catch (LoginFailedException e) {
            System.out .println(e.getMessage());
        }

        try {
            usr2.login();
        } catch (LoginFailedException e) {
            System.out.println(e.getMessage());
        }
    }
}