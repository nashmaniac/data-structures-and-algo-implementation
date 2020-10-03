package data_structures.search_trees.implementations;

import data_structures.search_trees.classes.TreeNode;
import data_structures.search_trees.interfaces.SearchTreeInterface;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BinarySearchTree<K, V> implements SearchTreeInterface<TreeNode<K, V>, K, V>, Comparator<K> {

    TreeNode<K, V> root;

    public BinarySearchTree() {
        this.setRoot(null);
    }

    public void setRoot(TreeNode<K, V> root) {
        this.root = root;
    }

    @Override
    public void insert(K key, V value) {
        this.insert(new TreeNode<K, V>(key, value));
    }

    @Override
    public void insert(TreeNode<K,V> node) {
        if(this.isEmpty()) {
            this.root = node;
            return;
        }

        TreeNode<K, V> p = this.find(node.getKey(), this.root);

        node.setParent(p);
        if(compare(node.getKey(), p.getKey())<0) {
            p.setLeft(node);
        }

        if(compare(node.getKey(), p.getKey())>0) {
            p.setRight(node);
        }
    }

    public TreeNode<K, V> getRoot() {
        return root;
    }

    @Override
    public boolean isEmpty() {
        return this.root == null;
    }

    @Override
    public TreeNode<K, V> find(K key, TreeNode<K, V> root) {
        if(key.equals(root.getKey())) {
            return root;
        }
        if (root.getLeft() != null && compare(key, root.getKey()) < 0) {
            return find(key, root.getLeft());
        }

        if (root.getRight() != null && compare(key, root.getKey()) > 0) {
            return find(key, root.getRight());
        }
        return root;

    }

    private void preOrder(TreeNode<K, V> node) {
        if(node == null){
            return;
        }
        preOrder(node.getLeft());
        System.out.print(node.getKey()+ " ");
        preOrder(node.getRight());

    }

    @Override
    public void print(String mode) {
        if(mode.equals("pre")) {
            preOrder(this.root);
            System.out.println();
        }
    }


    private TreeNode<K, V> LeftAscend(TreeNode<K, V> node){
        if(node.getParent() != null && compare(node.getParent().getKey(), node.getKey()) > 0) {
            return node.getParent();
        } else {
            if(node.getParent() != null){
                return LeftAscend(node.getParent());
            }
            return node;

        }
    }


    @Override
    public TreeNode<K, V> Next(TreeNode<K, V> node) {
        if(node.getRight() != null) {
            return minimum(node.getRight());
        } else {
            return this.LeftAscend(node);
        }
    }

    @Override
    public TreeNode<K, V> minimum(TreeNode<K, V> node) {
        while(node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public TreeNode<K, V> maximum(TreeNode<K, V> node) {
        while(node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    @Override
    public List<TreeNode<K, V>> rangeSearch(K start, K end) {
        TreeNode<K, V> startNode = this.find(start, this.root);
        TreeNode<K, V> prevNode = this.find(start, this.root);
        List<TreeNode<K, V>> nodeList = new ArrayList<>();
        while (startNode != null && compare(startNode.getKey(), prevNode.getKey()) >= 0 && compare(startNode.getKey(), end) <= 0) {
            if(compare(startNode.getKey(), start) >= 0) {
                nodeList.add(startNode);
            }
            prevNode = startNode;
            startNode = Next(startNode);
        }
        return nodeList;
    }

    @Override
    public int height(TreeNode<K, V> node) {
        if(node == null) {
            return 0;
        }
        return 1+Math.max(this.height(node.getLeft()), this.height(node.getRight()));
    }


    private void deleteNode(TreeNode<K, V> node) {
        if(!node.hasChildren()) {

            TreeNode<K, V> parent = node.getParent();
            if(parent.getRight()!= null && compare(parent.getRight().getKey(), node.getKey()) == 0) {
                parent.setRight(null);
            }
            if(parent.getLeft()!=null && compare(parent.getLeft().getKey(), node.getKey()) == 0) {
                parent.setLeft(null);
            }
            node = null;
            return;
        }

        if(!node.hasLeft()) {
            node.setValue(node.getRight().getValue());
            node.setKey(node.getRight().getKey());
            this.deleteNode(node.getRight());
            return;
        }

        if(!node.hasRight()) {
            node.setValue(node.getLeft().getValue());
            node.setKey(node.getLeft().getKey());
            this.deleteNode(node.getLeft());
            return;
        }

        // at this point both are satisfied

        // find left most
        TreeNode<K, V> minElem = this.minimum(node.getRight());

        node.setKey(minElem.getKey());
        node.setValue(minElem.getValue());

        deleteNode(minElem);



    }

    @Override
    public void delete(K key) {
        TreeNode<K, V> node = this.find(key, this.root);
        if(compare(node.getKey(), key) == 0) {
            this.deleteNode(node);
        }
    }

    @Override
    public int compare(K o1, K o2) {
        Integer k1 = Integer.valueOf(o1.toString());
        Integer k2 = Integer.valueOf(o2.toString());
        return k1.compareTo(k2);
    }
}
