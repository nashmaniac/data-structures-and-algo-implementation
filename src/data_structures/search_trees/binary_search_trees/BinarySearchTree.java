package data_structures.search_trees.binary_search_trees;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<K extends Comparable<K>> implements BinarySearchTreeInterface<Node, K>{

    Node<K> root;
    int nodeCount = 0;


    public BinarySearchTree() {
        this.root = null;
        this.nodeCount = 0;
    }


    @Override
    public void insert(K key) {
        this.root = insert(this.root, key);
    }


    private Node<K> insert(Node<K> node, K key) {
        if(node == null) {
            // reached to a leaf
            Node<K> nn = new Node<>(key);
            this.nodeCount++;
            return nn;
        }
        if (node.compareTo(key) < 0) {
            // current node key is less than new key
            node.setRight(insert(node.right, key));
        } else if(node.compareTo(key) > 0) {
            // current node key is less than new key
            node.setLeft(insert(node.left, key));
        } else {
            // don't insert duplicate nodes;
        }
        return node;
    }

    @Override
    public void delete(K key) {
        if(this.contains(key)) {
            this.root = delete(this.root, key);
        }
    }


    private Node<K> delete(Node<K> node, K key) {
        if(node.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else if(node.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else {
            // found our boy
            if(node.isLeaf()) {
                node = null;
            } else if(node.hasLeft()) {
                node = node.getLeft();
            } else if (node.hasRight()) {
                node = node.getRight();
            } else {
                Node<K> temp = this.minimum(node.right);
                node.setData(temp.data);
                node.right = this.delete(node.right, temp.data);
            }
            this.nodeCount--;
        }
        return node;
    }



    @Override
    public boolean contains(K key) {
        return this.contains(this.root, key);
    }

    private boolean contains(Node<K> node, K key) {
        if(node == null) {
            return false;
        }

        if(node.compareTo(key) < 0) {
            return contains(node.right, key);
        } else if(node.compareTo(key) > 0) {
            return contains(node.left, key);
        } else {
            return true;
        }
    }

    @Override
    public Node<K> maximum() {
        return this.maximum(this.root);
    }

    private Node<K> maximum(Node<K> node) {
        while (node.getRight()!=null) {
            node = node.getRight();
        }
        return node;
    }

    @Override
    public Node<K> minimum() {
        return minimum(this.root);
    }

    private Node<K> minimum(Node<K> node) {
        while (node.getLeft()!=null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public void display() {
        this.display(this.root);
    }

    private void display(Node<K> node) {
        System.out.print(node.getLeft() == null ? "." : node.getLeft().getData().toString());
        System.out.print(" ==> ");
        System.out.print(node.getData().toString());
        System.out.print(" <== ");
        System.out.print(node.getRight() == null ? "." : node.getRight().getData().toString());
        System.out.println();
        if(node.getLeft() != null) {
            display(node.getLeft());
        }
        if (node.getRight() != null) {
            display(node.getRight());
        }
    }

    public List<K> inOrder() {
        return inOrder(this.root, new ArrayList<K>());
    }

    private List<K> inOrder(Node<K> node, List<K> nodeList) {
        if(node == null) {
            return null;
        }
        inOrder(node.left, nodeList);
        nodeList.add(node.getData());
        inOrder(node.right,nodeList);
        return nodeList;
    }

    public List<K> postOrder() {
        return this.postOrder(this.root, new ArrayList<K>());
    }

    private List<K> postOrder(Node<K> node, List<K> nodeList) {
        if(node == null) {
            return null;
        }
        postOrder(node.left, nodeList);
        postOrder(node.right, nodeList);
        nodeList.add(node.getData());
        return nodeList;

    }

    public List<K> preOrder() {
        return this.preOrder(this.root, new ArrayList<>());
    }

    private List<K> preOrder(Node<K> node, List<K> nodeList) {
        if(node == null) {
            return null;
        }
        nodeList.add(node.getData());
        preOrder(node.left, nodeList);
        preOrder(node.right, nodeList);
        return nodeList;
    }
}
