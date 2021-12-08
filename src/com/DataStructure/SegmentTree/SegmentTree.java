package com.DataStructure.SegmentTree;

import java.util.Arrays;

/**
 * @author Peter
 */
@SuppressWarnings("all")
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public SegmentTree(E[] arr, Merger<E> merger){
        this.merger = merger;
        data = (E[])new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i]  = arr[i];
        }
        // 把数组组合为树的结构
        tree = (E[])new Object[4 * data.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    // 在treeIndex的位置区间创建表示[l, r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        int mid = l + (r - l) / 2;
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex] , tree[rightTreeIndex]);

    }

    public int getSize(){
        return data.length;
    }

    public E get( int index){
        if (index >= data.length || index < 0){
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    private int leftChild(int index){
        return 2 * index + 1;
    }

    private int rightChild(int index){
        return 2 * index + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
          if (tree[i] != null) {
                res.append(tree[i]);
            }
          else
              res.append("null");
          if (i != tree.length - 1){
              res.append(',');
          }
        }
        res.append(']');
        return res.toString();
    }
}
