package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class ChainHashMap<K, V> extends AbstractHashMap<K, V> {
    private UnsortedTableMap<K, V>[] table;

    public ChainHashMap() {
        super();
    }

    public ChainHashMap(int capacity) {
        super(capacity);
    }

    public ChainHashMap(int capacity, int prime) {
        super(capacity, prime);
    }

    @Override
    protected void createTable() {
        table = (UnsortedTableMap<K, V>[]) new UnsortedTableMap[capacity];
    }

    @Override
    protected V bucketGet(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        return bucket.get(key);
    }

    @Override
    protected V bucketPut(int h, K key, V value) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null)
            bucket = table[h] = new UnsortedTableMap<>();
        int oldSize = bucket.size();
        V reply = bucket.put(key, value);
        size += (bucket.size() - oldSize);
        return reply;
    }

    @Override
    protected V bucketRemove(int h, K key) {
        UnsortedTableMap<K, V> bucket = table[h];
        if (bucket == null) return null;
        int oldSize = bucket.size();
        V reply = bucket.remove(key);
        size -= (oldSize - bucket.size());
        return reply;
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        ArrayList<Entry<K, V>> temp = new ArrayList<>();
        for (int i = 0; i < capacity; i++)
            if (table[i] != null)
                for (Entry<K, V> entry :
                        table[i].entrySet())
                    temp.add(entry);
        return temp;
    }
}
