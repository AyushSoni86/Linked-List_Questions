package SinglyLinkedList;

import java.util.*;

public class CloneUsingRandomPointer {

    // Q. clone a linked list with random pointer
    // contains three approaches
    // aproach 1 - using two loops : TC - O(n^2)

    // approach 2 - using hashmap
    public Node copyRandomList(Node head) {
        Node dummy = new Node(-1);
        Node tail = dummy;
        Map<Node, Node> map = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            Node node = new Node(temp.val);
            tail.next = node;
            tail = node;
            map.put(temp, node);
            temp = temp.next;
        }
        temp = head;
        tail = dummy.next;
        while (temp != null) {
            Node rand = temp.random;
            if (rand != null) {
                Node place = map.get(rand);
                tail.random = place;
            } else tail.random = null;
            temp = temp.next;
            tail = tail.next;
        }
        return dummy.next;
    }

    // approach 3 - linear time complexity

    public Node copyRandomList2(Node head) {
        if (head == null) return head;
        Node temp = head;
        // copying the nodes
        while (temp != null) {
            Node curr = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = curr;
            temp = curr;
        }
        temp = head;
        // setting the random pointers
        while (temp != null) {
            if (temp.next != null) {
                temp.next.random = (temp.random != null) ?
                        temp.random.next : null;
            }
            temp = temp.next.next;
        }

        Node orig = head, copy = head.next;
        Node curr = copy;
        // separating orignal and copied list
        while (orig != null) {
            orig.next = orig.next.next;
            copy.next = (copy.next != null) ?
                    copy.next.next : copy.next;
            orig = orig.next;
            copy = copy.next;
        }
        return curr;
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

