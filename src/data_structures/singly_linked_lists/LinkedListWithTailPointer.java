package data_structures.singly_linked_lists;

import java.util.Scanner;

public class LinkedListWithTailPointer {
    Node tail;
    Node head;
    int size = 0;

    LinkedListWithTailPointer(Node head, Node tail, int size) {
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
        while (current != null) {
            s += 1;
            current = current.next;
        }
        return s;
    }

    public boolean empty() {
        // O(1) implementation
        return this.head == null;
    }

    public void push_front(int value) {
        // O(1) implementation
        Node n = new Node(value, null);
        if(this.size == 0) {
            this.head = n;
            this.tail = n;
            this.size += 1;
            return;
        }

        n.next = this.head;
        this.head = n;
        this.size += 1;
    }

    public void push_back(int value) {
        // O(1) implementation
        Node n = new Node(value, null);
        if(this.size == 0) {
            this.head = n;
            this.tail = n;
            this.size += 1;
            return;
        }

        tail.next = n;
        tail = n;
        this.size += 1;
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

    public int pop_front() {
        // O(1) implementation
        Node current = this.head;
        this.size -= 1;
        this.head = this.head.next;
        if(this.size == 1) {
            this.tail = this.head;
        }
        return current.value;
    }

    public int pop_back() {
        // O(n) implementation
        if (this.head == null) {
            return -1;
        }
        if (this.size <= 1) {
            int value = this.head.value;
            this.head = null;
            this.size -= 1;
            return value;
        }
        // O(n) implementation
        Node current = this.head;
        while (current.next.next!=null) {
            current = current.next;
        }
        int value = current.next.value;
        current.next = null;
        this.tail = current;
        this.size -= 1;
        if(this.size == 1) {
            this.head = current;
        }
        return value;
    }

    public int front() {
        // O(1) implementation
        if(this.head == null) {
            return -1;
        }
        return this.head.value;
    }

    public int back() {
        // O(1) implementation
        if(this.tail == null) {
            return -1;
        }
        return this.tail.value;
    }

    public void insert(int index, int value) {
        // O(n) implementation
        Node n = new Node(value, null);
        if(index == 0) {
            n.next = this.head;
            this.head = n;
            this.size += 1;
            return;
        }
        if(index == this.size() -1) {
            this.tail.next = n;
            this.tail = n;
            this.size += 1;
            return;
        }

        Node current = this.head;
        for(int i=0;i<index-1;i++) {
            current = current.next;
        }

        n.next = current.next;
        current.next = n;
        this.size += 1;
        return;
    }

    public void erase(int index) {
        if(this.size == 0) {
            return;
        }
        if(index == 0) {
//            Node current = this.head;
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

    public int value_n_from_end(int n) {
        // O(n) implementation
        Node first = this.head;
        Node second = this.head;
        for(int i=0;i<n-1;i++) {
            first = first.next;
        }

        while (first.next != null) {
            first =first.next;
            second = second.next;
        }
        return second.value;
    }

    public void reverse() {
        // O(n) implementation

        Node current = this.head;
        this.tail = current;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    public void remove_value(int value) {
        // O(n) implementation
        int count = 0;
        if(this.head == null) {
            return ;
        }
        if(this.size == 1) {
            this.head = this.head.next;
            this.tail = this.head;
            this.size -= 1;
            return;
        }
        Node current = this.head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
            count += 1;
        }
        current.next = current.next.next;
        this.size -= 1;
        if(this.size - 1 == count) {
            this.tail = current;
        }

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListWithTailPointer l = new LinkedListWithTailPointer(null, null, 0);
        String command = "s";
        while (!command.equals("q")) {
            command = scanner.next();
            if("size".equals(command)) {
                System.out.println(l.size());
            }
            if("sizen".equals(command)) {
                System.out.println(l.size_n());
            }
            if("empty".equals(command)) {
                System.out.println(l.empty());
            }

            if("push_front".equals(command)) {
                int value = scanner.nextInt();
                l.push_front(value);
            }
            if("push_back".equals(command)) {
                int value = scanner.nextInt();
                l.push_back(value);
            }
            if("pop_front".equals(command)) {
                System.out.println(l.pop_front());
            }
            if("pop_back".equals(command)) {
                System.out.println(l.pop_back());
            }
            if("front".equals(command)) {
                System.out.println(l.front());
            }
            if("back".equals(command)) {
                System.out.println(l.back());
            }
            if("reverse".equals(command)) {
                l.reverse();
            }

            if("value_at".equals(command)) {
                int value = scanner.nextInt();
                System.out.println(l.value_at(value));
            }
            if("remove_value".equals(command)) {
                int value = scanner.nextInt();
                l.remove_value(value);
            }

            if("erase".equals(command)) {
                int value = scanner.nextInt();
                l.erase(value);
            }

            if("insert".equals(command)) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                l.insert(index, value);
            }

            if ("from_end".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.value_n_from_end(index));
            }

            l.print();
        }

    }

}
