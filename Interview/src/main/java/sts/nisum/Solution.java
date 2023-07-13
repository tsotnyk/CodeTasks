package sts.nisum;

import java.util.*;

public class Solution {
//
//    List<Employs> list;
  //  Map<String, Map<String, List<Employs>>> map;
  //     location,    department, list<Employs>

    public Map<String, Map<String, List<Employs>>> createEmpMap(List<Employs> list){


        Map<String, Map<String, List<Employs>>> map = new HashMap<>();

        for (Employs emp : list){

            if (map.containsKey(emp.location)){
                Map<String, List<Employs>> depMap = map.get(emp.location);
                if (depMap.containsKey(emp.department)){
                    List<Employs> depList = depMap.get(emp.department);
                    depList.add(emp);
                }else {
                    List<Employs> depList = new LinkedList<>(Collections.singletonList(emp));
                    depMap.put(emp.department, depList);
                }
            }else {
                Map<String, List<Employs>> depMap = new HashMap<>();
                List<Employs> depList = new LinkedList<>(Collections.singletonList(emp));
                depMap.put(emp.location, depList);
                map.put(emp.location, depMap);
            }

        }



        return map;

    }


    public List <Employs> sortEmp(List<Employs> list){

        list.sort((a, b ) -> {
            if (a.firstName.charAt(0) == a.firstName.charAt(0)){
                return a.lastName.charAt(0) - b.lastName.charAt(0);
            }else {
                return a.firstName.charAt(0)-b.firstName.charAt(0);
            }
        });

        return list;
    }

    
}

class Employs {

    String firstName;
    String lastName;

    String location;
    String department;
}




