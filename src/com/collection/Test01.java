package com.collection;

import com.edu.ArrayList_;

import java.util.ArrayList;

/**
 * @author Peter
 */
public class Test01 {
    public static void main(String[] args) {
        ArrayList<Integer> a1 = new ArrayList<>();

        a1.add(100);
        a1.add(100);
        a1.add(100);
        a1.add(100);

        for (Integer i :
                a1) {
            System.out.println(i);
        }


    }
}
