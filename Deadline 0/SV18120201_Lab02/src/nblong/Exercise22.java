package nblong;

class Node {
    private int _data;
    private Node _next = null;

    public Node(int data) {
        _data = data;
    }

    public int get_data() {
        return _data;
    }

    public void set_data(int _data) {
        this._data = _data;
    }

    public Node get_next() {
        return _next;
    }

    public void set_next(Node _next) {
        this._next = _next;
    }
}

class LinkedList {
    private Node _head = null;
    private Node _tail = null;

    public void addHead(int x) {
        if (_head == null) {
            _head = _tail = new Node(x);
        }
        else {
            _tail.set_next(new Node(x));
            _tail = _tail.get_next();
        }
    }

    public void addTail(int x) {
        if (_head == null) {
            _head = _tail = new Node(x);
        }
        else {
            Node p = new Node(x);
            p.set_next(_head);
            _head = p;
        }
    }

    public LinkedList reverse() {
        LinkedList result = new LinkedList();
        for (Node p = _head; p != null; p = p.get_next()) {
            result.addHead(p.get_data());
        }
        return result;
    }

    public void printLinkedList() {
        for (Node p = _head; p != null; p = p.get_next()) {
            System.out.printf("%d ", p.get_data());
        }
        System.out.println();
    }
}

public class Exercise22 {
    public static void reverse() {
        LinkedList l = new LinkedList();
        int temp;
        while (true) {
            System.out.println("Enter data for your linked list (press -1 to stop): ");
            temp = Exercise01.input();
            if (temp == -1) {
                break;
            }
            l.addTail(temp);
        }

        System.out.println("Your reversed linked list is: ");
        l.reverse().printLinkedList();
    }
}