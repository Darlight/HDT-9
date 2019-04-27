public class RBTreeAssociation<K extends Comparable<K>,V> implements Comparable<RBTreeAssociation<K,V>> {
    protected K key;
    protected V value;
    protected boolean isRed;

    public RBTreeAssociation(K key, V value, boolean isRed)
    {
        this.key = key;
        this.value = value;
        this.isRed = isRed;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setRed() { isRed = true;
    }

    public void setBlack() {
        isRed = false;
    }

    public boolean isRed() {
        return isRed;
    }

    @Override
    public int compareTo(RBTreeAssociation<K, V> o)
    {
        return key.compareTo(o.getKey());
    }
}

