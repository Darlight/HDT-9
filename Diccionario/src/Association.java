/*
Universidad del Valle de Guatemala
Seccion 10 - Pareja 9
Josue Sagastume - 18173
Mario Perdomo - 18029
Association.java
 */

class Association<K,V>{
    private K key; //Ingles
    private V value; // Español

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return this.key;
    }
    public V getValue() {
        return this.value;
    }

}