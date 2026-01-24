package main.java.LinkedList;

class Node{

    int data;
    Node next;

     Node(int data, Node next ) {
        this.data = data;
        this.next = next;
    }

    Node(int data){
        this.data=data;
        this.next=null;
    }

}


public class LinkedList01 {


    private static void print(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }

    private static Node removeHead(Node head){
        if (head==null) return head;
        head=head.next;
        return head;
    }


    public static void main(String[] args) {
        int[] num={10,20,30,40,50,60,70,80,90};
//        Node head=new Node(num[0]);
//        System.out.println(y.data);
//        System.out.println(ArrayLinkedList02.convertArr2LL(num));
//        Node head=ArrayLinkedList02.convertArr2LL(num);
//        head=removeHead(head);
//       print(head);
        Node head = new Node(num[0]);
        Node temp = head;

        for (int i = 1; i < num.length; i++) {
            temp.next = new Node(num[i]);
            temp = temp.next;
        }

        head = removeHead(head);
        print(head);
    }
}
