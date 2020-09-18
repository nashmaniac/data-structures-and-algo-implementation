package data_structures.singly_linked_lists;

import java.util.Scanner;

public class LinkedListWithoutTailPointer {
    int size = 0;
    Node head = null;

    LinkedListWithoutTailPointer(Node head){
        this.head = head;
    }

    public void push_front(int value) {
        Node n = new Node(value, null);
        if(this.head == null) {
            this.head = n;
        } else {
            n.next = this.head;
            this.head = n;
        }
        this.size += 1;
    }

    public int pop_front() {
        Node n = this.head;
        this.head = this.head.next;
        return n.value;
    }

    public void print() {
        Node current = this.head;
        System.out.println("Size: "+this.size());
        while (current!=null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
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

    public boolean empty() {
        return this.head == null;
    }

    public int value_at(int index) {
        if (index > this.size()-1) {
            return -1;
        }
        Node current = this.head;
        while (index > 0) {
            current = current.next;
            index -= 1;
        }
        return  current.value;
    }

    public void push_back(int value) {
        Node n = new Node(value, null);
        if(this.head == null){
            this.head = n;
            this.size += 1;
            return;
        }
        Node current = this.head;
        while (current.next!=null) {
            current = current.next;
        }
        current.next = n;
        this.size += 1;
    }

    public int pop_back() {
        if (this.head == null) {
            return -1;
        }
        if (this.size <= 1) {
            int value = this.head.value;
            this.head = null;
            this.size -= 1;
            return value;
        }
        Node current = this.head;
        while (current.next.next!=null) {
            current = current.next;
        }
        int value = current.next.value;
        current.next = null;
        this.size -= 1;
        return value;
    }

    public int front() {
        if(this.head != null) {
            return this.head.value;
        }
        return -1;
    }

    public int back() {
        if(this.head == null){
            return -1;
        }
        Node current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        return current.value;
    }

    public void insert(int index, int value) {
        Node current = this.head;
        int count = 0;
        while (count < index-1) {
            current = current.next;
            count += 1;
        }

        Node n = new Node(value, null);
        n.next = current.next;
        current.next = n;
    }

    public void erase(int index) {
        Node current = this.head;
        int count = 0;
        while (count < index-1) {
            current = current.next;
            count += 1;
        }

        current.next = current.next.next;
    }

    public int value_n_from_end(int n) {
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
        Node current = this.head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        this.head = prev;
    }

    public int remove_value(int value) {
        if (this.head == null) {
            return -1;
        }
        if(this.head.value == value) {
            int v = this.head.value;
            this.head = this.head.next;
            return v;
        }
        Node current = this.head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }
        int v = current.next.value;
        current.next = current.next.next;
        return v;
    }

    public static void main(String[] args) {
        String command = "s";
        Scanner scanner = new Scanner(System.in);

        LinkedListWithoutTailPointer l = new LinkedListWithoutTailPointer(null);

        while (!command.equals("q")) {
            command = scanner.next();

            if ("push_front".equals(command)) {
                int value = scanner.nextInt();
                l.push_front(value);
            }

            if ("push_back".equals(command)) {
                int value = scanner.nextInt();
                l.push_back(value);
            }


            if ("size".equals(command)) {
                System.out.println(l.size());
            }

            if ("size_n".equals(command)) {
                System.out.println(l.size_n());
            }

            if ("empty".equals(command)) {
                System.out.println(l.empty());
            }

            if ("value_at".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.value_at(index));
            }
            if ("erase".equals(command)) {
                int index = scanner.nextInt();
                l.erase(index);
            }
            if ("from_end".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.value_n_from_end(index));
            }

            if ("remove_value".equals(command)) {
                int index = scanner.nextInt();
                System.out.println(l.remove_value(index));
            }



            if ("reverse".equals(command)) {
                l.reverse();
            }




            if ("insert".equals(command)) {
                int index = scanner.nextInt();
                int value = scanner.nextInt();
                l.insert(index, value);
            }


            if ("pop_front".equals(command)) {
                System.out.println(l.pop_front());
            }
            if ("pop_back".equals(command)) {
                System.out.println(l.pop_back());
            }
            if ("front".equals(command)) {
                System.out.println(l.front());
            }
            if ("back".equals(command)) {
                System.out.println(l.back());
            }

            l.print();
        }
    }
}
