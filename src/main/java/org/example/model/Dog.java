package org.example.model;
import java.util.*;

public class Dog extends Animal{
    private final String FAVORITE_FOOD = "Bone";

    public Dog (int age, String name){
        super(age,name);
    }

    public String getFAVORITE_FOOD(){
        return FAVORITE_FOOD;
    }

    @Override
    public void makeSound() {
        System.out.println("Dog Barks!");
    }
}
