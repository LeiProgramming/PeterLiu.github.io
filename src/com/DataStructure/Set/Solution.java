package com.DataStructure.Set;

import java.util.TreeSet;

@SuppressWarnings("all")
/**
 * @author Peter
 */
public class Solution {
    public int uniqueMorseRepresentation(String[] words){
        String[] codes = {".-","-..."};
        var a = 10;
        TreeSet<String> set = new TreeSet<String>();
        for (String word :
                words) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                res.append(codes[word.charAt(i) - 'a']);

            }
            set.add(res.toString());
        }
        return set.size();
    }
}
