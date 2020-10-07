package data_structures.search_trees.avl_trees;

public class AVLTree<K extends Comparable<K>> implements AVLTreeInterface<AVLNode<K>, K> {
    AVLNode<K> root;
    int nodeCount;

    public AVLTree() {
        this.root = null;
        this.nodeCount = 0;
    }

    @Override
    public void insert(K key) {
        this.root = insert(this.root, key);
    }

    private AVLNode<K> insert(AVLNode<K> node, K key) {
        if (node == null) {
            AVLNode<K> nn = new AVLNode<>(key);
            this.nodeCount++;
            return nn;
        }
        if(node.compareTo(key) < 0) {
            node.right = insert(node.right, key);
        } else if(node.compareTo(key) > 0) {
            node.left = insert(node.left, key);
        } else {

        }
        update(node);
        return rebalance(node);
    }

    private AVLNode<K> rebalance(AVLNode<K> node) {
        if(node.getBf() >= 2) {
            // get left heavy
            if(node.left.getBf() >= 0) {
                // get left left rotation
                return rightRotation(node);
            } else {
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }

        if(node.getBf() <= -2) {
            if(node.right.getBf() <= 0) {
                // get right right rotation
                return leftRotation(node);
            } else {
                // get right left rotation
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        return node;
    }

    private AVLNode<K> leftRotation(AVLNode<K> a) {
        AVLNode<K> b = a.getRight();
        AVLNode<K> t2 = b.getLeft();

        b.setLeft(a);
        a.setRight(t2);

        a.setHeight();
        b.setHeight();

        a.setBf();
        b.setBf();


        return b;
    }

    private AVLNode<K> rightRotation(AVLNode<K> c) {
        AVLNode<K> b = c.getLeft();
        AVLNode<K> t3 = b.getRight();

        c.setLeft(t3);
        b.setRight(c);

        c.setHeight();
        b.setHeight();

        c.setBf();
        b.setBf();

        return b;
    }

    void update(AVLNode<K> node) {
        node.setHeight();
        node.setBf();
    }

    @Override
    public void delete(K key) {
        if(contains(key)) {
            this.root = delete(this.root, key);
        }
    }

    private AVLNode<K> delete(AVLNode<K> node, K key) {
        if(node.compareTo(key) < 0) {
            node.right = delete(node.right, key);
        } else if(node.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else {
            // find the boy
            if(node.isLeaf()) {
                node = null;
            } else if(node.hasLeft()) {
                node = node.getLeft();
            } else if (node.hasRight()) {
                node = node.getRight();
            } else {
                AVLNode<K> temp = this.maximum(node.left);
                node.data = temp.data;
                node.left = delete(node.left, temp.data);
            }
        }
        this.nodeCount++;
        if(node != null) {
            update(node);
            return rebalance(node);
        }
        return node;
    }


    @Override
    public boolean contains(K key) {
        return contains(this.root, key);
    }

    private boolean contains(AVLNode<K> node, K key) {
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
    public AVLNode<K> maximum() {
        return this.maximum(this.root);
    }

    private AVLNode<K> maximum(AVLNode<K> node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    @Override
    public AVLNode<K> minimum() {
        return this.minimum(this.root);
    }

    private AVLNode<K> minimum(AVLNode<K> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    @Override
    public void display() {
        System.out.println("----------------------------");
        this.display(this.root);
    }

    private void display(AVLNode<K> node) {
        System.out.print(node.getLeft() == null ? "." : node.getLeft().getData().toString() + "("+node.getLeft().getHeight()+ " " + node.getLeft().getBf() + ")");
        System.out.print(" ==> ");
        System.out.print(node.getData().toString()+ "("+node.getHeight()+ " " + node.getBf() +")");
        System.out.print(" <== ");
        System.out.print(node.getRight() == null ? "." : node.getRight().getData().toString()+ "("+node.getRight().getHeight()+ " " + node.getRight().getBf() +")");
        System.out.println();
        if(node.getLeft() != null) {
            display(node.getLeft());
        }
        if (node.getRight() != null) {
            display(node.getRight());
        }
    }
}
