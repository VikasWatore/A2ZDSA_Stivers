package main.java.LinkedList;

import java.util.Stack;

public class LinkedListIsPalindrome {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);

        if (IsPalindromeOptimized(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome." );
        }
    }

    //bruteForce
    private static boolean isPalindrome(Node head) {
        Stack<Node> nodes=new Stack<>();

        Node temp=head;
        while (temp!=null){
            nodes.push(temp);
            temp=temp.next;
        }
        temp=head;
        while (temp!=null){
           if(temp.data!=nodes.pop().data){
               return false;
           }
           temp=temp.next;
        }
        return true;
    }
    // optimized solution
    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node temp=head;
        Node prev=null;
        while (temp!=null){
            Node front=temp.next;
            temp.next=prev;
            prev=front;
            temp=front;

        }
        return prev;
    }
    public static boolean IsPalindromeOptimized(Node head){
        if(head==null || head.next==null){
            return true;
        }
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node newHead=reverse(slow.next);

        Node first=head;
        Node second=newHead;
        while (second!=null){
            if (first.data!=second.data){
                reverse(newHead);
                return false;
            }
            first=first.next;
            second=second.next;
        }
        reverse(newHead);
        return true;
    }

}
