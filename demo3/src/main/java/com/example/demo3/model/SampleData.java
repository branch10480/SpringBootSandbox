package com.example.demo3.model;

public class SampleData {
    private String name;
    private int age;

    public SampleData(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getAge() {
        return this.age;
    }
}