package com.DataStructure.BST;

import java.util.Stack;

import com.DataStructure.Queue.ArrayQueue;

/**
 * @author Peter
 */
@SuppressWarnings("all")

public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left;
        public Node right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else
            add(root, e);
    }

//    向以node为根的二分搜索树插入元素e
//    private void add(Node node, E e){
//        if (e.equals(node.e)){
//            return;
//        }
//        else if(e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new Node(e);
//            size ++;
//            return;
//        }
//        else if (e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new Node(e);
//            size ++;
//            return;
//        }
//
//        if (e.compareTo(node.e) < 0){
//            add(node.left, e);
//        }
//        else //(e.compareTo(node.e) > 0)
//            add(node.right, e);
//    }

    //      改进后的递归
    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else
            return true;
    }

    //    前序遍历
    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //    中序遍历 元素从小到大
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //    后序遍历
    public void postOrder() {
        inOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //    前序遍历的非递归实现 深度优先遍历
    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null)
                stack.push(cur.right);
            if (cur.left != null)
                stack.push(cur.left);
        }
    }

    public void levelOrder() {
        ArrayQueue<Node> queue = new ArrayQueue<>();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            Node cur = queue.dequeue();
            System.out.println(cur.e);
            if (cur.left != null) {
                queue.enqueue(cur.left);
            }
            if (cur.right != null) {
                queue.enqueue(cur.right);
            }
        }

    }

    // 寻找二分搜索树的最小元素
    public E minimum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

//        Node minNode = minimum(root);
//        return minNode.e;
        return minimum(root).e;
    }

    // 返回以node为根的二分搜索树的最小值所在的节点
    private Node minimum(Node node) {
        if (node.left == null)
            return node;

        return minimum(node.left);
    }

    // 寻找二分搜索树的最大元素
    public E maximum() {
        if (size == 0)
            throw new IllegalArgumentException("BST is empty");

        return maximum(root).e;
    }

    // 返回以node为根的二分搜索树的最大值所在的节点
    private Node maximum(Node node) {
        if (node.right == null)
            return node;

        return maximum(node.right);
    }

    // 从二分搜索树中删除最小值所在节点, 返回最小值
    public E removeMin() {
        E ret = minimum();
        root = removeMin(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    // 从二分搜索树中删除最大值所在节点
    public E removeMax() {
        E ret = maximum();
        root = removeMax(root);
        return ret;
    }

    // 删除掉以node为根的二分搜索树中的最大节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMax(Node node) {

        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }
//  二分搜索树删除任意值
    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if (node == null){
            return null;
        }

        if (e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
            return node;
        }
        else if (e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
            return node;
        }
        else {
//            待删除节点左子树为空
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
//            待删除节点的右子树为空
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

//          待删除左右节点都不为空
//          找到比待删除节点大的最小节点，也就是待删除节点右子树的最小节点
//          用这个节点代替待删除节点的位置
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;

            node.left = node.right = null;
            return successor;
        }
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}

class Test {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();

        int[] arr = {5, 3, 6, 8, 4, 2};
        for (int i :
                arr) {
            bst.add(i);
        }
        bst.inOrder();
        bst.postOrder();
        System.out.println("===================");
        bst.levelOrder();
    }
}
