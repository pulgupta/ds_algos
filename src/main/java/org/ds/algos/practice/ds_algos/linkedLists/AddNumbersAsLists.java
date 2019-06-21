package org.ds.algos.practice.ds_algos.linkedLists;

import static org.ds.algos.practice.ds_algos.linkedLists.LinkedList.Node;

public class AddNumbersAsLists {

    /**
     * The lists are represented in the reverse form
     * 1->2->3->4 means 4321
     * @param list1
     * @param list2
     * @param carry
     * @return
     */
    public static Node addLinkedLists(Node list1, Node list2, int carry) {
        if(list1 == null && list2 == null && carry ==0)
            return null;
        Node result = new Node(0, null);
        result.setKey(carry);
        if(list1!=null)
            result.setKey(result.getKey()+list1.getKey());
        if(list2!=null)
            result.setKey(result.getKey()+list2.getKey());
        if(result.getKey()>=10) {
            result.setKey(result.getKey()%10);
            carry=1;
        }
        if(list1!=null && list2!=null) {
            Node next = addLinkedLists(list1.getNext()!=null? list1.getNext():null,
                    list2.getNext()!=null? list2.getNext():null, carry);
            result.setNext(next);
        }
        return result;
    }

    public static void main(String[] args) {
        Node list1 = LinkedList.getLinkedList();
        Node list2 = LinkedList.getLinkedList();
        Node result = addLinkedLists(list1, list2, 0);

        while(result!=null) {
            System.out.print(result.getKey());
            if(result.getNext()!=null)
                System.out.print(" -> ");
            result = result.getNext();
        }
    }
}
