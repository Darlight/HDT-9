public class FactoryTree{
    //Factory that creates instances
    public Object getTree(String treeType) {
        if (treeType == null) {
            return null;
        }
        if (treeType.equalsIgnoreCase("SPLAY")) {
            return new BSTSplayTree();

        } else if (treeType.equalsIgnoreCase("RBT")) {
            return new BSTRBTree();
        }
        return null;
    }
}

