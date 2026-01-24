package main.java.LinkedList;
//class Node{
//
//    int data;
//    Node next;
//
//    Node(int data, Node next ) {
//        this.data = data;
//        this.next = next;
//    }
//
//    Node(int data){
//        this.data=data;
//        this.next=null;
//    }
//}
public class ArrayLinkedList02 {
    public static Node convertArr2LL(int[] arr){
        Node head=new Node(arr[0]);
        Node mover=head;

        for (int i = 0; i < arr.length; i++) {
            Node temp=new Node(arr[i]);
            mover.next=temp;
            mover=temp;
        }
        return head;
    };
    public static void main(String[] args) {
        int[] num={10,20,30,40,50,60,70,80,90};
        Node head = convertArr2LL(num);
        System.out.println(head.data);
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }

    }
}
