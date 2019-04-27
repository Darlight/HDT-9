import java.util.Map.Entry;

public class SplayTreeAssociation<K extends Comparable<K>,V> implements Entry<K,V>, Comparable<SplayTreeAssociation<K,V>>
{
    protected K clave;
    protected V valor;

    public SplayTreeAssociation(K k, V v)
    {
        clave = k;
        valor = v;
    }

    @Override
    public K getKey()
    {
        return clave;
    }

    @Override
    public V getValue()
    {
        return valor;
    }

    @Override
    public V setValue(V valor)
    {
        V temp = valor;
        this.valor = valor;
        return temp;
    }

    @Override
    public int compareTo(SplayTreeAssociation<K, V> o)
    {
        return clave.compareTo(o.getKey());
    }
}