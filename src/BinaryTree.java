import com.sun.nio.sctp.Association;

import java.util.HashMap;

public class BinaryTree<E>{
    protected BinaryTree<E> parent;
    protected BinaryTree<E> left;
    protected BinaryTree<E> right;
    protected Comparable spanish;
    protected Comparable english;

    public BinaryTree(){
        spanish = null;
        english = null;
        parent = null;
        left = null;
        right = null;
    }

    public BinaryTree(Comparable valueSpanish, Comparable valueEnglish){
        spanish = valueSpanish;
        english = valueEnglish;
        right = new BinaryTree<E>();
        left = new BinaryTree<E>();
        parent = new BinaryTree<E>();
    }

    public BinaryTree(Comparable valueSpanish, Comparable valueEnglish, BinaryTree<E> left, BinaryTree<E> right){
        spanish = valueSpanish;
        english = valueEnglish;
        if (left == null){
            left = new BinaryTree<>();
        }
        //setLeft(left)
        if (right == null){
            //setRight(right)
        }
    }

    public BinaryTree<E> getParent() {
        return parent;
    }

    public void setParent(BinaryTree<E> newParent) {
        if (newParent != null) {
            parent = newParent;
        }
    }

    public BinaryTree<E> getLeft() {
        return left;
    }

    public void setLeft(BinaryTree<E> newLeft) {
        if (left == null) return;
        if (left.parent == this) {
            left.setParent(null);
        }
        left = newLeft;
        left.setParent(this);
    }

    public BinaryTree<E> getRight() {
        return right;
    }

    public void setRight(BinaryTree<E> right) {
        this.right = right;
    }

    public Comparable getSpanish() {
        return spanish;
    }

    public Comparable getEnglish() {
        return english;
    }
}
