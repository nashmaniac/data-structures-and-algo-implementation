package data_structures.search_trees.avl_trees;

public class AVLNode<K extends Comparable<K>> implements Comparable<K> {
    K data;

    int bf;
    int height;
    AVLNode<K> left;
    AVLNode<K> right;

    public AVLNode(K key) {
        this.data = key;
        this.left = null;
        this.right = null;
        this.setHeight();
        this.setBf();
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasLeft() {
        return this.left != null && this.right == null;
    }

    public boolean hasRight() {
        return this.left == null && this.right != null;
    }

    public void setLeft(AVLNode<K> left) {
        this.left = left;
    }

    public AVLNode<K> getLeft() {
        return left;
    }

    public void setRight(AVLNode<K> right) {
        this.right = right;
    }

    public AVLNode<K> getRight() {
        return right;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setHeight() {
        this.height = 1+Math.max(this.left == null ? 0 : this.left.height, this.right == null ? 0: this.right.height);
    }

    public void setBf() {
        this.bf = (this.left == null ? 0 : this.left.getHeight()) - (this.right == null ? 0 : this.right.getHeight());
    }

    public int getHeight() {
        return height;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public int getBf() {
        return bf;
    }



    public K getData() {
        return data;
    }

    @Override
    public int compareTo(K o) {
        return getData().compareTo(o);
    }
}
