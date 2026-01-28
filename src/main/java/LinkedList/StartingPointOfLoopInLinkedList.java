package main.java.LinkedList;

import java.util.HashMap;

public class StartingPointOfLoopInLinkedList {
    public static void main(String[] args) {

        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        // Creating a cycle (tail connects to node index 1)
        head.next.next.next.next = head.next;

//        Node startNode = startNode(head);
//        if (startNode != null)
//        System.out.println("Cycle starts at node with value: " + startNode.data);
//        else
//        System.out.println("No cycle found.");

        Node startNode = startNodeWithOptimize(head);
        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.data);
        else
            System.out.println("No cycle found.");
    }

    private static Node startNode(Node head) {
        HashMap<Node,Integer> map= new HashMap<>();

        Node temp=head;

        while (temp!=null){
            if (map.containsKey(temp)){
                return temp;
            }
            map.put(temp,1);
            temp=temp.next;
        }
        return null;
    }
    //Optimized Solution
    private static Node startNodeWithOptimize(Node head) {
        Node slow=head;
        Node fast=head;

        while (fast!=null&& fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if (slow==fast){
                slow=head;
                while (slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                return slow;
            }

        }
        return null;
    }
}
