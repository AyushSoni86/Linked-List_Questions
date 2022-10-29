package SinglyLinkedList;

public class MainForSorting {
    public static void main(String[] args) {
        SLL list = new SLL();
        list.insertAtEnd(0);
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(0);
        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(2);
        list.insertAtEnd(1);
        list.insertAtEnd(0);
        list.display(list.head);

//        list.sort012(list.head);
//        list.sort01and2(list.head);
        list.head = list.mergeSort(list.head);
        list.display(list.head);
    }
}
