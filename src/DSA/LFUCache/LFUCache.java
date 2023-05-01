package DSA.LFUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 * 2
 * 1,1
 */


class DLLNode {
    int key;
    int val;
    int frequency;
    DLLNode prev;
    DLLNode next;

    public DLLNode(int key, int val) {
        this.key = key;
        this.val = val;
        this.frequency = 1;
    }
}

class DoubleLinkedList {
    int listSize;
    DLLNode head;
    DLLNode tail;

    public DoubleLinkedList() {
        this.listSize = 0;
        this.head = new DLLNode(0, 0);
        this.tail = new DLLNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DLLNode curNode) {
        DLLNode nextNode = head.next;
        curNode.next = nextNode;
        curNode.prev = head;
        head.next = curNode;
        nextNode.prev = curNode;
        listSize++;
    }

    public void removeNode(DLLNode curNode) {
        DLLNode prevNode = curNode.prev;
        DLLNode nextNode = curNode.next;
        prevNode.next = nextNode;
        prevNode.prev = prevNode;
        listSize--;
    }
}

public class LFUCache {

//    public static void main(String[] args) {
//
//        LFUCache lfu=new LFUCache(3);
//        lfu.put(2, 2);
//        lfu.put(1, 1);
//        lfu.get(2);
//        lfu.get(1);
//        lfu.get(2);
//        lfu.put(3, 3);
//        lfu.put(4, 4);
//        lfu.get(3);
//        lfu.get(2);
//        lfu.get(1);
//        lfu.get(4);
//
//    }

    final int capacity;
    int curSize;
    int minFrequency;


    Map<Integer, DLLNode> cache;
    Map<Integer, DoubleLinkedList> frequencyMap;


    //    Map<Integer, LFUNode> map;
//    Deque<LFUNode> deque;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.curSize = 0;
        this.minFrequency = 0;
        this.cache = new HashMap<Integer, DLLNode>();
        this.frequencyMap = new HashMap<Integer, DoubleLinkedList>();

    }


    public int get(int key) {
        DLLNode curNode = cache.get(key);
        if (curNode == null)
            return -1;
        updateNode(curNode);
        return curNode.val;

    }

    private void updateNode(DLLNode curNode) {
        int curFreq = curNode.frequency;
        DoubleLinkedList curList = frequencyMap.get(curFreq);
        curList.removeNode(curNode);
        if (curFreq == minFrequency && curList.listSize == 0) {
            minFrequency++;
        }
        curNode.frequency++;
        DoubleLinkedList newList = frequencyMap.getOrDefault(curNode.frequency, new DoubleLinkedList());
        newList.addNode(curNode);
        frequencyMap.put(curNode.frequency, newList);
    }


    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }
        if (cache.containsKey(key)) {
            DLLNode curNode = cache.get(key);
            curNode.val = value;
            updateNode(curNode);
        } else {
            curSize++;
            if (curSize > capacity) {
                DoubleLinkedList minFreqList = frequencyMap.get(minFrequency);
                cache.remove(minFreqList.tail.prev.key);
                minFreqList.removeNode(minFreqList.tail.prev);
                curSize--;
            }
            minFrequency = 1;
            DLLNode newNode = new DLLNode(key, value);
            DoubleLinkedList curList = frequencyMap.getOrDefault(1, new DoubleLinkedList());
            curList.addNode(newNode);
            frequencyMap.put(1, curList);
            cache.put(key, newNode);

        }


    }
}
//    public LFUCache_old(int capacity) {
//        this.capacity = capacity;
//        map = new HashMap<Integer, LFUNode>();
//        deque = new LinkedList();
//
//    }

//    public int get_old(int key) {
//
//        if (map.get(key) != null) {
//            LFUNode node = map.get(key);
//            deque.remove(node);
//            node.setFrequency(node.getFrequency() + 1);
//            map.put(key,node);
//            deque.addFirst(node);
//            return node.getValue();
//        } else {
//            return -1;
//        }
//
//
//    }


//    public void put_old(int key, int value) {
//        LFUNode node =new LFUNode(key,value,1);
//            if (deque.size() == capacity) {
//                if (map.get(key) != null) {
//                            LFUNode storedNode=map.get(key);
//                          //  int storedFrequency=storedNode.getFrequency();
//                            deque.remove(storedNode);
//                            storedNode.setFrequency(storedNode.getFrequency()+1);
//                            storedNode.setValue(value);
//                            LFUNode lastNode=deque.removeLast();
//                            map.remove(lastNode.key);
//                            deque.addFirst(storedNode);
//                            map.put(key,storedNode);
//                            map.put(key,storedNode);
//                }
//                else{
//                    LFUNode lastNode=deque.getLast();
//                    deque.removeLast();
//                    map.remove(lastNode.key);
//                  //  node.setFrequency(lastNode.frequency+1);
//                    deque.addFirst(node);
//                    map.put(key,node);
//
//                }
//            } else {
//                if (map.get(key) != null) {
//                    LFUNode storedNode=map.get(key);
//                    //int storedFrequency=storedNode.getFrequency();
//                    deque.remove(storedNode);
//                    storedNode.setFrequency(storedNode.getFrequency()+1);
//                    storedNode.setValue(value);
//                    deque.addFirst(storedNode);
//                    map.put(key,storedNode);
//
//                }
//                else{
//                    deque.addFirst(node);
//                    map.put(key,node);
//                }
//
//
//            }
//
//
//
//    }


