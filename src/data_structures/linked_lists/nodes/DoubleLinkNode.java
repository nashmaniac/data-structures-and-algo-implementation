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
}
