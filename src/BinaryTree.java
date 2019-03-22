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

    public String findInOrder(Node node, String toLookFor) {
        String foundSomething = "not found";

        if (node != null) {
            if (node.english.compareTo(toLookFor) == 0){
                return node.spanish;
            }else {
                foundSomething = findInOrder(node.left, toLookFor);
                if (foundSomething.compareTo("not found") == 0){
                    foundSomething = findInOrder(node.right, toLookFor);
                }
            }
        }
        return foundSomething;
    }

    public void traverseInOrder(Node node){
        //imprimir en función es malo, pero no encontré otra manera
        if (node != null){
            traverseInOrder(node.left);
            System.out.println(node.english);
            traverseInOrder(node.right);
        }

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
