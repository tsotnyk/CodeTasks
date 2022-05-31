package com.j2core.sts.leetcode.com.employeeImportance;

import java.util.HashMap;
import java.util.List;

public class Solution {

    public int getImportance(List<Employee> employees, int id) {

        HashMap<Integer, Employee> map = new HashMap<>();

        for (Employee employee : employees){
            map.put(employee.id, employee);
        }

        return countImportance(map, id);

    }

    private int countImportance(HashMap<Integer, Employee> map, int id){
        Employee employee = map.get(id);
        int sum = employee.importance;

        for (int subordinate : employee.subordinates){
            sum += countImportance(map, subordinate);
        }

        return sum;
    }
}
