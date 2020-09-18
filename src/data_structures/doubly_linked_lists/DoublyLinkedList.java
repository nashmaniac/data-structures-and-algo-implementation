package data_structures.doubly_linked_lists;

import java.util.Scanner;

public class DoublyLinkedList {
    int size;
    Node head;
    Node tail;

    DoublyLinkedList(Node head, Node tail, int size) {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    public int size() {
        // O(1) implementation
        return this.size;
    }

    public int size_n() {
        // O(n) implementation
        int s = 0;
        Node current = this.head;
        while (current!=null) {
            s += 1;
            current = current.next;
        }
        return s;
    }

    public void push_front(int value) {
        Node n = new Node(value, null, null);
        if(this.size == 0) {
            this.head = n;
            this.tail = n;
            this.size += 1;
            return;
        }

        n.next = this.head;
        this.head.prev = n;
        this.head = n;
        this.size += 1;
    }

    public void push_back(int value) {
        Node n = new Node(value, null, null);
        if(this.size == 0) {
            this.head = n;
            this.tail = n;
            this.size += 1;
            return;
        }

        this.tail.next = n;
        n.prev = this.tail;
        this.tail = n;
        this.size += 1;
    }




    public boolean empty() {
        return this.head == null;
    }

    public int value_at(int index) {
        // O(n) implementation
        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index -= 1;
        }
        return current.value;
    }

    public void print() {
        // O(n) implementation
        Node current = this.head;
        System.out.println("Size: " + this.size());
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void print(Node a) {
        // O(n) implementation
        Node current = a;
        System.out.println("Size: " + this.size());
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }



    public int front() {
        if(this.head == null) {
            return -1;
        }
        return this.head.value;
    }
    public int back() {
        if(this.tail == null) {
            return -1;
        }
        return this.tail.value;
    }

    public void pop_front() {
        if(this.size == 0) {
            return;
        }
        if(this.size == 1) {
            this.head = this.head.next;
            this.tail = this.head;
            this.size -= 1;
            return;
        }

        this.head.next.prev = this.head.prev;
        this.head = this.head.next;
        this.size -= 1;
    }

    public void pop_back() {
        if(this.size == 0) {
            return;
        }
        if(this.size == 1) {
            this.tail = this.tail.prev;
            this.head = this.tail;
            this.size -= 1;
            return;
        }
        this.tail.prev.next = this.tail.next;
        this.tail = this.tail.prev;
        this.size -= 1;
    }

    public void erase(int index) {
        if(this.size == 0) {
            return;
        }
        if(index == 0) {
//            Node current = this.head;
            this.head.next.prev = null;
            this.head = this.head.next;
            this.size -= 1;
            return;
        }

        Node current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.next;
        }
        current.next = current.next.next;
        this.size -= 1;

        if(index == this.size) {
            this.tail = current;
        }
        return;
    }


    public void insert(int index, int value) {
        // O(n) implementation
        Node n = new Node(value, null, null);
        if(index == 0) {
            n.next = this.head;
            this.head.prev = n;
            this.head = n;
            this.size += 1;
            return;
        }
        if(index == this.size() -1) {
            this.tail.next = n;
            n.prev = this.tail;
            this.tail = n;
            this.size += 1;
            return;
        }

        Node current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.next;
        }

        n.next = current.next;
        current.next.prev = n;
        current.next = n;
        n.prev = current;
        this.size += 1;
        return;
    }

    public void reverse() {
        // O(n) implementation
        Node current = this.head;
        this.tail = current;
        Node prev = null;
        while (current != null) {
            Node next = current.next;


            current.next = prev;
            if(prev!=null) {
                prev.prev = current;
            }

            prev = current;
            current = next;
        }
        this.head = prev;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList l = new DoublyLinkedList(null, null, 0);
        String command = "s";
        while (!command.equals("q")) {
            command = scanner.next();
            if ("size".equals(command)) {
                System.out.println(l.size());
            }

            if ("size_n".equals(command)) {
                System.out.println(l.size_n());
            }

            if ("empty".equals(command)) {
                System.out.println(l.empty());
            }
            if ("back".equals(command)) {
                System.out.println(l.back());
            }
            if ("front".equals(command)) {
                System.out.println(l.front());
            }
            if ("pop_front".equals(command)) {
                l.pop_front();
            }
            if ("pop_back".equals(command)) {
                l.pop_back();
            }
            if ("reverse".equals(command)) {
                l.reverse();
            }


            if ("push_front".equals(command)) {
                int value = scanner.nextInt();
                l.push_front(value);
            }

            if ("push_back".equals(command)) {
                int value = scanner.nextInt();
                l.push_back(value);
            }

            if ("value_at".equals(command)) {
                int value = scanner.nextInt();
                System.out.println(l.value_at(value));
            }
            if ("erase".equals(command)) {
                int value = scanner.nextInt();
                l.erase(value);
            }

            if ("insert".equals(command)) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                l.insert(index, value);
            }










            l.print();
        }
    }
}
