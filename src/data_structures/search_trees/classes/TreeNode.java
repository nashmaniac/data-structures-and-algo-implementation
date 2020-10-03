package data_structures.search_trees.classes;

public class TreeNode<K, V> {
    K key;
    V value;

    TreeNode<K, V> left = null;
    TreeNode<K, V> right = null;
    TreeNode<K, V> parent = null;


    public TreeNode(K key, V value) {
        this.setKey(key);
        this.setValue(value);
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public TreeNode<K, V> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<K, V> left) {
        this.left = left;
    }

    public TreeNode<K, V> getRight() {
        return right;
    }

    public void setRight(TreeNode<K, V> right) {
        this.right = right;
    }

    public void setParent(TreeNode<K, V> parent) {
        this.parent = parent;
    }

    public TreeNode<K, V> getParent() {
        return parent;
    }


    public boolean hasLeft() {
        return this.left != null;
    }

    public boolean hasRight() {
        return this.right != null;
    }

    public boolean hasChildren() {
        return hasLeft() || hasRight();
    }

}
