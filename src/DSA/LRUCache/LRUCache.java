package DSA.LRUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUCache {

    int capcity;

    Map<Integer, Node> map = null;

    Deque<Node> queue = null;

    @Override
    public String toString() {
        return "DSA.LRUCache{" +
                "capcity=" + capcity +
                ", map=" + map +
                ", queue=" + queue +
                '}';
    }

    public LRUCache(int capacity) {
        this.capcity = capacity;
        map = new HashMap();
        queue = new LinkedList();
    }

    public int get(int key) {

        if (map.get(key) != null) {
            Node node = map.get(key);
            queue.remove(node);
            queue.addFirst(node);
            return node.getValue();
        }
        return -1;


    }

    public void set(int key, int value) {

        if (queue.size() == capcity) {
            Node node = node = new Node(key, value);
            if (map.get(key) != null) {
                Node storedNode = map.get(key);
                queue.remove(storedNode);
                queue.addFirst(node);
                map.put(key, node);
            } else {
                Node last = queue.getLast();
                queue.removeLast();
                map.remove(last.getKey());
                queue.addFirst(node);
                map.put(key, node);
            }


        } else {
            Node node = node = new Node(key, value);
            if (map.get(key) != null) {
                Node storedNode = map.get(key);
                queue.remove(storedNode);
            }
            queue.addFirst(node);
            map.put(key, node);

        }

    }

    public static void main(String[] args) {
        LRUCache lru=new LRUCache(2);
        System.out.println(lru.get(2));
        lru.set(2,6);
        System.out.println(lru.get(1));
        lru.set(1,5);
        lru.set(1,2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }


}
