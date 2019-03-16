package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SinglyLinkedListTest {





    @Test
    public void add() {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        Integer expectedItem = 100;

        testList.add(expectedItem);
        Integer actualItem = testList.getLastItem();
        Assert.assertEquals(expectedItem,actualItem);
    }

    @Test
    public void contains() {
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        Integer expectedItem = 50;

        Assert.assertFalse(testList.contains(50));
        testList.add(expectedItem);

        Assert.assertTrue(testList.contains(50));
    }

    @Test
    public void getNode() {
        SinglyLinkedList<Integer>  testList = new SinglyLinkedList<Integer>();
        testList.addArray(new Integer[]{1,2,3,4,5,6,7});
        Integer expected = 4;

        Integer actual = testList.getItem(4);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getMaster() {
        SinglyLinkedList<Integer>  testList = new SinglyLinkedList<Integer>();
        testList.addArray(new Integer[]{1,2,3,4,5,6,7});

        Integer actual = testList.getItem(0);

        Assert.assertNull(actual);
    }

    @Test
    public void take() {
        SinglyLinkedList<Integer>  testList = new SinglyLinkedList<Integer>();
        testList.addArray(new Integer[]{11,23,37,43,55,63,71});
        Integer indexToTake = 4;
        Integer numberToRemove = testList.getItem(indexToTake);
        Assert.assertTrue(testList.contains(numberToRemove));
        Integer expectedSize = testList.getSize() -1;
        Integer preLast = testList.getLastItem();

        Integer takenNumber = testList.take(indexToTake);
        Integer postSize = testList.getSize();
        Integer postLast = testList.getLastItem();


        Assert.assertFalse(testList.contains(numberToRemove));
        Assert.assertEquals(expectedSize,postSize);
        Assert.assertEquals(preLast,postLast);
        Assert.assertEquals(numberToRemove,takenNumber);
    }

    @Test
    public void addIndex() {
        SinglyLinkedList<Integer>  testList = new SinglyLinkedList<Integer>();
        testList.addArray(new Integer[]{1,2,3,4,5,6,7});
        Integer intToAdd = 90;
        Integer indexToAdd = 5;

        testList.add(intToAdd,indexToAdd);
        Integer actual = testList.getItem(indexToAdd);

        Assert.assertEquals(indexToAdd,actual);
    }

    @Test
    public void find(){
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<>();
        Integer expectedItem = 58;

        Assert.assertFalse(testList.contains(58));
        testList.add(expectedItem);

        Integer expectedIndex = 1;

        Assert.assertEquals(expectedIndex,testList.find(58));
    }

    @Test
    public void swapForward(){
        SinglyLinkedList<Integer>  testList = new SinglyLinkedList<Integer>();
        testList.addArray(new Integer[]{1,2,55,46,5,6,7});
        Integer index = 4;
        Integer expected = testList.getItem(4);


        testList.swapForward(3);

        Assert.assertEquals(expected,testList.getItem(3));
    }


}