import java.util.List;

/**
 * Created by zzs on 2016/11/14.
 */

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumber {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode((l1.val + l2.val) % 10);
        listNode.next = new ListNode((l1.val + l2.val) / 10);
        if (l1.next != null && l2.next != null){
            l1.next.val = l1.next.val + listNode.next.val;
            listNode.next = addTwoNumbers(listNode.next, l2.next);
        }
        else{
            if (l1.next != null) listNode.next.val = listNode.next.val + l1.next.val;
            if (l2.next != null) listNode.next.val = listNode.next.val + l2.next.val;
            listNode.next = addTwoNumbers(listNode.next, new ListNode(0));
        }
        if (listNode.next.val == 0) listNode.next = null;

        return listNode;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(10);

        ListNode b = new ListNode(1);

        AddTwoNumber addTwoNumber = new AddTwoNumber();
        System.out.println(addTwoNumber.addTwoNumbers(a, b));
    }

}
