package SinglyLinkedList;

public class MainForReverseQuestions {
    public static void main(String[] args) {
      /*  SLL list = new SLL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);

        list.display(list.head);

        list.head = list.reverseRec(list.head);

        list.display(list.head);
        */
//        SLL list1 = new SLL();
//        list1.insertAtEnd(2);
//        list1.insertAtEnd(4);
//        list1.insertAtEnd(3);
//        list1.insertAtEnd(7);
//        list1.insertAtEnd(9);
//        list1.insertAtEnd(9);
//        list1.insertAtEnd(9);

//        list1.display(list1.head);
//        list1.insertAtEnd(6);

//        SLL list2 = new SLL();
//        list1.insertAtEnd(5);
//        list1.insertAtEnd(6);
//        list1.insertAtEnd(4);
//        list1.insertAtEnd(9);
//        list1.display(list1.head);
//
//        list1.reverseBet(list1.head, 3,6);
////        list1.head = list1.addNum2(list1.head, list2.head);
//
//        list1.display(list1.head);
//        SLL list = new SLL();
//        list.insertAtEnd(1);
//        list.insertAtEnd(2);
//        list.insertAtEnd(3);
//        list.insertAtEnd(3);
//        list.insertAtEnd(2);
//        list.insertAtEnd(1);
////        list.insertAtEnd(1);
//        System.out.println(list.isPalindrome1(list.head));
        SLL list = new SLL();
//        list.insertAtEnd(1);
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
        list.insertAtFirst(10);
        list.insertAtFirst(20);
        list.insertAtFirst(30);
//        list.insertAtFirst(10);
//        list.insertAtFirst(10);
//        list.insertAtFirst(10);
//        list.insertAtFirst(10);
//        list.insertAtEnd(2);
//        list.insertAtEnd(3);
//        list.insertAtEnd(4);
//        list.insertAtEnd(5);
//        list.insertAtEnd(6);
//        list.insertAtEnd(7);
//        list.insertAtEnd(8);
//        list.insertAtEnd(9);
        list.insertAtEnd(10);
        list.insertAtEnd(11);
//        list.insertAtEnd(8);
        list.display(list.head);

//        list.reOrder(list.head);
        list.head = list.reverseAlternateKGroup(list.head, 3);
        list.display(list.head);
    }
}
