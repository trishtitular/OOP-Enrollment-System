package org.example.model;
import java.util.*;

public class Cat extends Animal{
    public int life = 9;

    public Cat(int age, String name){
        super(age, name);
    }

    @Override
    public void makeSound() {
        System.out.println("Cat Meows!");
    }
}
