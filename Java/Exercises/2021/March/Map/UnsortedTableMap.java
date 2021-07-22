package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class UnsortedTableMap<K, V> extends AbstractMap<K, V> {
    private final ArrayList<MapEntry<K, V>> table = new ArrayList<>();

    public UnsortedTableMap() {
    }

    private int findIndex(K key) {
        for (int i = 0; i < table.size(); i++)
            if (table.get(i).getKey().equals(key)) return i;
        return -1;
    }

    @Override
    public V get(K key) {
        int index = findIndex(key);
        if (index == -1) return null;
        return table.get(index).getValue();
    }

    @Override
    public V put(K key, V value) {
        int index = findIndex(key);
        if (index == -1) {
            table.add(new MapEntry<>(key, value));
            return null;
        }
        return table.get(index).setValue(value);
    }

    @Override
    public V remove(K key) {
        int index = findIndex(key);
        if (index == -1) return null;
        V reply = table.get(index).getValue();
        if (index != size() - 1)
            table.set(index, table.get(size() - 1));
        table.remove(size() - 1);
        return reply;
    }

    @Override
    public int size() {
        return table.size();
    }

    private class EntryIterator implements Iterator<Entry<K, V>> {

        private int n = 0;

        @Override
        public boolean hasNext() {
            return n < table.size();
        }

        @Override
        public Entry<K, V> next() {
            if (n == table.size()) throw new NoSuchElementException();
            return table.get(n++);
        }
    }

    private class EntryIterable implements Iterable<Entry<K, V>> {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            return new EntryIterator();
        }
    }

    @Override
    public Iterable<Entry<K, V>> entrySet() {
        return new EntryIterable();
    }
}
