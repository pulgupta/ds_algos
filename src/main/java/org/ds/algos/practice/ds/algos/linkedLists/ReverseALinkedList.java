package org.ds.algos.practice.ds.algos.linkedLists;

public class ReverseALinkedList {

    public static LinkedList.Node reverseASinglyLinkedList(LinkedList.Node root) {
        LinkedList.Node previous = null;
        LinkedList.Node current = root;
        LinkedList.Node next = root.getNext();

        while (current != null) {
            current.setNext(previous);
            previous = current;
            current = next;
            if (current != null)
                next = current.getNext();
        }
        return previous;
    }

    public static void main(String args[]) {
        LinkedList.Node root = LinkedList.getLinkedList();
        System.out.println("**Original**");
        LinkedList.printList(root);
        System.out.println("\n\n**Reversed**");
        LinkedList.printList(ReverseALinkedList.reverseASinglyLinkedList(root));
    }
}
