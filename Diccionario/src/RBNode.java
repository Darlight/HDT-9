//Codigo extraido de: https://www.sanfoundry.com/java-program-implement-red-black-tree/
public class RBNode implements Comparable<RBNode> {

    RBNode left, right;
    int element;
    int color;

    /* Constructor */
    public RBNode(int theElement)
    {
        this(theElement, null, null );
    }
    /* Constructor */
    public RBNode(int theElement, RBNode lt, RBNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
    @Override
    public int compareTo(RBNode diccionario) {
        if (this.element == 1){
            return 1;

        }
        return 2;
    }
}
