package com.DataStructure.UnionFind;

/**
 * @author Peter
 */
public class UnionFind06 implements UF{

    private int[] parent;
    private int[] rank;

    public UnionFind06(int size){
        parent = new int[size];

        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    private int find(int p){
        if (p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];
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
