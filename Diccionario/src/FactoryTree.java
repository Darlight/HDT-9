public class FactoryTree<E> {
    //Factory that creates instances
    public E getTree(String treeType) {
        if (treeType == null) {
            return null;
        }
        if (treeType.equalsIgnoreCase("SPLAY")) {
            return new SplayTree();

        } else if (treeType.equalsIgnoreCase("RBT")) {
            return new RBTree();
        }
        return null;
    }
}

