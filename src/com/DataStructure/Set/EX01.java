package com.DataStructure.Set;
import java.util.ArrayList;
import java.util.TreeSet;
/**
 * @author Peter
 */
// 两个数组的交集-01
public class EX01 {
    public static void main(String[] args) {
        int[] nums1 = {2, 3, 4, 4, 67};
        int[] nums2 = {2, 3, 4, 4, 67, 66, 2, 3, 44, 4};
        int[] res = intersection(nums1, nums2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }

    }

    public static int[] intersection(int[] nums1, int[] nums2){
        TreeSet<Integer> set = new TreeSet<>();
        for (int num :
                nums1) {
            set.add(num);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int num :
                nums2) {
            if (set.contains(num)){
                list.add(num);
                set.remove(num);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
        }
        return res;
    }
}


