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
public class BinaryTree {

    Node root;
    //Revisa si el nodo izquierdo o derecho tiene un valor mayor que el insertado
    //En caso que sea cierto, crea el nodo izquierdo (menor cantidad) o nodo derecho
    //(mayor cantidad).
    private Node addRecursive(Node current, Association valor) {
        if (current == null) {
            return new Node(valor);
        }

        if (valor.getKey() < current.valor.getKey()) {
            current.left = addRecursive(current.left, valor);
        } else if (valor.getKey() > current.valor.getKey()) {
            current.right = addRecursive(current.right, valor);
        } else {
            // value already exists
            return current;
        }

        return current;
    }
    //Agrega el nodo
    public void add(Association value) {
        root = addRecursive(root, value);
    }
    //Busca un nodo en especifico
    private boolean containsNodeRecursive(Node current, String valor) {
        // Palabra en asterisco, es decir, la palabra en ingles
        if (current == null) {
            return false;
        }
        //Retorna el valor en español
        if (valor.getKey() == current.valor.getKey()) {
            return true; //Retornar el nodo con su valor español
        }
        return valor.getKey() < current.valor.getKey()
                ? containsNodeRecursive(current.left, valor)
                : containsNodeRecursive(current.right, valor);
    }
    //Comienza el root
    public boolean containsNode(String value) {
        return containsNodeRecursive(root, valor);
    }

    // All nodes are visited in ascending order
    // Recursion is used to go to one node and
    // then go to its child nodes and so forth

    //Orden trasversal In-Order
    public void inOrderTraverseTree(Node focusNode) {
        if (focusNode != null) {
            // Traverse the left node

            inOrderTraverseTree(focusNode.leftChild);
            // Visit the currently focused on node
            System.out.println(focusNode);
            // Traverse the right node
            inOrderTraverseTree(focusNode.rightChild);
        }
    }
}