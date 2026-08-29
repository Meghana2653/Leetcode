import java.util.*;

class LFUCache {

    class Node {
        int key;
        int value;
        int freq;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        // Add node at the front = most recently used
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        // Remove a specific node
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        // Remove least recently used node
        Node removeLast() {
            if (size == 0) {
                return null;
            }

            Node node = tail.prev;
            remove(node);

            return node;
        }
    }

    private int capacity;
    private int size;
    private int minFreq;

    // key -> Node
    private Map<Integer, Node> keyMap;

    // frequency -> DLL
    private Map<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;

        keyMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {

        if (!keyMap.containsKey(key)) {
            return -1;
        }

        Node node = keyMap.get(key);

        // Increase frequency
        increaseFrequency(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0) {
            return;
        }

        // Key already exists
        if (keyMap.containsKey(key)) {

            Node node = keyMap.get(key);

            node.value = value;

            // put also increases frequency
            increaseFrequency(node);

            return;
        }

        // Cache is full
        if (size == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node removed = list.removeLast();

            keyMap.remove(removed.key);

            size--;
        }

        // Create new node
        Node node = new Node(key, value);

        keyMap.put(key, node);

        // New node always has frequency 1
        freqMap
            .computeIfAbsent(1, k -> new DoublyLinkedList())
            .addFirst(node);

        minFreq = 1;

        size++;
    }

    private void increaseFrequency(Node node) {

        int oldFreq = node.freq;

        DoublyLinkedList oldList = freqMap.get(oldFreq);

        oldList.remove(node);

        // If old frequency was the minimum
        if (oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }

        node.freq++;

        freqMap
            .computeIfAbsent(node.freq, k -> new DoublyLinkedList())
            .addFirst(node);
    }
}