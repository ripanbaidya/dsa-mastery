package util.linkedlist;

/**
 * Implementation of Singly Linked List with basic operations.
 * <p>
 * add      - addFirst(), addLast(), addAt() <p>
 * delete   - deleteFirst(), deleteLast(), deleteAt() <p>
 * get      - getLength(), display() <p>
 */
class SinglyLinkedList {
    private int length = 0;
    private Node head = null;

    /* Add new Node */

    /**
     * Add node at first
     *
     * @param data data to be added
     */
    public void addFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        length++;
    }

    /**
     * Add node at last
     *
     * @param data data to be added
     */
    public void addLast(int data) {
        Node newNode = new Node(data);
        Node tempNode = head;

        if (head == null) {
            head = newNode;
        } else {
            // Move the 'temp' to the last position
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            // Connect the new node at last
            tempNode.next = newNode;
        }

        length++;
    }

    /**
     * Add node at specific index, 0 based indexing
     *
     * @param data  data to be added
     * @param index index at which data to be added
     */
    public void addAt(int data, int index) {
        Node newNode = new Node(data);

        // Check for invalid index
        if (index < 0 || index == length) {
            System.out.println("Invalid index.");
            return;
        }

        if (index == 0) {
            addFirst(data);
        } else if (index == length - 1) {
            addLast(data);
        } else {
            Node tempNode = head;

            // Move temp to the (index-1)th position
            for (int i = 1; i <= index - 1; i++) {
                tempNode = tempNode.next;
            }

            // Insert the new node at index position and adjust the links
            newNode.next = tempNode.next;
            tempNode.next = newNode;
        }

        length++;
    }

    /* Delete Node */

    /**
     * Delete first node of linked list
     */
    public void deleteFirst() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        } else {
            head = head.next;
        }

        length--;
    }

    /**
     * Delete last node of linked list
     */
    public void deleteLast() {
        if (head == null) {
            System.out.println("Linked List is empty!");
            return;
        } else if (length == 1) {
            deleteFirst();
        } else {
            Node temp = head;

            // traverse to the second last node
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
        }
        length--;
    }

    /**
     * Delete node at specific index, 0 based indexing
     *
     * @param index index at which node to be deleted
     */
    public void deleteAt(int index) {
        // Check for invalid index
        if (index < 0 || index == length) {
            System.out.println("Invalid Index.");
        } else if (index == 0) {
            // Delete first node
            deleteFirst();
        } else if (index == length - 1) {
            // Delete last node
            deleteLast();
        } else {
            Node temp = head;
            for (int i = 1; i <= index - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }

        length--;
    }

    /**
     * Get current length of linked list
     *
     * @return length of linked list
     */
    public int getLength() {
        Node temp = head;

        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * Display all nodes in the linked list
     */
    public void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}