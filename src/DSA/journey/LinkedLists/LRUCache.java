package DSA.journey.LinkedLists;

import java.util.HashMap;
import java.util.Map;

class Node{
    int key;
    int val;
    Node prev;
    Node next;
    public Node(int key,int val){
        this.key=key;
        this.val=val;
        prev=null;
        next=null;
    }
}

public class LRUCache {
    Map<Integer,Node> map;
    Node dummy;
    Node head;
    Node tail;
    int capacity;
    public static void main(String[] args) {
//        capacity = 2
//        set(1, 10)
//        set(5, 12)
//        get(5)        returns 12
//        get(1)        returns 10
//        get(10)       returns -1
//        set(6, 14)    this pushes out key = 5 as LRU is full.
//        get(5)        returns -1
//6 1 S 2 1  S 2 2  G 2  S 1 1  S 4 1  G 2
        LRUCache lru=new LRUCache(2);
//        lru.set(1,10);
//        lru.set(5,12);
//        System.out.println(lru.get(5));;
//        System.out.println(lru.get(1)); ;
//        System.out.println( lru.get(10)); ;
//        lru.set(6,14);
//        System.out.println(lru.get(5));  ;

//        lru.set(2,1);
//        lru.set(2,2);
//        System.out.println(lru.get(2));;
//        lru.set(1,1);
//        lru.set(4,1);
//        lru.get(2);
     //   7 2  G 2   S 2 6  G 1  S 1 5  S 1 2  G 1 G 2
        System.out.println(lru.get(2));;
        lru.set(2,6);
        System.out.println(lru.get(1));;
        lru.set(1,5);
        lru.set(1,2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));;
        // *2 6 , 1 5, 1 2
//        -1 -1 2 6
//        Your function returned the following:
//        -1 -1 2 -1

    }

    public LRUCache(int capacity) {
        map=new HashMap<>();
        dummy =new Node(0,0);
        head=dummy;
        tail=dummy;
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node ref=map.get(key);
            if(ref.next==null){
                return ref.val;
            }
            remove(ref);
            Node newNode=new Node(key,ref.val);
            map.remove(key);
            map.put(key,newNode);
            tail.next=newNode;
            newNode.prev=tail;
            tail=tail.next;
            return newNode.val;
        }
        else{
            return -1;
        }

    }

    public void set(int key, int value) {
        if(capacity==map.size()){
            if(map.containsKey(key)){
                Node storedNode=map.get(key);
                remove(storedNode);
                map.remove(key);
                insertAtBack(key,value);
            }
            else{
                Node firstElement=head.next;
                remove(firstElement);
                map.remove(firstElement.key);
                insertAtBack(key,value);
            }

        }
        else{
            insertAtBack(key,value);
        }
    }
    public void insertAtBack(int key ,int value){
        Node newNode=new Node(key,value);
        tail.next=newNode;
        newNode.prev=tail;
        tail=tail.next;
        map.put(key,newNode);
    }
    public void remove(Node temp){
        if(temp.next!=null){
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;}
        else{
            temp.prev.next=null;
            tail=temp.prev;
        }

    }
}
////




