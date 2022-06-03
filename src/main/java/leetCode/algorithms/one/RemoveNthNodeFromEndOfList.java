package leetCode.algorithms.one;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {

        RemoveNthNodeFromEndOfList remFromNode = new RemoveNthNodeFromEndOfList();
        ListNode listNode = remFromNode.removeFromEnd2(1);
        System.out.println(listNode.next.val);
    }

    public ListNode removeFromEnd2(int n){
        ListNode listNode5 = new ListNode();
        listNode5.val = 50;
        ListNode listNode4 = new ListNode();
        listNode4.val = 40;
        ListNode listNode3 = new ListNode();
        listNode3.val = 30;
        ListNode listNode2 = new ListNode();
        listNode2.val = 20;
        ListNode listNode1 = new ListNode();
        listNode1.val = 10;
        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode head = listNode1;
        head = listNode5;

        return head;
    }

    public ListNode removeNthFromEnd(int n) {

        ListNode listNode5 = new ListNode();
        listNode5.val = 50;
        ListNode listNode4 = new ListNode();
        listNode4.val = 40;
        ListNode listNode3 = new ListNode();
        listNode3.val = 30;
        ListNode listNode2 = new ListNode();
        listNode2.val = 20;
        ListNode listNode1 = new ListNode();
        listNode1.val = 10;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode head = listNode1;

        ListNode node = head;
        int counter = 1;

        while(node != null){
            if(node.next != null){
                node = node.next;
                counter++;
            } else {
                node = null;
            }
        }

        ListNode nodeVals = head;
        int[] vals = new int[counter];
        for (int b = 0; b < counter; b++){
            vals[b] = nodeVals.val;
            nodeVals = nodeVals.next;
        }

        List<ListNode> lnList = new ArrayList<>();
        for (int a = 0; a < counter; a++){
            if (a != counter - n || counter != n){
                lnList.add(new ListNode(vals[a]));
            }
        }
        for (int x = 0; x < lnList.size() - 1; x++){
            lnList.get(x).next = lnList.get(x+1);
        }
        System.out.println(lnList.get(3).val);
        return lnList.get(0);
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}