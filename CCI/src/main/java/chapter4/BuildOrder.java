package chapter4;

import org.testng.annotations.Test;

import java.util.*;

public class BuildOrder {

    public List<Character> findOrder(List<Character> projects, List<List<Character>> dep){

        List<Character> result = new LinkedList<>();
        HashSet<Character> visited = new HashSet<>();
        HashMap<Character, List<Character>> map = createMapDep(projects, dep);

        for (char prod : projects){

            HashSet<Character> curVisit = new HashSet<>();
            List<Character> curProj = new LinkedList<>();

            position(prod, visited, curVisit, map, curProj);

            result.addAll(0, curProj);

        }

        return result;
    }

    private void position(char prod, HashSet<Character> visited, HashSet<Character> curVisited, HashMap<Character, List<Character>> map, List<Character> output){

        if (visited.contains(prod)) return;
        if (curVisited.contains(prod)) throw new IllegalArgumentException();

        visited.add(prod);
        curVisited.add(prod);
        output.add(prod);

        for (char dep : map.get(prod)){
            position(dep, visited, curVisited, map, output);
        }

        curVisited.remove(prod);

    }

    private HashMap<Character, List<Character>> createMapDep(List<Character> projects, List<List<Character>> dep){

        HashMap<Character, List<Character>> map = new HashMap<>();

        for (char project : projects){
            map.put(project, new LinkedList<>());
        }

        for (List<Character> pair : dep){
            map.get(pair.get(0)).add(pair.get(1));
        }

        return map;
    }

    @Test
    public void test(){

        List<Character> projects = new LinkedList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'));
        List<Character> dep1 = new LinkedList<>(Arrays.asList('a', 'd'));
        List<Character> dep2 = new LinkedList<>(Arrays.asList('f', 'b'));
        List<Character> dep3 = new LinkedList<>(Arrays.asList('b', 'd'));
        List<Character> dep4 = new LinkedList<>(Arrays.asList('f', 'a'));
        List<Character> dep5 = new LinkedList<>(Arrays.asList('d', 'c'));
        List<List<Character>> dep = new LinkedList<>();
        dep.add(dep1);
        dep.add(dep2);
        dep.add(dep3);
        dep.add(dep4);
        dep.add(dep5);

        List<Character> result = findOrder(projects, dep);
    }
}
