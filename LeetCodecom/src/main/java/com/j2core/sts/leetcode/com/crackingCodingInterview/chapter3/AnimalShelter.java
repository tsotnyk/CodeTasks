package com.j2core.sts.leetcode.com.crackingCodingInterview.chapter3;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalShelter {

    Queue<Animal> dogList;
    Queue<Animal> catList;

    public AnimalShelter(){
        this.dogList = new LinkedList<>();
        this.catList = new LinkedList<>();
    }

    public void addAnimal(String type, String name){

        Animal animal = new Animal(type, name);
        switch (type){
            case "dog": dogList.add(animal);
            break;
            case "cat": catList.add(animal);
        }
    }

    public Animal getAnimal(){

        if (catList.isEmpty() && dogList.isEmpty()) return null;
        if (catList.isEmpty()) return dogList.poll();
        if (dogList.isEmpty()) return catList.poll();
        if (catList.peek().visitTime < dogList.peek().visitTime){
            return catList.poll();
        }else {
            return dogList.poll();
        }
    }

    public Animal getCat(){
        if (catList.isEmpty()) return null;
        return catList.poll();
    }

    public Animal getDog(){
        if (dogList.isEmpty()) return null;
        return dogList.poll();
    }
}

class Animal{

    String type;
    String name;
    long visitTime;

    public Animal(String type, String name){

        this.type = type;
        this.name = name;
        this.visitTime = System.currentTimeMillis()/1000;
    }
}
