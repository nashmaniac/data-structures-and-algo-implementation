package data_structures.search_trees.splay_trees;

public class SplayTree<K extends Comparable<K>> implements SplayTreeInterface<SplayNode<K>, K> {

    SplayNode<K> root = null;

    @Override
    public void insert(K key) {
        SplayNode<K> parent = findParent(this.root, key);
        SplayNode<K> child = new SplayNode<>(key);
        if(parent == null) {
            this.root = child;
        } else {
            parent.addChild(child);
            this.root = splay(child);
        }

    }

    private SplayNode<K> zigzigRightTurn(SplayNode<K> x) {
        SplayNode<K> zParent = x.getGrand().getParent();
        SplayNode<K> z = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getRight();
        SplayNode<K> t3 = y.getRight();
        x.setParent(zParent);
        x.setRight(y);
        y.setRight(z);
        y.setLeft(t2);
        z.setLeft(t3);
        return x;
    }

    private SplayNode<K> zigzigLeftTurn(SplayNode<K> x) {
        SplayNode<K> zParent = x.getGrand().getParent();
        SplayNode<K> z = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getRight();
        SplayNode<K> t3 = y.getLeft();
        x.setParent(zParent);
        x.setLeft(y);
        y.setLeft(z);
        y.setRight(t3);
        z.setRight(t2);
        return x;
    }

    private SplayNode<K> zigzagRightTurn(SplayNode<K> x) {
        SplayNode<K> zParent = x.getGrand().getParent();
        SplayNode<K> z = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getLeft();
        SplayNode<K> t3 = x.getRight();
        x.setParent(zParent);
        x.setLeft(y);
        x.setRight(z);
        y.setRight(t2);
        z.setLeft(t3);
        return x;
    }

    private SplayNode<K> zigzagLeftTurn(SplayNode<K> x) {
        SplayNode<K> zParent = x.getGrand().getParent();
        SplayNode<K> z = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getLeft();
        SplayNode<K> t3 = x.getRight();
        x.setParent(zParent);
        x.setLeft(z);
        x.setRight(y);
        y.setLeft(t3);
        z.setRight(t2);
        return x;
    }

    private SplayNode<K> zigRight(SplayNode<K> x) {
        SplayNode<K> yParent = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getRight();

        x.setParent(yParent);
        x.setRight(y);
        y.setLeft(t2);

        return x;
    }

    private SplayNode<K> zigLeft(SplayNode<K> x) {
        SplayNode<K> yParent = x.getGrand();
        SplayNode<K> y = x.getParent();
        SplayNode<K> t2 = x.getLeft();

        x.setParent(yParent);
        x.setLeft(y);
        y.setRight(t2);

        return x;
    }

    private SplayNode<K> splay(SplayNode<K> node) {
        while (node.hasParent()) {
            // first check if has grand parent zig zig case
            if(node.hasGrand()) {
                if(node.parentHigh()) {
                    if(node.grandHigh()) {
                        // x < y < z
                        node = zigzigRightTurn(node);
                    } else {
                        // z < x < y
                        node = zigzagLeftTurn(node);
                    }
                } else {
                    if(node.grandHigh()) {
                        // y < x < z
                        node = zigzagRightTurn(node);
                    } else {
                        // x > y > z
                        node = zigzigLeftTurn(node);
                    }
                }
            } else {
                if(node.parentHigh()) {
                    node = zigRight(node);
                } else {
                    node = zigLeft(node);
                }
            }
        }
        return node;
    }

    private SplayNode<K> findParent(SplayNode<K> node, K key) {
        if (node == null) {
            return null;
        }
        if(node.compareTo(key) < 0) {
            if(node.right != null) {
                return findParent(node.right, key);
            } else {
                return node;
            }
        } else if(node.compareTo(key) > 0) {
            if(node.left != null) {
                return findParent(node.left, key);
            } else {
                return node;
            }
        } else {
            // do nothing
        }
        return node;
    }

    private SplayNode<K> find(SplayNode<K> node, K key) {
        if (node == null) {
            return null;
        }
        if(node.compareTo(key) < 0) {
            if(node.right != null) {
                return find(node.right, key);
            } else {
                return node;
            }
        } else if(node.compareTo(key) > 0) {
            if(node.left != null) {
                return find(node.left, key);
            } else {
                return node;
            }
        } else {
            return node;
        }
    }



    @Override
    public void display() {
        System.out.println("-------------------");
        this.display(this.root);
    }

    @Override
    public SplayNode<K> find(K key) {
        SplayNode<K> node = find(this.root, key);
        this.root = splay(node);
        return this.root;
    }

    @Override
    public void delete(K key) {
        SplayNode<K> node = find(this.root, key);
        this.root = splay(node);
        if(this.root.compareTo(key) == 0) {
            if(this.root.hasLeftOnly()) {
                this.root = this.root.left;
                this.root.setParent(null);
                return;
            }

            if(this.root.hasRightOnly()) {
                this.root = this.root.right;
                this.root.setParent(null);
                return;
            }

            SplayNode<K> rightChild = this.root.getRight();
            SplayNode<K> leftChild = this.root.getLeft();
            this.root = splay(maximum(leftChild));
            this.root.setRight(rightChild);
            this.root.setParent(null);
            return;
        }
    }


    private SplayNode<K> maximum(SplayNode<K> node) {
        while (node.getRight()!=null) {
            node = node.getRight();
        }
        return node;
    }

    private void display(SplayNode<K> node) {
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
}
