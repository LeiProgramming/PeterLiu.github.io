package com.DataStructure.MaxHeap;

import com.DataStructure.Queue.Queue;

/**
 * @author Peter
 */
@SuppressWarnings("all")
public class PriortyQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;
    public PriortyQueue(){
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }
}
