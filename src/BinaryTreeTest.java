import org.junit.jupiter.api.Test;
import org.testng.Assert;


public class BinaryTreeTest {

    @Test
    public void createBinaryTree() {
        BinaryTree testTree = new BinaryTree();
        testTree.add("house", "casa");
        testTree.add("computer", "computadora");
        testTree.add("mouse", "mouse");
        testTree.add("photo", "foto");
        testTree.add("person", "persona");
        testTree.add("tape", "cinta");
        testTree.add("test", "prueba");

        Assert.assertEquals(testTree.root.left.english, "computer");
    }

    @Test
    public void add() {
        BinaryTree testTree = new BinaryTree();
        Assert.assertNull(testTree.root);
        testTree.add("prueba", "test");
        Assert.assertNotNull(testTree.root);
    }
}