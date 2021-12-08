package com.DataStructure.UnionFind;

/**
 * @author Peter
 */
public class UnionFind03 implements UF{

    private int[] parent;

    public UnionFind03(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
        }
    }

    private int find(int p){
        while (p != parent[p]){
            p = parent[p];
        }
        return p;
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot){
            return;
        }
        parent[pRoot] = qRoot;
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
