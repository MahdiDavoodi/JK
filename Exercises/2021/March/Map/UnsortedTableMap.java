package ir.blog.mahdidavoodi;

import java.util.ArrayList;

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
}
