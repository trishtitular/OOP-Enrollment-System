package org.example.model;

public class Animal {
    private int age;
    private String name;

    public Animal(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge(){
        return age;
    }
    public void setAge(){
        this.age = age;
    }

    public String getName(){
        return name;

    }
    public void setName(){
        this.name = name;
    }
    public void makeSound(){
        System.out.println("Animal make sound!");
    }
}
