package com.DataStructure.Set;

/**
 * @author Peter
 */
public interface Set<E>{
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
