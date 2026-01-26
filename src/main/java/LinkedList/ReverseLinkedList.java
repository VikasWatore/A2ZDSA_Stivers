package main.java.LinkedList;

import java.util.Stack;



    public class ReverseLinkedList {

        static class ListNode {
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


        public static ListNode reverseList(ListNode head) {
            Stack<Integer> stack = new Stack<>();

            ListNode temp = head;

            while (temp != null) {
                stack.push(temp.val);
                temp = temp.next;
            }

            temp = head;
            while (temp != null) {
                temp.val = stack.pop();
                temp = temp.next;
            }
            return head;
        }

        public static void main(String[] args) {
            ListNode head=new ListNode(1);
            head.next=new ListNode(2);
            head.next.next=new ListNode(3);


            head=reverseList(head);
            while(head!=null){
                System.out.print(head.val+" -> ");
                head=head.next;
            }
            System.out.print("null");
        }
    }

}
