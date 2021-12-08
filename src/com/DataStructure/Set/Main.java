package com.DataStructure.Set;

import java.util.ArrayList;

/**
 * @author Peter
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        FileOperation.readFile("book1.txt", words1);
        System.out.println(words1.size());
    }
}
