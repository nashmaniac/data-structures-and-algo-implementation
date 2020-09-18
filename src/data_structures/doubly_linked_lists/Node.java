package data_structures.doubly_linked_lists;

public class Node {
    int value;
    Node next;
    Node prev;

    Node(int value, Node next, Node prev) {
        this.prev = prev;
        this.next = next;
        this.value = value;
    }
}
