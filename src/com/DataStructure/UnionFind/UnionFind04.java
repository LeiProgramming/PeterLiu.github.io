package com.DataStructure.UnionFind;

/**
 * @author Peter
 */
public class UnionFind04 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind04(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
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

        if (rank[pRoot] < rank[qRoot]){
            parent[pRoot] = qRoot;
        }
        else if (rank[pRoot] > rank[qRoot]){
            parent[qRoot] = pRoot;
        }
        else{
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }

    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
