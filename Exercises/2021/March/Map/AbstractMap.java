package ir.blog.mahdidavoodi;

public abstract class AbstractMap<K, V> implements Map<K, V> {

    protected static class MapEntry<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        protected void setKey(K key) {
            this.key = key;
        }

        protected V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
