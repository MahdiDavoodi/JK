package ir.blog.mahdidavoodi;

import java.util.ArrayList;

public class IntegerSortedMap<V> extends AbstractMap<Integer, V> {
    ArrayList<MapEntry<Integer, V>> table = new ArrayList<>();

    public IntegerSortedMap() {
    }

    private int findIndex(int key, int low, int high) {
        if (high < low) return high + 1;
        int mid = (low + high) / 2;
        if (key == table.get(mid).getKey()) return mid;
        else if (key < table.get(mid).getKey())
            return findIndex(key, low, mid - 1);
        else
            return findIndex(key, mid + 1, high);
    }

    private int findIndex(int key) {
        return findIndex(key, 0, table.size() - 1);
    }

    private MapEntry<Integer, V> safeEntry(int index) {
        if (index < 0 || index >= size()) return null;
        return table.get(index);
    }

    public MapEntry<Integer, V> firstEntry() {
        return safeEntry(0);
    }

    public MapEntry<Integer, V> lastEntry() {
        return safeEntry(size() - 1);
    }

    public MapEntry<Integer, V> ceilingEntry(int key) {
        return safeEntry(findIndex(key));
    }

    public MapEntry<Integer, V> floorEntry(int key) {
        int index = findIndex(key);
        if (index == size() || key != table.get(index).getKey())
            index--;
        return safeEntry(index);
    }

    public MapEntry<Integer, V> lowerEntry(int key) {
        return safeEntry(findIndex(key) - 1);
    }

    public MapEntry<Integer, V> higherEntry(int key) {
        int index = findIndex(key);
        if (index < size() && key == table.get(index).getKey())
            index++;
        return safeEntry(index);
    }

    @Override
    public V get(Integer key) {
        return ceilingEntry(key).getValue();
    }

    @Override
    public V put(Integer key, V value) {
        int index = findIndex(key);
        if (index < size() && key.equals(table.get(index).getKey()))
            return table.get(index).setValue(value);
        table.add(index, new MapEntry<>(key, value));
        return value; // Or we can return null.
    }

    @Override
    public V remove(Integer key) {
        int index = findIndex(key);
        if (index == size() || !key.equals(table.get(index).getKey())) return null;
        return table.remove(index).getValue();
    }

    @Override
    public int size() {
        return table.size();
    }

    @Override
    public Iterable<Entry<Integer, V>> entrySet() {
        return snapshot(0, null);
    }

    public Iterable<Entry<Integer, V>> subMap(Integer fromKey, Integer toKey) {
        return snapshot(findIndex(fromKey), toKey);
    }

    private Iterable<Entry<Integer, V>> snapshot(int startIndex, Integer stop) {
        ArrayList<Entry<Integer, V>> buffer = new ArrayList<>();
        int index = startIndex;
        while (index < table.size() && (stop == null || table.get(index).getKey() > stop))
            buffer.add(table.get(index++));
        return buffer;
    }
}