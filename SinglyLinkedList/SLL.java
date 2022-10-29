package SinglyLinkedList;

import java.util.HashSet;

public class SLL {
    Node head;
    Node tail;

    boolean isEmpty(Node head) {
        if (head == null) {
            System.out.println("Linked list is Empty");
            return true;
        }
        return false;
    }

    int lengthOfList(Node head) {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    void insertAtFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
    }

    void insertAtEnd(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    void insertAtPos(int data, int index) {
        if (index == 0) {
            insertAtFirst(data);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            if (temp.next == null) return;
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;

    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        head = head.next;
    }

    void deleteLast() {
        Node temp = head;
        if (temp.next == null) {
            deleteFirst();
            return;
        }
        Node temp1 = temp.next;
        while (temp.next != null) {
            temp1 = temp;
            temp = temp.next;
        }
        temp1.next = null;
    }

    void deleteAtIndex(int index) {
        if (head == null) {
            System.out.println("linked list is Empty");
            return;
        }
        if (index == 0) {
            deleteFirst();
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            if (temp.next == null) {
                System.out.println("connot insert out of bound");
                return;
            }
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    void deleteAtVal(int val) {
        if (isEmpty(head)) return;
        if (head.data == val) {
            deleteFirst();
            return;
        }
        Node temp = head;
        Node prev = temp;
        while (temp != null) {
            if (temp.data == val) break;
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
    }

    void display(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    // Questions asked in Interviews

    // Q. insert a node using recursion
    void insertRecursion(int data, int index) {
        head = insert(data, index, head);
    }

    Node insert(int data, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(data);
            temp.next = node;
            return temp;
        }
        node.next = insert(data, index - 1, node.next);
        return node;
    }

    // Q. Remove Duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) temp.next = temp.next.next;
            else temp = temp.next;
        }
        return head;
    }

    // Q. delete all the nodes that are duplicated including them
    Node removeDuplicates2(Node head) {
        if (head == null || head.next == null) return head;
        Node prev = new Node(0, head);
        Node temp = head;
        Node ans = prev;
        while (temp != null && temp.next != null) {
            if (temp.data == temp.next.data) {
                while ((temp.next != null) && temp.data == temp.next.data)
                    temp = temp.next;
                prev.next = temp.next;
            } else prev = prev.next;
            temp = temp.next;
        }
        return ans.next;
    }

    // Q. remove duplicates from unsorted linked list
    // contains 3 approach;

    // approach 1 = using two nested loops searching that the current element is present in the linked list or not
    // TC - O(n^2)  & SC - O(1)

    // approach 2 = sort the linked list and then use the previous approach
    // TC - O(nlog(n)) & SC - O(1)

    // approach 3 = using hashmap or hashset
    // TC - O(n) & SC - O(n)

    Node removeDuplicate(Node head) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (hs.contains(current.data)) prev.next = current.next;
            else {
                hs.add(current.data);
                prev = current;
            }
            current = current.next;
        }
        return head;
    }


    // Q. Merge Two Sorted Linked List
    Node merge(Node head1, Node head2) {
        Node temp1 = head1;
        Node temp2 = head2;
        Node dummy = new Node(-1);
        Node ans = dummy;
        while (temp1 != null && temp2 != null) {
            if (temp1.data < temp2.data) {
                ans.next = temp1;
                ans = ans.next;
                temp1 = temp1.next;
            } else {
                ans.next = temp2;
                ans = ans.next;
                temp2 = temp2.next;
            }
        }
        ans.next = (temp1 != null) ? temp1 : temp2;
        return dummy.next;
    }

    // Q. Sort Linked list using merge Sort and bubble sort
    Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;
        Node mid = mid(head);
        Node left = head;
        Node right = mid.next;
        mid.next = null;

        left = mergeSort(left);
        right = mergeSort(right);

        Node result = merge(left, right);
        return result;
    }

    // bubble sort in linked list
    void bubbleSort(int row, int col) {
        if (row == 0) return;
        if (row < col) {
            Node first = get(col);
            Node second = get(col + 1);
            if (first.data > second.data) {
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }
    // Q. Sort 0s,1s Ans 2s in a linked list having two approach

    //Approach 1 - count the number of 0s , 1s and 2s and replace the data
    Node sort012(Node head) {
        int zero = 0, one = 0, two = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) zero++;
            else if (temp.data == 1) one++;
            else two++;
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (zero != 0) {
                temp.data = 0;
                zero--;
            } else if (one != 0) {
                temp.data = 1;
                one--;
            } else {
                temp.data = 2;
                two--;
            }
            temp = temp.next;
        }
        return head;
    }

