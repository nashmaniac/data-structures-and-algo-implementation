package data_structures.linked_lists.nodes;

public class DoubleLinkNode<E> {
    E value;
    DoubleLinkNode<E> next;
    DoubleLinkNode<E> prev;


    public DoubleLinkNode(E value) {
        this(value, null, null);
    }
    public DoubleLinkNode(E value, DoubleLinkNode<E> next, DoubleLinkNode<E> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }

    public void setValue(E value) {
        this.value = value;
    }

    public E getValue() {
        return value;
    }

    public void setNext(DoubleLinkNode<E> node) {
        this.next = node;
    }
    public void setPrev(DoubleLinkNode<E> node) {
        this.prev = node;
    }

    public DoubleLinkNode<E> getNext() {
        return this.next;
    }
    public DoubleLinkNode<E> getPrev() {
        return this.prev;
    }


}
