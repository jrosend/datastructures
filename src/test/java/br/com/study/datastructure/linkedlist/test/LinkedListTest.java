package br.com.study.datastructure.linkedlist.test;

import br.com.study.datastructure.linkedlist.LinkedList;
import br.com.study.util.RandomArrayGenerator;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static br.com.study.datastructure.linkedlist.LinkedList.fromArray;
import static br.com.study.util.RandomArrayGenerator.generateRandomArray;

public class LinkedListTest extends TestCase {

    @Test
    public void testShouldCreateLinkedList(){
        Integer[] randomArray = generateRandomArray(10, 100);
        LinkedList linkedList = fromArray(randomArray);
        assertTrue("Arrays diferentes", Arrays.equals(randomArray, linkedList.toArray()));
    }

    public void testShouldReverseLinkedList(){
        Integer[] randomArray = generateRandomArray(10, 100);

        List<Integer> randomList = Arrays.asList(randomArray.clone());
        Collections.reverse(randomList);

        Integer[] reverseRandomArray = new Integer[randomArray.length];
        reverseRandomArray = randomList.toArray(reverseRandomArray);

        LinkedList listToReverse = fromArray(randomArray);

        listToReverse.reverse();

        assertTrue("Arrays Reversos diferentes", Arrays.equals(reverseRandomArray, listToReverse.toArray()));
    }
}
