package DSA.LFUCache;

public class LFUNode {
    int key;
    int value;
    int frequency;
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
    public LFUNode(int key, int value, int frequency) {
        this.key = key;
        this.value = value;
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "LFUNode{" +
                "key=" + key +
                ", value=" + value +
                ", frequency=" + frequency +
                '}';
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getFrequency() {
        return this.frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }


}
