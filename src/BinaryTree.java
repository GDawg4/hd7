import com.sun.nio.sctp.Association;

import java.util.HashMap;

public class BinaryTree<E> {
    //tomado de https://www.baeldung.com/java-binary-tree
    Node root;

    public BinaryTree createBinaryTree() {
        BinaryTree bt = new BinaryTree();

        return bt;
    }

    public void add(String valueE, String valueS) {
        root = addRecursive(root, valueE, valueS);
    }

    private Node addRecursive(Node current, String valueE, String valueS) {

        if (current == null) {
            return new Node(valueE, valueS);
        }

        if (valueE.compareTo(current.english) < 0) {
            current.left = addRecursive(current.left, valueE, valueS);
        } else if (valueE.compareTo(current.english) > 0) {
            current.right = addRecursive(current.right, valueE, valueS);
        }

        return current;
    }

    public String traverseInOrder(Node node, String toLookFor) {
        if (node != null) {
            if (node.english.equals(toLookFor) ){
                return node.english;
            }
            traverseInOrder(node.left, toLookFor);
            traverseInOrder(node.right, toLookFor);
            return node.english;
        }
        return "";
    }

    class Node {
        String english;
        String spanish;
        Node left;
        Node right;

        Node(String english, String spanish) {
            this.english = english;
            this.spanish = spanish;
            right = null;
            left = null;
        }
    }
}
