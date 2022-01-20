package recursion;

public class Task203 {

    public static void main(String[] args) {
        Task203 task203 = new Task203();
        System.out.println(task203.removeElements(new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(3,
                                        new ListNode(4,
                                                new ListNode(5,
                                                        new ListNode(6))))))), 6));
        System.out.println(task203.removeElements(new ListNode(7,
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7)))), 7));
        System.out.println(task203.removeElements(new ListNode(1,
                new ListNode(2)), 1));
    }

     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

         @Override
         public String toString() {
              StringBuilder builder = new StringBuilder();
              builder.append(val + " ");
              while (next != null){
                  builder.append(next.val + " ");
                  next = next.next;
              }
             return builder.toString();
         }
     }

     private ListNode res = null;

    public ListNode removeElements(ListNode head, int val) {
        res = null;
        removeElement(head, val, head);
        return res;
    }

    public void removeElement(ListNode head, int val, ListNode previous){
        if (head == null)
            return;
        if (head.val == val){
            previous.next = head.next;
            removeElement(head.next, val, previous);
        } else{
            if (res == null)
                res = head;
            removeElement(head.next, val, head);
        }
    }
}
