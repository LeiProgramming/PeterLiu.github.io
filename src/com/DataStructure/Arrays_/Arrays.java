package com.DataStructure.Arrays_;

/**
 * @author Peter
 */

@SuppressWarnings({"all"})
public class Arrays<E> {

    private E[] data;
    private int size;

//    构造函数，传入数组的容量capacity构造Array
    public Arrays(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }
//     无参数的构造函数，默认数组的容量capacity=10
    public Arrays(){
        this(10);
    }

    public int getCapacity(){
        return data.length;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        }

        if (size == data.length){
                resize(2 * data.length);
        }

        for (int i = size - 1; i >= index; i--){
            data[i + 1] = data[i];
        }

        data[index] = e;

        size++;
    }

    public void addLast(E e){
        add(size, e);
    }

    public void addFirst(E e){
        addFirst(e);
    }

    public E get(int index){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }

        return data[index];
    }

    public void set(int index, E e){
        if (index < 0 || index > size){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");

        }
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(E e){
        for(int i = 0 ; i < size ; i ++){
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    public E remove(int index){
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Index is illegal.");

        E ret = data[index];
        for(int i = index + 1 ; i < size ; i ++)
            data[i - 1] = data[i];
        size --;
        data[size] = null; // loitering objects != memory leak

        if(size == data.length / 2)
            resize(data.length / 2);
        return ret;
    }

    // 从数组中删除第一个元素, 返回删除的元素
    public E removeFirst(){
        return remove(0);
    }

    // 从数组中删除最后一个元素, 返回删除的元素
    public E removeLast(){
        return remove(size - 1);
    }

    // 从数组中删除元素e
    public void removeElement(E e){
        int index = find(e);
        if(index != -1)
            remove(index);
    }
    public void swap(int i, int j){
        if (i < 0 || i >= size || j < 0 || j>= size){
            throw new IllegalArgumentException("index invalied");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }
    @Override
    public String toString(){

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for(int i = 0 ; i < size ; i ++){
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }

    // 将数组空间的容量变成newCapacity大小
    private void resize(int newCapacity){

        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0 ; i < size ; i ++)
            newData[i] = data[i];
        data = newData;
    }


}
