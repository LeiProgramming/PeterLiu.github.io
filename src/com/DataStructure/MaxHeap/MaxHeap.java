package com.DataStructure.MaxHeap;

import com.DataStructure.Arrays_.Arrays;

/**
 * @author Peter
 */
public class MaxHeap<E extends Comparable<E>> {
    private Arrays<E> data;

    public MaxHeap(int capacity){
        data = new Arrays<>(capacity);
    }

    public MaxHeap(){
        data = new Arrays<>();
    }

    public MaxHeap(E[] arr){
        data = new Arrays<>(arr.length);
        for (int i = parent(arr.length - 1); i>= 0; i--){
            siftDown(i);
        }
    }

    public int size(){
        return size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

//    返回完全二叉树的数组表示中，一个索引所表示的节点的父亲节点的索引
    private int parent(int index){
        if (index == 0){
            throw new IllegalArgumentException("index_0 have no parent.");
        }
        return (index - 1 ) / 2;
    }

    //    返回完全二叉树的数组表示中，一个索引所表示的节点的父亲节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //    返回完全二叉树的数组表示中，一个索引所表示的节点的父亲节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    // 看堆中最大的元素
    public E findMax(){
        if (data.getSize() == 0){
            throw new IllegalArgumentException("Empty!");
        }
        return data.get(0);
    }

    // 取出堆中最大的元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }


}
