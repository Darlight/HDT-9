/*
Universidad del Valle de Guatemala
Seccion 10 - Pareja 9
Josue Sagastume - 18173
Mario Perdomo - 18029
Node.java
 */
// Nodo de un BST
//Extraido de: https://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/

class Node {

    Association valor;
    Node left, right;

    Node(Association valor) {
        this.valor = valor;
        this.left = this.right = null;
    }
}