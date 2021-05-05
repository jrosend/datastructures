package br.com.study.datastructure.linkedlist;

import java.util.Objects;

import static java.util.Objects.isNull;

public class LinkedList {
    private LinkedListNode firstNode;
    private LinkedListNode lastNode;
    private int size = 0;

    public LinkedListNode add(Integer value){
        LinkedListNode newNode = new LinkedListNode(value);
        if (isNull(firstNode)){
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
        }

        lastNode = newNode;

        size++;
        return newNode;
    }

    public void reverse(){
        if(size == 0) return;
        swap(null, firstNode);

        LinkedListNode tempNode = firstNode;
        firstNode = lastNode;
        lastNode = tempNode;
    }

    private void swap(LinkedListNode current, LinkedListNode next){
        if(isNull(next)) return;
        swap(next, next.getNext());
        next.setNext(current);
    }

    public static LinkedList fromArray(Integer[] array){
        LinkedList list = new LinkedList();
        if(array.length == 0) return list;

        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    public Integer[] toArray(){
        Integer[] array = new Integer[size];
        if(size == 0) return array;

        LinkedListNode currentNode = new LinkedListNode(null);
        currentNode.setNext(firstNode);
        int i = 0;
        while(Objects.nonNull(currentNode.getNext())){
            currentNode = currentNode.getNext();
            array[i] = currentNode.getValue();
            i++;
        }
        return array;
    }



}
