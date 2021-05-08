package br.com.study.datastructure.binarytree.test;

import br.com.study.datastructure.binarytree.BinaryTree;
import br.com.study.datastructure.binarytree.BinaryTreeNode;
import br.com.study.util.RandomArrayGenerator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinaryTreeTest extends TestCase {

    @Test
    public void testExtractOrderedArray() {
        Integer[] randomArray = RandomArrayGenerator.generateRandomArray(10, 100);
        BinaryTree tree = BinaryTree.fromArray(randomArray);
        Arrays.sort(randomArray);
        assertTrue(Arrays.equals(randomArray, tree.toArray()));
    }

    @Test
    public void testFindRandomNodeDeepSearch() {
        int arrayLength = 50;
        Integer[] randomArray = RandomArrayGenerator.generateRandomArray(arrayLength, 500);
        int randomIndex = new Random().nextInt(arrayLength);

        BinaryTree tree = BinaryTree.fromArray(randomArray);

        BinaryTreeNode foundNode = tree.recursiveDepthSearch(randomArray[randomIndex]);

        assertNotNull(foundNode);
        assertEquals(randomArray[randomIndex], foundNode.getValue());
    }

    @Test
    public void testFindRandomNodeLevelSearch() {
        int arrayLength = 50;
        Integer[] randomArray = RandomArrayGenerator.generateRandomArray(arrayLength, 500);
        int randomIndex = new Random().nextInt(arrayLength);

        BinaryTree tree = BinaryTree.fromArray(randomArray);

        BinaryTreeNode foundNode = tree.nonRecursiveDepthSearch(randomArray[randomIndex]);

        assertNotNull(foundNode);
        assertEquals(randomArray[randomIndex], foundNode.getValue());
    }
}
