package airbnb;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class Solution {

    class ArmyInfo{

        String name;        // army name
        String location;    // army location
        String support;     // army not has support (null) or has (support army name)

    }

    /**
     * The method evaluate action in game
     * @param actions   input data
     * @return   armies information list after war
     */
    public List<String> evaluateActions(List<String> actions) {

        // locations map with all armies in each location
        Map<String, List<String>> positions = new HashMap<String, List<String>>();
        // Armies list
        List<String> armies = new LinkedList<String>();
        // Army information map
        Map<String, ArmyInfo> armyMap = createMap(actions, positions, armies);

        // get locations set for iteration;
        Set<String> cities = positions.keySet();

        for (String city : cities){

            war(city, positions, armyMap);
        }

        return createAnswer(armies, armyMap);
    }

    /**
     *  The method emulated war in location
     * @param city           war location
     * @param positions      armies positions
     * @param armies         armies information
     */
    private void war(String city, Map<String, List<String>> positions, Map<String, ArmyInfo> armies){

        // get armies list in this location
        List<String> list = positions.get(city);
        if (list != null){

            // if sum of armies in location bigger than 1 - war
            if (list.size() > 1) {

                for (String army : list) {

                    ArmyInfo armyInfo = armies.get(army);
                    if (armyInfo.support == null) {
                        armyInfo.location = null;
                    } else {
                        war(armies.get(armyInfo.support).location, positions, armies);
                        if (armies.get(armyInfo.support).location == null) {
                            armyInfo.location = null;
                        }
                    }
                }
            }
        }
    }

    /**
     * The method created result's list
     * @param armies      armies list
     * @param armyMap     armies information
     * @return         List with resulting string
     */
    private List<String> createAnswer(List<String> armies, Map<String, ArmyInfo> armyMap) {

        List<String> result = new LinkedList<String>();

        // get army result information's string
        for (String army : armies){
            ArmyInfo armyInfo = armyMap.get(army);
            StringBuilder builder = new StringBuilder();
            builder.append(armyInfo.name).append(" ");

            if (armyInfo.location == null){
                builder.append("[dead]");
            }else {
                builder.append(armyInfo.location);
            }
            result.add(builder.toString());
        }
        return result;
    }

    /**
     * The method create armies information map, fill positions map and armies collection
     * @param actions      input data
     * @param positions    positions
     * @param armies       armies collection
     * @return    Armies information map
     */
    private Map<String, ArmyInfo> createMap(List<String> actions, Map<String, List<String>> positions, List<String> armies){

        Map<String, ArmyInfo> armyMap = new HashMap<String, ArmyInfo>();
        List<String[]> supportList = new LinkedList<String[]>();
        for (String string : actions){

            //pars input army data
            String[] dataArray = string.split(" ");

            armies.add(dataArray[0]);
            ArmyInfo armyInfo = new ArmyInfo();
            // add army name
            armyInfo.name = dataArray[0];

            // add army location, if action Move - stay in new location, else use old location
            if (dataArray[2].equals("Hold")){
                armyInfo.location = dataArray[1];
            }else if (dataArray[2].equals("Move")){
                armyInfo.location = dataArray[3];
            }else {
                armyInfo.location = dataArray[1];

                // if army is support for other army. Add information about support to other army
                ArmyInfo support = armyMap.get(dataArray[3]);
                if (support != null){
                    support.support = dataArray[0];
                }else{
                    //if armies map doesn't contain that army eat, save this info to support list for add this information late
                    String[] supp = new String[]{dataArray[3], dataArray[0]};
                    supportList.add(supp);
                }
            }

            //add army information
            armyMap.put(armyInfo.name, armyInfo);

            //add army location
            List<String> positionList = positions.get(armyInfo.location);
            if (positionList == null){
                positionList = new LinkedList<String>();
                positionList.add(armyInfo.name);
                positions.put(armyInfo.location, positionList);
            }else {
                positionList.add(armyInfo.name);
                positions.put(armyInfo.location, positionList);
            }
        }

        // added support army
        for (String[] tmp : supportList){

            ArmyInfo armyInfo = armyMap.get(tmp[0]);
            armyInfo.support = tmp[1];
        }
        return armyMap;
    }

    @Test
    public void test(){

        List<String> input1 = new LinkedList<String>();
        input1.add("A Munich Support B");
        input1.add("B Bohemia Move Prussia");
        input1.add("C Prussia Hold");
        input1.add("D Warsaw Move Munich");

        List<String> expectedResult1 = new LinkedList<String>();
        expectedResult1.add("A [dead]");
        expectedResult1.add("B [dead]");
        expectedResult1.add("C [dead]");
        expectedResult1.add("D [dead]");

        List<String> input2 = new LinkedList<String>();
        input2.add("A Munich Hold");
        input2.add("B Warsaw Move Bohemia");

        List<String> expectedResult2 = new LinkedList<String>();
        expectedResult2.add("A Munich");
        expectedResult2.add("B Bohemia");

        List<String> input3 = new LinkedList<String>();
        input3.add("A Munich Hold");
        input3.add("B Bohemia Move Munich");
        input3.add("C Warsaw Support B");

        List<String> expectedResult3 = new LinkedList<String>();
        expectedResult3.add("A [dead]");
        expectedResult3.add("B Munich");
        expectedResult3.add("C Warsaw");

        List<String> input4 = new LinkedList<String>();
        input4.add("A Munich Hold");
        input4.add("B Bohemia Move Munich");
        input4.add("C Prussia Move Munich");
        input4.add("D Warsaw Hold");

        List<String> expectedResult4 = new LinkedList<String>();
        expectedResult4.add("A [dead]");
        expectedResult4.add("B [dead]");
        expectedResult4.add("C [dead]");
        expectedResult4.add("D Warsaw");

        List<String> input5 = new LinkedList<String>();
        input5.add("A Munich Support B");
        input5.add("B Oakland Move Munich");

        List<String> expectedResult5 = new LinkedList<String>();
        expectedResult5.add("A [dead]");
        expectedResult5.add("B [dead]");

        Assert.assertEquals(expectedResult1, evaluateActions(input1));
        Assert.assertEquals(expectedResult2, evaluateActions(input2));
        Assert.assertEquals(expectedResult3, evaluateActions(input3));
        Assert.assertEquals(expectedResult4, evaluateActions(input4));
        Assert.assertEquals(expectedResult5, evaluateActions(input5));

    }
}
