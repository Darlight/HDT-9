public class BSTRBTree <K extends Comparable<K>,V> {
    protected BinarySearchTree<RBTreeAssociation<K,V>> tree;

    public BSTRBTree()
    {
        tree = new BinarySearchTree<>();
    }

    public V put(K key, V value)
    {
        RBTreeAssociation<K,V> prev = tree.add(new RBTreeAssociation<>(key, value, true));
        // restructure tree
        insertRestructure(tree.actionNode);
        if(prev == null) return null;
        return prev.getValue();
    }

    public V remove(K key)
    {
        RBTreeAssociation<K,V> prev = tree.remove(new RBTreeAssociation<>(key, null, false));
        if(prev == null) return null;
        return prev.getValue();
    }

    public V get(K key)
    {
        RBTreeAssociation<K,V> found = tree.get(new RBTreeAssociation<>(key, null, false));
        if(found == null) return null;
        return found.getValue();
    }

    public boolean contains(K key)
    {
        return get(key) != null;
    }

    protected void insertRestructure(BinaryTree<RBTreeAssociation<K,V>> node)
    {
        if(node.parent() == null)
        {
            node.value().isRed = false;
            return;
        }
        if(!node.parent().value().isRed) return;
        BinaryTree<RBTreeAssociation<K,V>> gp = node.parent().parent();
        BinaryTree<RBTreeAssociation<K,V>> un = null;
        boolean isParentRed = node.parent().value().isRed();
        boolean isUncleRed = false;
        if(gp != null) // node has a grandparent, grab uncle
        {
            if(node.parent().isLeftChild()) un = gp.right();
            else un = gp.left();
        }
        if(un == null || un.value() == null) isUncleRed = false;
        else isUncleRed = un.value().isRed;
        if(isParentRed)
        {
            if(isUncleRed)
            {
                gp.value().setRed();
                node.parent().value().setBlack();
                if(un != null) un.value().setBlack();
                // fix gp
                insertRestructure(gp);
                return;
            }
            else
            {
                boolean isLeft = node.isLeftChild();
                boolean isPLeft = node.parent().isLeftChild();
                // case 4
                if(isLeft && !isPLeft)
                {
                    node.parent().rotateRight();
                    node = node.right();
                }
                else if(!isLeft && isPLeft)
                {
                    node.parent().rotateLeft();
                    node = node.left();
                }
                node.parent().parent().value().setRed();
                node.parent().value().setBlack();
                if(node.isLeftChild() && node.isLeftChild()) gp.rotateRight();
                else gp.rotateLeft();
                if(node.parent().parent() == null)
                {
                    tree.root = node.parent();
                    tree.root.value().setBlack();
                }
            }
        }
    }
}

