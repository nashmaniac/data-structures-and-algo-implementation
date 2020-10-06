package data_structures.search_trees.binary_search_trees;

public class Node<K extends Comparable<K>> implements Comparable<K> {
    K data;
    Node<K> left = null;
    Node<K> right = null;


    public Node(K key) {
        this.setData(key);
    }

    public void setData(K data) {
        this.data = data;
    }

    public Node<K> getLeft() {
        return left;
    }

    public Node<K> getRight() {
        return right;
    }

    public void setLeft(Node<K> left) {
        this.left = left;
    }

    public void setRight(Node<K> right) {
        this.right = right;
    }

    public K getData() {
        return data;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasLeft() {
        return this.left != null && this.right == null;
    }

    public boolean hasRight() {
        return this.right != null && this.left == null;
    }

    @Override
    public int compareTo(K o) {
        return getData().compareTo(o);
    }
}
