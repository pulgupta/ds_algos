package org.ds.algos.practice.ds_algos.linkedLists;

public class MergeTwoSortedLinkedLists {

    static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    private Node initializeFirstList() {
        Node head = new Node(10, new Node(15, new Node(25, new Node(30, null))));
        printList(head);
        return head;
    }


    private Node initializeSecondList() {
        Node node = new Node(1, new Node(9, new Node(19, new Node(21, new Node(35, null)))));
        printList(node);
        return node;
    }

    public Node mergeTwoSortedList(Node head1, Node head2) {
        // We will traverse the list which has the smallest element first and then will keep adding elements from the second list.
        Node runningPointer;
        Node stationaryPointer;
        Node resultHead;

        // This means that we will be traversing the first list and will pick elements from the second
        if (head1.value < head2.value) {
            resultHead = head1;
            runningPointer = head1;
            stationaryPointer = head2;
        } else {
            // This means that we will be traversing the second list and will pick elements from the first
            resultHead = head2;
            runningPointer = head2;
            stationaryPointer = head1;
        }

        Node next = null;
        while (runningPointer != null && stationaryPointer != null) {
            next = runningPointer.next;
            if (stationaryPointer.value < next.value) {
                // insert the element from the stationary list into the running list
                Node temp = stationaryPointer;
                stationaryPointer = stationaryPointer.next;
                Node temp2= runningPointer.next;
                runningPointer.next = temp;
                temp.next = temp2;
            }
            runningPointer = runningPointer.next;
        }

        return resultHead;
    }

    public static void main(String[] args) {

        MergeTwoSortedLinkedLists obj = new MergeTwoSortedLinkedLists();
        System.out.println("First list is:");
        Node head1 = obj.initializeFirstList();
        System.out.println("Second list is:");
        Node head2 = obj.initializeSecondList();

        System.out.println("\nPrinting the merged list");
        obj.printList(obj.mergeTwoSortedList(head1, head2));

    }

    private void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            if(temp.next!=null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println("");
    }
}
