package SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        SLL list = new SLL();
//        list.insertAtFirst(10);
//        list.insertAtFirst(20);
//        list.insertAtFirst(30);
//        list.insertAtFirst(40);
//        list.display(list.head);
//      list.head=  list.insert(110, 2, list.head);
//        list.insertAtFirst(50);
//        list.insertAtFirst(60);
//        list.insertRecursion(110, 2);
//        list.insertAtEnd(10);
//        list.insertAtEnd(20);
//        list.insertAtEnd(30);
//        list.insertAtEnd(40);
//        list.display(list.head);
//        list.insertAtPos(400, 0);
//        list.display(list.head);

//        list.insertAtPos(440, 3);
//        list.display(list.head);
//        list.insertAtPos(4440, 2);

//        list.display(list.head);

//        list.deleteFirst();
//        list.deleteLast();
//        list.display(list.head);
//        list.deleteLast();
//        list.deleteLast();
//        list.deleteAtIndex(2);
//        list.display(list.head);
//        list.deleteAtIndex(1);
//        list.deleteAtIndex(2);
//        list.deleteAtVal(10);
//        list.display(list.head);
//        list.deleteAtVal(40);
//        list.display(list.head);
//        list.deleteAtVal(60);
//        list.display(list.head);
 /*
        merge two linked list example
        SLL list = new SLL();
        SLL list2 = new SLL();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.insertAtEnd(50);
        list.insertAtEnd(50);
        list2.insertAtEnd(10);
        list2.insertAtEnd(20);
        list2.insertAtEnd(30);
        list2.insertAtEnd(40);
        list.display(list.head);
        list.display(list2.head);
//        list.removeDuplicates(list.head);
        list.head = list.merge(list.head, list2.head);
        list.display(list.head);
*/
        list.insertAtEnd(10);
        list.insertAtEnd(50);
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(70);
        list.insertAtEnd(50);
        list.insertAtEnd(40);
        list.insertAtEnd(10);
        list.insertAtEnd(60);
        list.insertAtEnd(70);
        list.insertAtEnd(30);
        list.display(list.head);
        list.head =list.removeDuplicate(list.head);
        list.display(list.head);

        list.head = list.mergeSort(list.head);
        list.display(list.head);



    }
}
