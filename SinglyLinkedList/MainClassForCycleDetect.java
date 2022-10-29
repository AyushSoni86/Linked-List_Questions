package SinglyLinkedList;

public class MainClassForCycleDetect {
    public static void main(String[] args) {
        SLL list = new SLL();
 /*
//        linked list for containing cycle
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(60);
        list.insertAtEnd(70);
        list.insertAtEnd(80);
        // creating loop
        list.head.next.next.next.next.next.next.next = list.head.next.next;

        System.out.println(list.detectCycle(list.head));
        System.out.println(list.lengthCycle(list.head));
*/
//            System.out.println(list.isHappy(13));

        list.insertAtEnd(23);
        list.insertAtEnd(23);

//        list.insertAtEnd(10);
//        list.insertAtEnd(20);
//        list.insertAtEnd(30);
//        list.insertAtEnd(40);
//        list.insertAtEnd(50);
//        list.insertAtEnd(60);
        list.insertAtEnd(70);
        list.insertAtEnd(80);
        list.insertAtEnd(45);
        list.insertAtEnd(34);
        list.insertAtEnd(78);
        list.insertAtEnd(90);


        list.display(list.head);

//        list.mergeSort(list.head);
        list.bubbleSort(list.lengthOfList(list.head),0);
        list.display(list.head);

    }

}
