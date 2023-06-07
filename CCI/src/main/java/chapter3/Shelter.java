package chapter3;

import java.util.LinkedList;
import java.util.Stack;

public class Shelter {

    LinkedList<String> list;

    public Shelter() {
        this.list = new LinkedList<>();
    }

    public void add(String animal){
        this.list.add(animal);
    }

    public String getAnimal(){
        return this.list.removeFirst();
    }

    public String getCat(){

        Stack<String> stack = new Stack<>();

        while (!this.list.getFirst().equals("Cat")){
            stack.push(this.list.removeFirst());
        }

        String result = this.list.removeFirst();

        while (!stack.isEmpty()){
            this.list.addFirst(stack.pop());
        }

        return result;
    }

    public String getDog(){
        Stack<String> stack = new Stack<>();

        while (!this.list.getFirst().equals("Dog")){
            stack.push(this.list.removeFirst());
        }

        String result = this.list.removeFirst();

        while (!stack.isEmpty()){
            this.list.addFirst(stack.pop());
        }

        return result;
    }
}

class Animal {

    String type;

    public Animal(String type) {
        this.type = type;
    }
}
