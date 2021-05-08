package br.com.study.datastructure.binarytree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import static java.util.Objects.isNull;

public class BinaryTree {
    private BinaryTreeNode root;
    private int size = 0;

    public BinaryTreeNode add(Integer value){
        //TODO if null
        BinaryTreeNode newNode = new BinaryTreeNode(value);
        if(isNull(root)){
            root = newNode;
        } else {
            add(root, newNode);
        }
        size++;
        return newNode;
    }

    private void add(BinaryTreeNode parentNode, BinaryTreeNode newNode){
        if(parentNode.getValue() > newNode.getValue()){
            if(isNull(parentNode.getLeft())){
                parentNode.setLeft(newNode);
            } else {
                add(parentNode.getLeft(), newNode);
            }
        } else {
            if(isNull(parentNode.getRight())){
                parentNode.setRight(newNode);
            } else {
                add(parentNode.getRight(), newNode);
            }
        }
    }

    public static BinaryTree fromArray(Integer[] array){
        BinaryTree newTree = new BinaryTree();
        for (int i = 0; i < array.length; i++) {
            newTree.add(array[i]);
        }
        return newTree;
    }

    public Integer[] toArray(){
       Integer[] array = new Integer[size];
       extractNodeValuesToArray(root, array, Integer.valueOf(0));
       return array;
    }

    private int extractNodeValuesToArray(BinaryTreeNode parent, Integer[] array, int index){
        if(isNull(parent)) return index;
        index = extractNodeValuesToArray(parent.getLeft(), array, index);
        array[index++] = parent.getValue();
        return extractNodeValuesToArray(parent.getRight(), array, index);
    }

    public BinaryTreeNode recursiveDepthSearch(Integer value) {
        return recursiveDepthSearch(root, value);
    }

    private BinaryTreeNode recursiveDepthSearch(BinaryTreeNode node, Integer value){
        if(isNull(node) || node.getValue().equals(value)) return node;
        if(node.getValue() > value) return recursiveDepthSearch(node.getLeft(), value);
        return recursiveDepthSearch(node.getRight(), value);
    }

    public BinaryTreeNode nonRecursiveDepthSearch(Integer value){
        Stack<BinaryTreeNode> nodeStack = new Stack<>();
        nodeStack.push(root);

        while(!nodeStack.isEmpty()){
            BinaryTreeNode currentNode = nodeStack.pop();
            if(isNull(currentNode)) continue;
            if(currentNode.getValue().equals(value)) return currentNode;
            nodeStack.push(currentNode.getLeft());
            nodeStack.push(currentNode.getRight());
        }
        return null;
    }

    public BinaryTreeNode nonRecursiveBreadthSearch(Integer value){
        Queue<BinaryTreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        while(!nodeQueue.isEmpty()){
            BinaryTreeNode currentNode = nodeQueue.poll();
            if(isNull(currentNode)) continue;;
            if(currentNode.getValue().equals(value)) return currentNode;
            nodeQueue.offer(currentNode.getLeft());
            nodeQueue.offer(currentNode.getRight());
        }
        return null;
    }
}
