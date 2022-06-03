package leetCode.algorithms.one;


public class MiddleLinkedList {

    public static void main(String[] args) {
        MiddleLinkedList mll = new MiddleLinkedList();

        mll.middleNode();
    }

    public ListNode middleNode() {

        ListNode listNode5 = new ListNode();
        listNode5.val = 5;
        ListNode listNode4 = new ListNode();
        listNode4.val = 4;
        ListNode listNode3 = new ListNode();
        listNode3.val = 3;
        ListNode listNode2 = new ListNode();
        listNode2.val = 2;
        ListNode listNode1 = new ListNode();
        listNode1.val = 1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode head = listNode1;
        //System.out.println(head.next.val);

        System.out.println(head.toString());

        ListNode node = head;
        int count = 1;
        while(node != null){
            if (node.next != null){
                //System.out.println(head.toString());
                node = node.next;
                count++;
            } else {
                node = null;
            }
        }
        //System.out.println("count = " + count);

        int count2 = count % 2 == 0 ? (count / 2) : (count / 2 + 1);
        //System.out.println("new count = " + count2);
        int[] vals = new int[count2];
        ListNode newNodes = head;
        for (int x = 1; x <= count; x++){
            if (x >= count2){
                vals[x-count2] = newNodes.val;
            }
            newNodes = newNodes.next;
        }
        return head;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
}
