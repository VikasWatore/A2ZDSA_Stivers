package main.java.LinkedList.Ap;

public class LinkedList {


    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //methods
    public void addFirst(int data) {
        // step 1 create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2: newNode next=head
        newNode.next = head;//link

        //step3 head=newNode
        head = newNode;
    }

    public void addLast(int data) {
        //step 1 create node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 tail.next=newNode
        tail.next = newNode;

        //step move tail to newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }


    //print
    public void print() {
        if (head == null) System.out.println("LL is Empty");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //    remove()
    public static int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty ");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }


        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public static int removeLast() {
        if (size == 0) {
            System.out.println("LinkedList is Empty ");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }

        //previous :i=size-2;
        Node pre = head;
        for (int i = 0; i < size - 2; i++) {
            pre = pre.next;
        }
        int val = pre.data;
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    //    search()
    public static int itrSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        //key not found
        return -1;
    }
    //recursive Search
    public static int helper(Node head,int key){

        if (head==null) return -1;
        if (head.data==key){
            return 0;
        }
        int idx=helper(head.next,key);
        if (idx==-1){
            return -1;
        }
        return idx+1;
    }
    public static int recSearch(int key){
        return helper(head,key);

    }

    public static void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
//        ll.print();
        ll.addFirst(2);
//        ll.print();
        ll.addFirst(1);
//        ll.print();
        ll.addLast(3);
//        ll.print();
        ll.addLast(4);
//        ll.print();
//        ll.add(2, 5);
//        ll.print();
//      System.out.println(ll.size);
//        System.out.println("Removing First ");
//        removeFirst();
//        ll.print();
//        System.out.println("Removing last");
//        removeLast();
//        ll.print();

        ll.reverse();
        ll.print();
    }
}
