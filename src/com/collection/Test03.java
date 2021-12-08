package com.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @author Peter
 */
public class Test03 {

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();

        strings.add("aa");
        strings.add("bb");
        strings.add("cc");
        strings.add("dd");

        System.out.println(strings);

        ListIterator<String> it = strings.listIterator();
        while (it.hasNext()){
            if ("cc" .equals(it.next())){
                it.add("KK");
            }
        }
        System.out.println(strings);



    }
}
