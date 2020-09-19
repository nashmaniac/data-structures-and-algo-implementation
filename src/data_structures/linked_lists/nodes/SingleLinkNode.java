package data_structures.linked_lists.nodes;

public class SingleLinkNode<E> {
    E value;
    SingleLinkNode<E> next;

    public SingleLinkNode(E value, SingleLinkNode<E> next) {
        this.value = value;
        this.next = next;
    }

    public SingleLinkNode(E value) {
        this(value, null);
    }

    public E getValue() {
        return this.value;
    }

    public SingleLinkNode<E> getNext() {
        return this.next;
    }

    public void setNext(SingleLinkNode<E> next) {
        this.next = next;
    }
}
