package com.j2core.sts.leetcode.com.accountMerge;

import org.testng.annotations.Test;

import java.util.*;

public class Solution {


    class Person {

        String name;
        int id;

        public Person(String name, int id) {
            this.name = name;
            this.id = id;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person key = (Person) o;
            return id == key.id && Objects.equals(name, key.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, id);
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> in) {

        HashMap<String, Person> emailOwnerMap = new HashMap<>();
        HashMap<Person, List<String>> personEmails = new HashMap<>();

        int i = 0;
        for (List<String> personWithEmails : in){

            Person person = new Person(personWithEmails.remove(0), i);
            personEmails.put(person, new LinkedList<>());

            for (String email : personWithEmails){
                if (emailOwnerMap.containsKey(email)){

                        List<String> samePersonEmailList = personEmails.remove(emailOwnerMap.get(email)); // remove Person for add his emails to other Person&id
                        personEmails.get(person).addAll(samePersonEmailList); // add all emails from other Person name&id

                        for (String newEmail : samePersonEmailList){
                            emailOwnerMap.put(newEmail, person);// update owner for email
                        }
                }else {
                    personEmails.get(person).add(email);
                    emailOwnerMap.put(email, person);
                }
            }
            i++;
        }

        List<List<String>> res = new LinkedList<>();

        for (Person person : personEmails.keySet()){
            List<String> emailList = personEmails.get(person);
            emailList.add(0, person.name);
            res.add(emailList);
        }

        return res;
    }


    @Test
    public void testMerge() {
        var in = new LinkedList<List<String>>();
        in.add(prepare("name1,e1"));
        in.add(prepare("name2,e2"));
        in.add(prepare("name3,e1,e2"));

        var out = accountsMerge(in);
        System.out.println(out);
        System.out.println("********************");

        in = new LinkedList<List<String>>();
        in.add(prepare("name1,e1,e12"));
        in.add(prepare("name2,e2,e14,e15"));
        in.add(prepare("name3,e1,e2"));
        in.add(prepare("name4,e6,e7"));

        out = accountsMerge(in);
        System.out.println(out);
        System.out.println("********************");

        in = new LinkedList<List<String>>();
        in.add(prepare("name1,e1,e2"));
        in.add(prepare("name1,e3,e4"));

        out = accountsMerge(in);
        System.out.println(out);

    }

    private List<String> prepare(String in) {
        var out = new LinkedList<String>();

        Collections.addAll(out, in.split(","));

        return out;
    }

    @Test
    public void testMerge1() {
        var in = new LinkedList<List<String>>();
        in.add(prepare(new String[]{"name1", "e1"}));
        in.add(prepare(new String[]{"name2", "e2"}));
        in.add(prepare(new String[]{"name3", "e1", "e2"}));

        var out = accountsMerge(in);
        System.out.println(out);
    }

    private List<String> prepare(String[] in) {
        var out = new LinkedList<String>();

        out.addAll(Arrays.asList(in));

        return out;
    }
}

