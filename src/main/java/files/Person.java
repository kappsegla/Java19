package files;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {

    private String name;
    private int age;
    private boolean dead;

    private static final long serialVersionUID = 42374782438923489L;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dead=" + dead +
                '}';
    }
}
