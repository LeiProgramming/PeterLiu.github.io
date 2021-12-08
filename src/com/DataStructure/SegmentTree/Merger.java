package com.DataStructure.SegmentTree;

/**
 * @author Peter
 */
public interface Merger<E> {
    E merge(E a, E b);
}
