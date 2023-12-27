package customDataStructures;

import java.util.HashMap;
import java.util.TreeSet;

class TimeStamp {

    class Pair{

        int timestamp;
        String value;

        public Pair(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    HashMap<String, TreeSet<Pair>> map;

    public TimeStamp() {

        this.map = new HashMap<>();
        // Write your code here
    }
    // Set TimeStamp data variables
    public boolean setValue(String key, String value, int timestamp) {

        TreeSet<Pair> valueSet = this.map.getOrDefault(key, new TreeSet<>((a,b) -> {
            return a.timestamp - b.timestamp;
        }));
            valueSet.add(new Pair(timestamp, value));
            this.map.put(key, valueSet);

        // Replace this placeholder return statement with your code
        return true;
    }
    // Get the value for the given key and timestamp
    public String getValue(String key, int timeStamp) {

        TreeSet<Pair> valueSet = this.map.get(key);

        if (valueSet == null) return "";

        Pair result = valueSet.floor(new Pair(timeStamp, ""));
        // Replace this placeholder return statement with your code
        return result == null ? "" : result.value;
    }
}