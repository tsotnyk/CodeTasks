package com.j2core.sts.leetcode.com.tmp;

import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class MyImplement {


    private int counterRequest;
    private long timePeriod;
    private HashMap<Integer, CounterCustomerRequest> map;

    public MyImplement(int counterRequest, long timePeriod) {
        this.counterRequest = counterRequest;
        this.timePeriod = timePeriod;
        this.map = new HashMap<>();
    }

    public boolean rateLimit(int customerId){

        if (map.containsKey(customerId)){

            CounterCustomerRequest object = map.get(customerId);
            Date date = new Date();
            long unixTimeNow = date.getTime()/1000L;
            if (object.getUnixTime()+timePeriod < unixTimeNow){
                object.setUnixTime(unixTimeNow);
                object.setCounter(1);
                return true;
            }

            if (object.getCounter() < counterRequest){
                object.setCounter(object.getCounter()+1);
                return true;
            }
            return false;
        }else {

            map.put(customerId, new CounterCustomerRequest(customerId));
            return true;
        }
    }
}

class CounterCustomerRequest{

    private long unixTime;
    private int counter = 1;
    private int customerId;

    public CounterCustomerRequest(int customerId) {
        this.customerId = customerId;
        Date date = new Date();
        this.unixTime = date.getTime()/1000L;
    }

    public long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(long unixTime) {
        this.unixTime = unixTime;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CounterCustomerRequest that = (CounterCustomerRequest) o;
        return counter == that.counter &&
                customerId == that.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(counter, customerId);
    }
}
