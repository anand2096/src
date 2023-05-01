package DSA.LRUCache;

public class Node {

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    int key;

    public Node(int key,int value) {
        this.key = key;
        this.value=value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
