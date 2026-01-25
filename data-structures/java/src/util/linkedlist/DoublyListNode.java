package util.linkedlist;


/**
 * @author Ripan Baidya
 * @date 31-07-2025
 * <p>
 * In this program, we will create a Doubly Linked List and perform various operations on it.
 * We will create a ListNode class which will represent each node in the linked list.
 */
public class DoublyListNode {
    public int data;
    public DoublyListNode next;
    public DoublyListNode prev;

    public DoublyListNode() {}
    public DoublyListNode(int data) {
        this.data = data;
    }

    public DoublyListNode(int data, DoublyListNode next, DoublyListNode prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
