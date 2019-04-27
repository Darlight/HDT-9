public class BSTSplayTree<K extends Comparable<K>, V> {

    protected SplayTree<SplayTreeAssociation<K, V>> tree;

    public BSTSplayTree(){
        tree = new SplayTree<E>();
    }

    public V put(K clave, V valor){
        SplayTreeAssociation<K, V> old = tree.add(new SplayTreeAssociation<>(clave, valor));
        if (old == null)
            return null;
        return old.getValue();
    }

    public boolean contains(K clave){
        SplayTreeAssociation<K, V> temp = tree.get(new SplayTreeAssociation<>(clave, null));
        if (temp == null)
            return false;
        return temp.getValue() != null;
    }

    public V get(K clave){
        SplayTreeAssociation<K, V> temp = tree.get(new SplayTreeAssociation<>(clave, null));
        if (temp == null)
            return null;
        return temp.getValue();
    }

    public V remove(K clave){
        SplayTreeAssociation<K, V> temp = tree.remove(new SplayTreeAssociation<>(clave, null));
        if (temp == null)
            return null;
        return temp.getValue();
    }
}