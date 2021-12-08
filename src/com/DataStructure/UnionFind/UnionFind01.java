package com.DataStructure.UnionFind;

import org.junit.jupiter.api.Test;

/**
 * @author Peter
 */
public class UnionFind01 implements UF{

    private int[] id;
    public UnionFind01(int size){
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int find(int p){
        return id[p];
    }
    @Override
    public boolean isConnected(int p, int q) {
       return find(p) == find(q);
    }

    //合并元素p和元素q所在的集合
    @Override
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        if (pID == qID){
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID){
                id[i] = qID;
            }
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
