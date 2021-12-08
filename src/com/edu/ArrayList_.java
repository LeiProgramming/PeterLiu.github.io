package com.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author Peter
 */
public class ArrayList_ {
    public static void main(String[] args) {
        Collection collection = new ArrayList();

        collection.add(new Dog(90,"Peter"));
        collection.add(new Dog(70,"eter"));
        collection.add(new Dog(40,"ter"));

        for (Object dog :collection) {
            System.out.println("Dog" + dog);
        }

        Iterator iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object next =  iterator.next();
            System.out.println("Dog"+ next);
        }




    }
}
