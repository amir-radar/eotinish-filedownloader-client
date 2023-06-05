package leetCode.algorithms.one;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEnd2 {

    public static void main(String[] args) {
        RemoveNthNodeFromEnd2 testClass = new RemoveNthNodeFromEnd2();
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
//        ListNode listNode = new ListNode();
//        ListNode listNode = new ListNode();
//        ListNode listNode = new ListNode();
//        ListNode listNode = new ListNode();
//        ListNode listNode = new ListNode();
        listNode4.next = listNode5;
        listNode3.next = listNode4;
        listNode2.next = listNode3;
        listNode.next = listNode2;
        int n = 2;
        ListNode newNode = testClass.removeNthFromEnd(listNode, n);
        while (newNode != null){
            System.out.println(newNode.val + " ");
            newNode = newNode.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> lnList = new ArrayList<>();
        while(head != null){
            if(head != null){
                lnList.add(new ListNode(head.val));
            }
            head = head.next;
        }

        for(int i = 0; i < lnList.size(); i++){
            if(i < lnList.size() - n - 1){
                lnList.get(i).next = lnList.get(i+1);
            } else if(i == lnList.size() - n - 1){
                lnList.get(i).next = lnList.get(i+2);
            } else {
                if (i < lnList.size() - 1){
                    lnList.get(i).next = lnList.get(i+1);
                }
            }
        }

        return lnList.get(0);
    }

    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
