package com.DataStructure.SegmentTree;

/**
 * @author Peter
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {2, 3, 4, 5, 6, 6};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (Integer::max));
        System.out.println(segmentTree);
    }

}
