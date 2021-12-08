package com.collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Peter
 */
public class Test04 {

    public static void main(String[] args) {

        TreeSet<Student> integers = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        integers.add(new Student(10,"ll"));
        integers.add(new Student(10,"liil"));
        integers.add(new Student(10,"liilii"));
        integers.add(new Student(10,"lili"));
        integers.add(new Student(10,"ll"));
        integers.add(new Student(10,"ll"));
        System.out.println(integers);
        System.out.println(integers);
    }
}


