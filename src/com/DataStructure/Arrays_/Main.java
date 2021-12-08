package com.DataStructure.Arrays_;

/**
 * @author Peter
 */

@SuppressWarnings({"all"})

public class Main {

    public static void main(String[] args) {
        Arrays<Student> studentArrays = new Arrays<>();

        Student peter = new Student("Peter", 23);
        Student mary = new Student("Mary", 22);
        Student tom = new Student("Tom", 33);

        studentArrays.addLast(peter);
        studentArrays.addLast(mary);
        studentArrays.addLast(tom);

        studentArrays.addLast(peter);
        studentArrays.addLast(mary);
        studentArrays.addLast(tom);

        studentArrays.addLast(peter);
        studentArrays.addLast(mary);
        studentArrays.addLast(tom);

        studentArrays.addLast(peter);
        studentArrays.addLast(mary);
        studentArrays.addLast(tom);
        System.out.println(studentArrays);


    }
}


class Student{
    private String name;
    private int age;


    public Student(String name, int age) {
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}