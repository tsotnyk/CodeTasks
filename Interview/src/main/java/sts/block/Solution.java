package sts.block;

// {
//   "blue-medium-color": "#0000ff",
//   "blue-dark-color": "#000099",
//   "blue-light-color": "#9999ff",
//   "black-color": "#000000",
//   "gray-dark-color": "#333333",
//   "gray-medium-color": "#999999",
//   "gray-light-color": "#cccccc",
//   "white-color": "#ffffff",
//   "grid-small-size": "8px",
//   "grid-medium-size": "16px",
//   "grid-large-size": "24px"
// }



/*
 * Click `Run` to execute the snippet below!
 */

import java.util.HashMap;
import java.util.Map;

// import org.checkerframework.checker.units.qual.Length;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("blue-medium-color", "#0000ff");
        map.put("blue-dark-color", "#000099");
        map.put("blue-light-color", "#9999ff");
        map.put("black-color", "#000000");
        map.put("gray-dark-color", "#333333");
        map.put("gray-medium-color", "#999999");
        map.put("gray-light-color", "#cccccc");
        map.put("white-color", "#ffffff");
        map.put("grid-small-size", "8px");
        map.put("grid-medium-size", "16px");
        map.put("grid-large-size", "24px");

        map.put("primary-background-color", "{blue-medium-color}");
        map.put("primary-foreground-color", "{gray-light-color}");

        map.put("small-padding-size", "{grid-small-size}");
        map.put("medium-padding-size", "{grid-medium-size}");
        map.put("large-padding-size", "{grid-large-size}");

        map.put("button-background-color", "{primary-background-color}");
        map.put("button-text-color", "{primary-foreground-color}");
        map.put("button-padding-size", "{medium-padding-size}");

        readInputData(map);

        System.out.println("primary-background-color");

        System.out.println(getFieldValue(map, "primary-background-color"));
        System.out.println("blue-dark-color");
        System.out.println(getFieldValue(map, "blue-dark-color"));

        System.out.println("button-background-color");
        System.out.println(getFieldValue(map, "button-background-color"));
    }


    // class Token{

    // String blue-medium-color;
    // String blue-dark-color;
    // // "blue-light-color": "#9999ff",
    // // "black-color": "#000000",
    // // "gray-dark-color": "#333333",
    // // "gray-medium-color": "#999999",
    // // "gray-light-color": "#cccccc",
    // // "white-color": "#ffffff",
    // // "grid-small-size": "8px",
    // // "grid-medium-size": "16px",
    // // "grid-large-size": "24px"
    // }

    // Output:
    // blue-medium-color: #0000ff

    public static void readInputData(Map<String, String> inputData)
    {


        for(String key : inputData.keySet()){

            System.out.println(" " + key + ": " + inputData.get(key));
        }
    }

    public static String getFieldValue(Map<String, String> inputData, String key)
    {

        if(inputData.containsKey(key)){

            String value = inputData.get(key);

            while (value != null && value.charAt(0) == '{' && value.charAt(value.length()-1) == '}'){
                value = value.substring(1, value.length()-1);

                value = getFieldValue(inputData, value);
            }

            return value;
        }

        throw new IllegalArgumentException("Key not exist");

        // return null;



        // return inputData.getOrDefault(key, null);

    }
}




// todo



// Your previous Plain Text content is preserved below:

// This is just a simple shared plaintext pad, with no execution capabilities.

// When you know what language you'd like to use for your interview,
// simply choose it from the dots menu on the tab, or add a new language
// tab using the Languages button on the left.

// You can also change the default language your pads are created with
// in your account settings: https://app.coderpad.io/settings

// Enjoy your interview!
