package main;

import java.io.Serializable;

public class SerializationObject implements Serializable {
    private static final long serialVersionUID = -3895203507200457732L;
    private String name;
    private int age;

    public SerializationObject() {
        this.name = "Nobody";
        this.age = 0;
    }

    public SerializationObject(String name, int age) {
        this.setAge(age);
        this.setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Name: " + name + " age: " + age;
    }
}
