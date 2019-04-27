/*
Universidad del Valle de Guatemala
Seccion 10 - Pareja 9
Josue Sagastume - 18173
Mario Perdomo - 18029
BinaryTree.java
 */
import java.util.Collections;

//Extraido de: http://www.newthinktank.com/2013/03/binary-tree-in-java/
//Extraido de: https://www.baeldung.com/java-binary-tree
public class BinaryTree<E> {

    protected E value;
    protected BinaryTree<E> parent, left, right;

    public BinaryTree()
    {
        value = null;
        parent = left = right = null;
    }

    public BinaryTree(E value)
    {
        this.value = value;
        setLeft(new BinaryTree<>());
        setRight(new BinaryTree<>());
    }

    public BinaryTree(E value, BinaryTree<E> left, BinaryTree<E> right)
    {
        this(value);
        if(left != null) setLeft(left);
        if(right != null) setRight(right);
    }

    public BinaryTree<E> left() { return left; }
    public BinaryTree<E> right() { return right; }
    public BinaryTree<E> parent() { return parent; }

    public void setLeft(BinaryTree<E> newLeft)
    {
        left = newLeft;
        newLeft.setParent(this);
    }

    public void setRight(BinaryTree<E> newRight)
    {
        right = newRight;
        newRight.setParent(this);
    }

    public boolean isLeftChild()
    {
        if(parent != null)
        {
            BinaryTree left = parent.left();
            return this == left;
        }
        return false;
    }

    public boolean isRightChild()
    {
        if(parent != null)
        {
            BinaryTree right = parent.right();
            return this == right;
        }
        return false;
    }


    public boolean isInternal()
    {
        return ((left() != null) || (right != null));
    }

    public E value() { return value; }

    public void setValue(E newValue) { value = newValue; }

    protected void setParent(BinaryTree<E> newParent)
    {
        parent = newParent;
    }

    protected boolean isEmpty()
    {
        return value == null;
    }

    protected BinaryTree<E> rotateRight()
    {
        BinaryTree<E> newRoot = left();
        if(newRoot == null) return this;
        BinaryTree<E> tempParent = this.parent();
        boolean isLeft = this.isLeftChild();
        setLeft(newRoot.right());
        newRoot.setRight(this);
        if(tempParent != null)
        {
            if(isLeft) tempParent.setLeft(newRoot);
            else tempParent.setRight(newRoot);
        }
        else newRoot.setParent(null);
        return newRoot;
    }

    protected BinaryTree<E> rotateLeft()
    {
        BinaryTree<E> newRoot = this.right();
        if(newRoot == null) return this;
        BinaryTree<E> tempParent = this.parent();
        boolean isLeft = this.isLeftChild();
        setRight(newRoot.left());
        newRoot.setLeft(this);
        if(tempParent != null)
        {
            if(isLeft) tempParent.setLeft(newRoot);
            else tempParent.setRight(newRoot);
        }
        else newRoot.setParent(null);
        return newRoot;
    }

}