package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class ProbeHashMap<K, V> extends AbstractHashMap<K, V> {
    private MapEntry<K, V>[] table;
    private MapEntry<K, V> DEFUNCT = new MapEntry<>(null, null);

    public ProbeHashMap() {
        super();
    }

    public ProbeHashMap(int capacity) {
        super(capacity);
    }

    public ProbeHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    private boolean isAvailable(int index) {
        return (table[index] == null || table[index] == DEFUNCT);
    }

    private int findSlot(int hash, K key) {
        int available = -1;
        int index = hash;
        do {
            if (isAvailable(index)) {
                if (available == -1) available = index;
                if (table[index] == null) break;
            } else if (table[index].getKey().equals(key)) return index;
            index = (index + 1) % capacity;
        } while (index != hash);
        return -(available + 1);
    }

    @Override
    protected void createTable() {
        table = (MapEntry<K, V>[]) new MapEntry[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        int index = findSlot(h, key);
        if (index < 0) return null;
        return table[index].getValue();
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        int index = findSlot(h, key);
        if (index >= 0)
            return table[index].setValue(value);
        table[-(index + 1)] = new MapEntry<>(key, value);
        size++;
        return value;  // Or null
    }

    @Override
    protected V bucketRemove(int h, K key) {
        int index = findSlot(h, key);
        if (index < 0) return null;
        V reply = table[index].getValue();
        table[index] = DEFUNCT;
        size--;
        return reply;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> snapShot = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
            if (!isAvailable(i)) snapShot.add(table[i]);
        return snapShot;
    }
}
