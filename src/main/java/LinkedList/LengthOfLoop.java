package main.java.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLoop {
    public int lengthLoop(Node head){
        if(head==null){
            return 0;
        }

        Node temp=head;
        int count=0;
        Map<Node,Integer> map=new HashMap<>();

        while (temp!=null){
          if(map.containsKey(temp)){
             int val= map.get(temp);
              return count-val;
          }
            map.put(temp,count);
            count++;
            temp=temp.next;
        }
        return 0;
    }

    //
    public int lengthOfLoops(Node head){
        if (head==null){
            return 0;
        }

        Node slow=head;
        Node fast=head;
        while (fast!=null&&fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
                if (slow==fast){
                return findLength(slow,fast);
            }
        }
        return 0;
    }

    private int findLength(Node slow, Node fast) {
        int count=1;
        fast=fast.next;
        while (slow!=fast){
            count++;
            fast=fast.next;
        }
        return count;
    }


}
