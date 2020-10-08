package data_structures.search_trees.splay_trees;

public class SplayNode<K extends Comparable<K>> implements Comparable<K> {
    K data;

    SplayNode<K> left;
    SplayNode<K> right;
    SplayNode<K> parent;

    public SplayNode(K key) {
        this.setData(key);
        this.setRight(null);
        this.setLeft(null);
        this.setParent(null);
    }

    public void setData(K data) {
        this.data = data;
    }

    public void setRight(SplayNode<K> right) {
        this.right = right;
        if(this.right != null) {
            right.setParent(this);
        }
    }

    public void setLeft(SplayNode<K> left) {
        this.left = left;
        if(this.left != null) {
            this.left.setParent(this);
        }

    }

    public void setParent(SplayNode<K> parent) {
        this.parent = parent;
    }

    public SplayNode<K> getParent() {
        return parent;
    }

    public K getData() {
        return data;
    }

    public SplayNode<K> getRight() {
        return right;
    }

    public SplayNode<K> getLeft() {
        return left;
    }

    public boolean hasParent() {
        return this.parent != null;
    }

    public boolean hasGrand() {
        return this.hasParent() && this.parent.hasParent();
    }

    @Override
    public int compareTo(K o) {
        return getData().compareTo(o);
    }

    public boolean parentHigh() {
        return this.compareTo(this.getParent().getData()) < 0;
    }

    public boolean parentLow() {
        return this.compareTo(this.getParent().getData()) < 0;
    }

    public SplayNode<K> getGrand() {
        return this.getParent().getParent();
    }

    public boolean grandHigh() {
        return this.compareTo(this.getGrand().getData()) < 0;
    }
    public boolean grandLow() {
        return this.compareTo(this.getGrand().getData()) < 0;
    }

    public boolean hasLeftOnly() {
        return this.left != null && this.right == null;
    }

    public boolean hasRightOnly() {
        return this.left == null && this.right != null;
    }


    void addChild(SplayNode<K> child) {
        if(this.compareTo(child.getData()) < 0) {
            this.setRight(child);
        } else if(this.compareTo(child.getData()) > 0) {
            this.setLeft(child);
        } else {

        }
//        child.setParent(this);
    }
}
