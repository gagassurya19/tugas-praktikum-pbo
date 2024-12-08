package com.tubesbookwise;

import java.util.HashMap;

public class LoginFailedException extends Exception {
    private static HashMap<Integer, Integer> failedCount = new HashMap<>();
    private int userId;

    public LoginFailedException(String msg, int userId) {
        super(msg);
        this.userId = userId;

        if (failedCount.containsKey(userId)) {
            failedCount.put(userId, failedCount.get(userId) + 1);
        } else {
            failedCount.put(userId, 1);
        }
    }

    public int getUserId(){
        return this.userId;
    }

    public static int getFailedCounter(int userId) {
        return failedCount.getOrDefault(userId, 0);
    }

    @Override
    public String getMessage() {
        int count = getFailedCounter(userId);
        return super.getMessage() + ", telah gagal login " + count + " kali";
    }
}
