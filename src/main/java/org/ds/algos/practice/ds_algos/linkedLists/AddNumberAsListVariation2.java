package org.ds.algos.practice.ds_algos.linkedLists;

import static org.ds.algos.practice.ds_algos.linkedLists.LinkedList.Node;

public class AddNumberAsListVariation2 {

    static class NodeResult {
        Node node;
        int carry;
    }

    /**
     * The lists are represented in the reverse form
     * 1->2->3->4 means 4321
     * @param list1
     * @param list2
     * @return
     */
    public static NodeResult addLinkedLists(Node list1, Node list2) {
        Node node = new Node(0, null);
        NodeResult result = new NodeResult();
        result.node = node;
        int carry = 0;

        if(list1 == null && list2 == null)
            return null;
        NodeResult next = null;
        if(list1!=null && list2!=null) {
            next = addLinkedLists(list1.getNext()!=null? list1.getNext():null,
                    list2.getNext()!=null? list2.getNext():null);
            if(next!=null)
                result.node.setNext(next.node);
        }
        if(next!=null && next.carry != 0)
            node.setKey(node.getKey()+next.carry);
        if(list1!=null)
            node.setKey(node.getKey()+list1.getKey());
        if(list2!=null)
            node.setKey(node.getKey()+list2.getKey());
        if(node.getKey()>=10) {
            node.setKey(node.getKey()%10);
            result.carry=1;
        }

        return result;
    }

    public static void main(String[] args) {
        Node list1 = LinkedList.getLinkedList();
        Node list2 = LinkedList.getLinkedList();
        NodeResult result = addLinkedLists(list1, list2);
        Node node = result.node;
        if(result.carry!=0)
            System.out.print(result.carry + " -> ");
        while(node!=null) {
            System.out.print(node.getKey());
            if(node.getNext()!=null)
                System.out.print(" -> ");
            node = node.getNext();
        }
    }
}
