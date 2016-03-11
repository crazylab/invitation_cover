package com.guest;

public class Age{
    private int age;

    public Age(int age) {
        this.age = age;
    }

    public boolean isOlderThan(int age) {
        return this.age > age;
    }

    public String addAtTheEnd(String label) {
        return label.concat(", "+age);
    }
}
