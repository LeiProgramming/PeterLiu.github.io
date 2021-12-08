package com.DataStructure.Set;

import java.net.PortUnreachableException;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @author Peter
 */
// 350
public class EX02 {
    public static void main(String[] args) {
            int[] nums1 = {2, 3, 4, 4, 67};
            int[] nums2 = {2, 3, 4, 4, 67, 66, 2, 3, 44, 4};
            int[] res = intersection02(nums1, nums2);
            for (int i = 0; i < res.length; i++) {
                System.out.println(res[i]);
            }
    }

    public static int[] intersection02(int[] nums1, int[] nums2){
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int num :
                nums1) {
            if (!treeMap.containsKey(num)) {
                treeMap.put(num, 1);
            }
            else {
                treeMap.put(num, treeMap.get(num) + 1);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int num :
                nums2) {
            if (treeMap.containsKey(num)){
                list.add(num);
                treeMap.put(num, treeMap.get(num) - 1);
                if (treeMap.get(num) == 0){
                    treeMap.remove(num);
                }
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
