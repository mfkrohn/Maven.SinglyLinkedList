package com.zipcodewilmington.singlylinkedlist;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable>{

    private Node master;
    private int size;
    private Node last;

    public SinglyLinkedList() {
        this.master = new Node(null,null);
        this.size = 0;
        this.last = master;
    }

    public void checkSize(int index){
        if(index < -1 || index >=size) {
            throw new IndexOutOfBoundsException("Not valid");
        }
    }

    private Node getNode(Integer index){

        checkSize(index -1);
        Node currentNode = master;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public T getLastItem(){
        return last.item;
    }

    public T getItem(Integer index){
        return getNode(index).item;
    }

    public void add(T thing){

        last.next = new Node(thing,null);
        last = last.next;

        size++;
    }
    public void add(T thing, Integer index){
        getNode(index).next = new Node(thing,getNode(index).next);
        size++;
    }

    public T take(Integer index){
        T dataToTake = getNode(index).item;
        getNode(index-1).next = getNode(index).next;

        size--;

        return dataToTake;
    }

    public void addArray(T[] thingArray){
        for(T thing: thingArray){
            add(thing);
        }
    }

    public boolean contains(T thing){
        Node currentNode = master;

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            if(currentNode.item.equals(thing)){
                return true;
            }
        }

        return false;
    }

    public Integer find(T thing){
        Node currentNode = master;
        Integer indexCount = 0;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
            indexCount++;
            if(currentNode.item.equals(thing)){
                return indexCount;
            }
        }

        return -1;
    }

    public SinglyLinkedList copy(){
        return this;
    }

    public void swapForward(Integer index){


        Node node = getNode(index);
        Node nextNode = node.next;
        node.next = nextNode.next;
        nextNode.next = node;

    }

    public int getSize() {
        return size;
    }

    private class Node{
        T item;
        Node next;

        private Node(T item, Node next){
            this.item = item;
            this.next = next;
        }

    }
}
