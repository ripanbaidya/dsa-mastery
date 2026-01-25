package util.linkedlist;

/**
 * Implementation of Doubly Linked List with basic operations.
 * <p>
 * add      - add element at first, addLast, addAt <p>
 * delete   - deleteFirst, deleteLast, deleteAt <p>
 * display
 */
class DoublyLinkedList {
    private DoublyListNode head = null;
    private int length = 0;

    /**
     * Add element at first
     *
     * @param data data to be added
     */
    public void addFirst(int data) {
        DoublyListNode newNode = new DoublyListNode(data);

        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
        length++;
    }

    /**
     * Add element at last
     *
     * @param data data to be added
     */
    public void addLast(int data) {
        DoublyListNode newNode = new DoublyListNode(data);

        if (head == null) {
            head = newNode;
        } else {
            DoublyListNode currNode = head;
            // Traverse to the last node
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
            newNode.prev = currNode;

            length++;
        }
    }

    /**
     * Add element at specific index, 0 based indexing
     *
     * @param data  data to be added
     * @param index index at which data to be added
     */
    public void addAt(int data, int index) {
        DoublyListNode newNode = new DoublyListNode(data);
        // Invalid index
        if (index < 0 || index >= length) {
            System.out.println("Invalid Index.");
            return;
        } else if (index == 0) {
            // Add node at first
            addFirst(data);
        } else if (index == length - 1) {
            // Add node at last
            addLast(data);
        } else {
            DoublyListNode currNode = head;
            for (int i = 1; i <= index - 1; i++) {
                currNode = currNode.next;
            }

            newNode.next = currNode.next;
            currNode.next.prev = newNode;
            newNode.prev = currNode;
            currNode.next = newNode;

            length++;
        }
    }

    /**
     * Delete first node
     */
    public void deleteFirst() {
        if (length == 0) {
            System.out.println("List is empty");
        } else if (length == 1) {
            System.out.println("Node " + head.data + " deleted");
            head = head.next;
        } else {
            System.out.println("Node " + head.data + " deleted");
            head = head.next;
            head.next.prev = null;
        }
        length--;
    }

    /**
     * Delete last node
     */
    public void deleteLast() {
        if (length == 0) {
            System.out.println("List is empty");
        } else if (length == 1) {
            deleteFirst();
        } else {
            DoublyListNode currNode = head;

            while (currNode.next.next != null) {
                currNode = currNode.next;
            }

            System.out.println("Node " + currNode.next.data + " deleted");
            currNode.next.prev = null;
            currNode.next = null;
        }
        length--;
    }

    /**
     * Delete node at specific index, 0 based indexing
     *
     * @param index index at which node to be deleted
     */
    public void deleteAt(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return;
        } else if (index == 0) {
            deleteFirst();
        } else if (index == length - 1) {
            deleteLast();
        } else {
            DoublyListNode currNode = head;

            for (int i = 1; i <= index - 1; i++) {
                currNode = currNode.next;
            }

            // store the element that need to be deleted
            DoublyListNode delElement = currNode.next;
            System.out.println("Node " + delElement.data + " deleted");

            currNode.next = delElement.next;
            delElement.next.prev = currNode;
        }

        length--;
    }

    /**
     * Get length of linked list
     *
     * @return current length of linked list
     */
    public int getLength() {
        return length;
    }

    /**
     * Display linked list
     */
    public void display() {
        DoublyListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

}