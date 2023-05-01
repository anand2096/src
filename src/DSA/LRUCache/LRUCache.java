package DSA.LRUCache;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class LRUCache {

    int capcity;

    Map<Integer, Node> map =null;

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
        map= new HashMap();
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

    public void put(int key, int value) {

        if (queue.size() == capcity) {

            Node node = node = new Node(key, value);

            if (map.get(key) != null) {

                Node storedNode = map.get(key);

            //    System.out.println("replacing " + "with new value of key " + key);

                queue.remove(storedNode);
                queue.addFirst(node);
                map.put(key, node);


            }else {


                System.out.println("Cache is full");

                System.out.println("removing the least recently used element");

                Node last = queue.getLast();

                queue.removeLast();
                map.remove(last.getKey());
                System.out.println("adding new element at beggining");
                queue.addFirst(node);
                map.put(key, node);
            }


        } else {
            Node node = node = new Node(key, value);
            ;

            if (map.get(key) != null) {

                Node storedNode = map.get(key);

                System.out.println("replacing " + "with new value of key " + key);

                queue.remove(storedNode);


            }
            System.out.println("this node is not present in node , adding this");
            queue.addFirst(node);
            map.put(key, node);


        }

    }


}
