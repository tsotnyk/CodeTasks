package com.j2core.sts.leetcode.com.loggerRateLimiter;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Logger {

    HashMap<String, Integer> logMap;
    LinkedHashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
//        this.logMap = new HashMap<>();
        this.map = new LinkedHashMap<>(10);
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        int timePrint = logMap.getOrDefault(message, -1);
        if (timePrint < 0){
            logMap.put(message, timestamp);
            return true;
        }else if (timestamp - timePrint > 9){
            logMap.put(message, timestamp);
            return true;
        }

        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
