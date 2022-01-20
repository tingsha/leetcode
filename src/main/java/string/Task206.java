package string;

import java.util.LinkedList;

public class Task206 {
    public static void main(String[] args) {
        Task206 task206 = new Task206();
        ListNode head =
            new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));
        ListNode res = task206.reverseList(head);
        System.out.println(res);
    }

    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        while (head != null){
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static class ListNode {
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

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}


