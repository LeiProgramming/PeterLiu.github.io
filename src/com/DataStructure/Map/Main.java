package com.DataStructure.Map;

import com.DataStructure.Set.FileOperation;

import java.util.ArrayList;

/**
 * @author Peter
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        LinkedListMap<String, Integer> wordsFrq = new LinkedListMap<>();
        if (FileOperation.readFile("book1.txt", words)){
            System.out.println(words.size());
            for (String word: words) {
                if (wordsFrq.contains(word)){
                    wordsFrq.set(word, wordsFrq.get(word) + 1);
                }
                else
                    wordsFrq.add(word, 1);
            }
        }
        System.out.println(wordsFrq);

    }

}
