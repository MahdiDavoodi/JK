package Mahdi.Davoodi;

import java.util.ArrayList;
import java.util.Random;

public abstract class AbstractHashMap<K, V> extends AbstractMap<K, V> {
    protected int size = 0, capacity, prime;
    protected long scale, shift;

    public AbstractHashMap(int capacity, int prime) {
        this.capacity = capacity;
        this.prime = prime;
        Random random = new Random();
        scale = random.nextInt(prime - 1) + 1;
        shift = random.nextInt(prime);
        createTable();
    }

    public AbstractHashMap(int capacity) {
        this(capacity, 109345121);
    }

    public AbstractHashMap() {
        this(17);
    }

    @Override
    public V get(K key) {
        return bucketGet(hashValue(key), key);
    }

    @Override
    public V put(K key, V value) {
        V reply = bucketPut(hashValue(key), key, value);
        if (size > capacity / 2)
            resize(2 * capacity - 1);
        return null;
    }

    @Override
    public V remove(K key) {
        return bucketRemove(hashValue(key), key);
    }

    @Override
    public int size() {
        return size;
    }

    private int hashValue(K key) {
        return (int) ((Math.abs(key.hashCode() * scale + shift) % prime) % capacity);
    }

    private void resize(int newCapacity) {
        ArrayList<Entry<K, V>> temp = new ArrayList<>(size);
        for (Entry<K, V> entry :
                entrySet())
            temp.add(entry);
        capacity = newCapacity;
        createTable();
        size = 0;
        for (Entry<K, V> entry :
                temp) {
            put(entry.getKey(), entry.getValue());
        }
    }

    protected abstract void createTable();

    protected abstract V bucketGet(int h, K key);

    protected abstract V bucketPut(int h, K key, V value);

    protected abstract V bucketRemove(int h, K key);
}