package interview.practice;

import java.util.*;

public class CustomIterator {

    class Entity{

        int value;
        int listIndex;
        int index;

        public Entity(int value, int listIndex, int index) {
            this.value = value;
            this.listIndex = listIndex;
            this.index = index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entity entity = (Entity) o;
            return value == entity.value;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    ArrayList<ArrayList<Integer>> inputData;
    PriorityQueue<Entity> queue;

    public CustomIterator(ArrayList<ArrayList<Integer>> list){

        this.inputData = list;
        this.queue = new PriorityQueue<>();

        int index = 0;
        for (List<Integer> arr : list){
            queue.add(new Entity(arr.get(0), index, 1));
        }
    }

    public int getNext(){

        Entity min = this.queue.poll();
        int listIndex = min.listIndex;
        int index = min.index;

        if (index < this.inputData.get(listIndex).size()){
            this.queue.add(new Entity(this.inputData.get(listIndex).get(index), listIndex, index+1));
        }

        return min.value;

    }

    public boolean hasNext(){
        return !this.queue.isEmpty();
    }
}
