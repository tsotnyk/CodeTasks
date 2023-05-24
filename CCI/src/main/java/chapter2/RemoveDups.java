package chapter2;

import org.testng.annotations.Test;

import java.util.HashSet;

public class RemoveDups {

    public NodeSingleList removeDups(NodeSingleList input){

        HashSet<Integer> set = new HashSet<>();
        set.add(input.value);
        NodeSingleList output = input;
        input = input.next;
        output.next = null;
        NodeSingleList next = output;
        while (input.next != null){
            if (set.add(input.value)){
                next.next = input;
                input = input.next;
                next.next.next = null;
                next = next.next;
            }else {
                input = input.next;
            }

        }
        return output;
    }

    @Test
    public void test(){

        NodeSingleList list = new NodeSingleList(0);
        list.next = new NodeSingleList(0);
        list.next.next = new NodeSingleList(1);
        list.next.next.next = new NodeSingleList(2);
        list.next.next.next.next = new NodeSingleList(2);

        NodeSingleList result = removeDups(list);

        while (result != null){
            System.out.println(result.value);
            result = result.next;
        }

    }
}
