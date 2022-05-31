package interview.practice;

import java.util.*;

public class GetRandomCollection {

    HashMap<Integer, List<Integer>> map;
    ArrayList<Integer> list;

    public GetRandomCollection(){

        this.list = new ArrayList<>();
        this.map = new HashMap<>();
    }

    public void insert(int value){

        int index = this.list.size();
        this.list.add(value);
        if (this.map.containsKey(value)){
            this.map.get(value).add(index);
        }else {
            this.map.put(value, new ArrayList<>(Collections.singleton(index)));
        }
    }

    public boolean search(int value){
        return this.map.containsKey(value);
    }

    public boolean remove(int value){

        List<Integer>  indexes = this.map.getOrDefault(value, new ArrayList<>());

        if (indexes.size() < 1) return false;
        int index = indexes.remove(indexes.size()-1);
        Integer swapValue = this.list.get(this.list.size()-1);
        this.map.get(swapValue).remove(index);
        this.map.get(swapValue).add(index);
        Collections.swap(this.list, index, this.list.size()-1);
        this.list.remove(this.list.size()-1);

        return true;
    }

    public int getRandom(){

        Random random = new Random();
        int index = random.nextInt(this.list.size());

        return this.list.get(index);
    }

}