    // approach 2 -> if data replacement not allowed
    Node sort01and2(Node head) {
        Node zeroHead = new Node(-1);
        Node zeroTail = zeroHead;
        Node oneHead = new Node(-1);
        Node oneTail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroTail.next = temp;
                zeroTail = temp;
            } else if (temp.data == 1) {
                oneTail.next = temp;
                oneTail = temp;
            } else {
                twoTail.next = temp;
                twoTail = temp;
            }
            temp = temp.next;
        }
        if (oneHead.next != null) zeroTail.next = oneHead.next;
        else zeroTail.next = twoHead.next;

        oneTail.next = twoHead.next;
        twoTail.next = null;

        return zeroHead.next;

    }

    // Q. Middle of Linked list
    Node mid(Node head) {
        if (head == null) return head;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Q. Cycle Detect in linked list
    boolean detectCycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    // Q. length of the cycle detected
    int lengthCycle(Node head) {
        int size = 1;
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        while (slow.next != fast) {
            slow = slow.next;
            size++;
        }
        return size;
    }

    // Q. Return the node where the cycle begins
    Node cycle(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }
        return null;
    }

    Node detectCycle2(Node head) {
        Node fast = cycle(head);
        if (fast == null) return null;
        Node slow = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    // Q. Happy Number Using cycle Detection
    int findMul(int num) {
        int sum = 0;
        while (num != 0) {
            int digit = num % 10;
            num = num / 10;
            sum = digit * digit;
        }
        return sum;
    }

    boolean isHappy(int num) {
        int slow = num;
        int fast = num;
        do {
            slow = findMul(num);
            fast = findMul(findMul(num));
        } while (fast != slow);
        return slow == 1;
    }

    // Q. add two numbers represented by linked list
    // method 1 -> numbers are already reversed
    Node addNum(Node first, Node second) {
        Node dummy = new Node(-1);
        Node ans = dummy;
        int sum = 0, carry = 0;
        while (first != null || second != null) {
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }
            sum += carry;
            ans.next = new Node(sum % 10);
            ans = ans.next;
            carry = sum / 10;
            sum = 0;
        }
        if (carry != 0) ans.next = new Node(carry);
        return dummy.next;
    }

    // method 2 -> if numbers are not reversed
    Node addNum2(Node first, Node second) {
        first = reverse(first);
        second = reverse(second);
        Node dummy = new Node(-1);
        Node ans = dummy;
        int sum = 0, carry = 0;
        while (first != null || second != null) {
            if (first != null) {
                sum += first.data;
                first = first.next;
            }
            if (second != null) {
                sum += second.data;
                second = second.next;
            }
            sum += carry;
            ans.next = new Node(sum % 10);
            ans = ans.next;
            carry = sum / 10;
            sum = 0;
        }
        if (carry != 0) ans.next = new Node(carry);
        return reverse(dummy.next);
    }

    // Q. Reverse a linked list recursively and iteratively
    // iterative method
    Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        return prev;
    }

    // recursive method
    Node reverseRec(Node head) {
        if (head == null || head.next == null) return head;
        Node small = reverseRec(head.next);
        head.next.next = head;
        head.next = null;
        return small;
    }

    // Q. Reverse Parts of Linked list
    Node reverseBet(Node head, int left, int right) {
        if (right == left) return head;
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < left - 1 && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        Node last = prev;
        Node newEnd = curr;
        for (int i = 0; i < right - left + 1 && curr != null; i++) {
            Node forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
        }
        if (last != null) last.next = prev;
        else head = prev;
        newEnd.next = curr;
        return head;
    }

    // Q. Palindrome Linked List -
    // approach 1 - trick TC - O(n) SC - O(n)
    boolean isPalindrome1(Node head) {
        Node temp = head;
        int len = lengthOfList(temp);
        temp = head;
        int[] arr = new int[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp.data;
            temp = temp.next;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[arr.length - 1 - i]) return false;
        }
        return true;
    }

    // optimal approach - 2 TC - O(n) SC - O(1)
    boolean isPalindrome(Node head) {
        Node mid = mid(head);
        Node first = reverse(mid);
        Node second = head;
        while (first != null && second != null) {
            if (first.data != second.data) return false;
            first = first.next;
            second = second.next;
        }
        return true;
    }

    // Q. Reorder Linked List
    void reOrder(Node head) {
        if (head == null || head.next == null) return;
        Node mid = mid(head);
        Node second = reverse(mid);
        Node first = head;
        while (first != null && second != null) {
            Node temp = first.next;
            first.next = second;
            first = temp;
            temp = second.next;
            second.next = first;
            second = temp;
        }
        if (first != null) first.next = null;
    }

    // Q. Reverse K-Nodes in a Linked List
    // recursive solution
    Node kReverse(Node head, int k) {
        if (head == null) return null;
        Node prev = null, forward = null;
        Node curr = head;
        int cnt = 0;
        while (curr != null && cnt < k) {
            forward = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forward;
            cnt++;
        }
        if (forward != null) head.next = kReverse(forward, k);
        return prev;

    }

    // solution to submit on leetcode recursive
    private boolean check(Node head, int k) {
        Node temp = head;
        while (temp != null && k != 0) {
            temp = temp.next;
            k--;
        }
        return k == 0;
    }

    public Node reverseKGroup(Node head, int k) {
        if (head == null)
            return null;
        head = reverse(head, k);
        return head;
    }

    private Node reverse(Node head, int k) {
        if (!check(head, k)) return head;
        Node current = head;
        Node forward = null;
        Node prev = null;

        int count = 0;

        while (count < k && current != null) {
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
            count++;
        }

        if (forward != null)
            head.next = reverseKGroup(forward, k);
        return prev;
    }

    // solution to submit on leetcode iterative
    Node reverseKNodes(Node head, int k) {
        if (head == null || head.next == null || k == 1) return head;
        Node curr = head;
        int size = lengthOfList(curr);
        Node prev = null;
        Node newHead = null;
        Node last = null;
        Node t2 = head;
        while (size >= k) {
            for (int i = 0; i < k; i++) {
                Node forward = curr.next;
                curr.next = prev;
                prev = curr;
                curr = forward;
            }
            if (newHead == null) newHead = prev;
            if (last != null) last.next = prev;
            t2.next = curr;
            last = t2;
            t2 = curr;
            prev = null;
            size = size - k;
        }
        return newHead;
    }

    public Node reverseAlternateKGroup(Node head, int k) {
        if (k <= 1 || head == null) return head;
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node last = prev;
            Node newEnd = current;
            for (int i = 0; current != null && i < k; i++) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            if (last != null) last.next = prev;
            else head = prev;
            newEnd.next = current;
            for (int i = 0; current != null && i < k; i++) {
                prev = current;
                current = current.next;
            }
        }
        return head;
    }

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
