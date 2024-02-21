/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arraylistwithiterator;
// package listtest;

import java.util.*;

// import queuetest.LinkedQueue;

/**
 *
 * @author kmehta
 */

//  interface ListInterface<T>
//  {
//     /** Adds a new entry to the end of this list.
//         Entries currently in the list are unaffected.
//         The list's size is increased by 1.
//         @param newEntry  The object to be added as a new entry. */
//     public void add(T newEntry);
    
//     /** Adds a new entry at a specified position within this list.
//         Entries originally at and above the specified position
//         are at the next higher position within the list.
//         The list's size is increased by 1.
//         @param newPosition  An integer that specifies the desired
//                             position of the new entry.
//         @param newEntry     The object to be added as a new entry.
//         @throws  IndexOutOfBoundsException if either
//                  newPosition < 1 or newPosition > getLength() + 1. */
//     public void add(int newPosition, T newEntry);
    
//     /** Removes the entry at a given position from this list.
//         Entries originally at positions higher than the given
//         position are at the next lower position within the list,
//         and the list's size is decreased by 1.
//         @param givenPosition  An integer that indicates the position of
//                               the entry to be removed.
//         @return  A reference to the removed entry.
//         @throws  IndexOutOfBoundsException if either 
//                  givenPosition < 1 or givenPosition > getLength(). */
//     public T remove(int givenPosition);
    
//     /** Removes all entries from this list. */
//     public void clear();
    
//     /** Replaces the entry at a given position in this list.
//         @param givenPosition  An integer that indicates the position of
//                               the entry to be replaced.
//         @param newEntry  The object that will replace the entry at the
//                          position givenPosition.
//         @return  The original entry that was replaced.
//         @throws  IndexOutOfBoundsException if either
//                  givenPosition < 1 or givenPosition > getLength(). */
//     public T replace(int givenPosition, T newEntry);
    
//     /** Retrieves the entry at a given position in this list.
//         @param givenPosition  An integer that indicates the position of
//                               the desired entry.
//         @return  A reference to the indicated entry.
//         @throws  IndexOutOfBoundsException if either
//                  givenPosition < 1 or givenPosition > getLength(). */
//     public T getEntry(int givenPosition);
    
//     /** Retrieves all entries that are in this list in the order in which
//         they occur in the list.
//         @return  A newly allocated array of all the entries in the list.
//                  If the list is empty, the returned array is empty. */
//     public T[] toArray();
    
//     /** Sees whether this list contains a given entry.
//         @param anEntry  The object that is the desired entry.
//         @return  True if the list contains anEntry, or false if not. */
//     public boolean contains(T anEntry);
    
//     /** Gets the length of this list.
//         @return  The integer number of entries currently in the list. */
//     public int getLength();
        
//     /** Sees whether this list is empty.
//         @return  True if the list is empty, or false if not. */
//     public boolean isEmpty();
//  }

public class MyLList < E extends Comparable < ? super E> > implements ListInterface<E> {
 
    private boolean integrityOK;
    private ListNode firstNode; // reference to first node of the list
    private ListNode lastNode; // reference to last node of the list
    private int numberOfEntries; // number of entries in list
    
    // constructor
    public MyLList() {
        clear ();
    } // end default constructor

    // clear list. Set firstNode to NULL
    public final void clear () {
        
        integrityOK = false;
        
        firstNode = null;
        lastNode = null;
        numberOfEntries = 0;
        
        integrityOK = true;
    } // end clear    

    private void checkIntegrity() {
        
        if(!integrityOK)
            throw new SecurityException("Corrupt Linked List.. cannot continue..");
        
    }// end checkIntegorty
        
    public boolean isEmpty() {

        return (firstNode == null);

    } // end isEmpty
    
    public int getLength() {
        return numberOfEntries;
    }
    
    public boolean contains(E anEntry) {

        checkIntegrity();
        ListNode fn = firstNode;
        
        if(fn == null) return false;
        else if(fn.getData().equals(anEntry)) return true;
        else {
            do {
                fn = fn.next;
                if(anEntry.equals(fn.getData())) return true;
            } while (fn.next != null);
        }
        return false;
    }
    
    /*
    public void printAll() {
        
        E[] arr = this.toArray();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public String toArray() {
       
        boolean done = false;
        if(firstNode == null) return null;
        
        String outputStr = "[";

        int count = 0;
        ListNode currentNode = firstNode;
        
        do {
            outputStr += currentNode.getData().toString();
            count++;
            if(currentNode.next == null)
                done = true;
            else currentNode = currentNode.next;
        } while (!done);
        
        return outputStr += "]";
        
    }// end toArray
    
    */
    
    public void printAll() {
        
        Comparable[] arr = this.toArray();
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    
    public E[] toArray() {
        
        if(firstNode == null) return null;

        E[] arr = (E[])new Comparable[numberOfEntries];

        int count = 0;
        ListNode currentNode = firstNode;
        
        do {
            arr[count] = currentNode.getData();
            count++;
            if(currentNode.next == null) {
                break;
            }
            currentNode = currentNode.next;
        } while (!(currentNode.equals(lastNode)));
        
        arr[count] = lastNode.getData();
        return arr;
        
    }// end toArray
    
    
    private ListNode getNodeAt(int givenPosition) {
        
        checkIntegrity();
        // use temporary node currentNode to traverse
        // list starting at firstNode
        ListNode currentNode = firstNode;
        // traverse the list to locate the desired node
        for (int counter = 1 ; counter < givenPosition ; counter++) {
            currentNode = currentNode.next;
        }
        
        // currentList now refers to node at givenPosition
        return currentNode;
    } // end getNodeAt

    public E getEntry(int i) {
        
        Comparable[] arr = this.toArray();
        
        E element = null;
        if((i > 0) && (i < arr.length)) {
            element = (E) arr[i - 1];
        }

        return element;

    } // end getEntry    
 
    public E replace(int position, E anEntry) {

        checkIntegrity();
        boolean success = false;
        
        if (!((position >= 1) && (position <= numberOfEntries))) {
            return null;
        } else {
        
            ListNode theNode = this.getNodeAt(position - 1);
            theNode.setData(anEntry);
            success = true;
        }
        
        return anEntry;

    } // end replace    

    
    public E remove(int position) {

        checkIntegrity();
        
        E result = null; // return value
        
        if ((position >= 1) && (position <= numberOfEntries)) {
            if (position == 1) { // case 1: first node, remove first entry
                result = firstNode.data; // save entry to be removed
                firstNode = firstNode.next;
            } else { // case 2: not first node
                ListNode nodeBefore = getNodeAt(position - 1);
                ListNode nodeToRemove = nodeBefore.next;
                ListNode nodeAfter = nodeToRemove.next;
                nodeBefore.next = nodeAfter; // disconnect the node to be removed
                result = nodeToRemove.getData(); // save entry to be removed
            } // end if
            
            numberOfEntries --;

        } else {
         
            System.out.println(position + ": is out of range of the list with size: " + numberOfEntries);
            
        }// end if
        
        return result; // return removed entry, or

    } // end remove(int i)  

    
    public ListInterface<E> getAllLessThan(Comparable<E> elementToCompare)  {
        
        ListInterface<E> resultList = new MyLList<>();
        ListNode currentNode = firstNode;
        boolean done = false;
        
        do { 
            E currentElement = currentNode.getData();        
            if (elementToCompare.compareTo(currentElement) > 0) 
                resultList.add(currentElement);
            if(currentNode.getNextNode() == null)
                done = true;
            currentNode = currentNode.getNextNode();
        } while (!done);
        
        return resultList;
    
    } // end getAllLessThan     
    
    
    /** add an existing entry of this list.
       The list size is increased by 1.
       @param anEntry  The object to be added as a new entry. */      
    public void add(E anEntry) {

        checkIntegrity();
        
        // get new node to hold newEntry
        ListNode newNode = new ListNode (anEntry);

        // adding to empty list
        if (isEmpty ()) {
            firstNode = newNode;
        }
        
        //add to non-empty list
        else {
            ListNode lastNode = getNodeAt (numberOfEntries);
            lastNode.next = newNode; // make last node reference new node
        } // end if
        lastNode = newNode;
        numberOfEntries ++;        
    }
    
    public void add(int insertPosition, E anEntry) {
        
        ListNode nodeBefore, nodeAfter;
        
        checkIntegrity();
        
        boolean isSuccessful = true;
        if ((insertPosition >= 1) && (insertPosition <= numberOfEntries + 1)){
            // get new node to hold newEntry
            ListNode newNode = new ListNode (anEntry);
            if (isEmpty () || (insertPosition == 1)) { // empty or 1st position
                newNode.next = firstNode;
                firstNode = newNode;
                lastNode = newNode;
            } else {// not empty and newPosition > 1
                nodeBefore = getNodeAt (insertPosition - 1);
                
                //if insert point was after last node
                if(nodeBefore.next == null) {
                    nodeBefore.next = newNode;
                    newNode.next = null;
                    lastNode = newNode;
                // if insert point was somewhere in the middle of the list//
                } else {
                    nodeAfter = nodeBefore.next;
                    newNode.next = nodeAfter;
                    nodeBefore.next = newNode;
                    lastNode = nodeAfter;
                }
            } // end if

            numberOfEntries ++;
        } else isSuccessful = false;
            
        // return isSuccessful;
    }
    
     public void printLinkedList() {

        int nodeCount = 1;
        ListNode currentNode = firstNode;
        E data = (E)currentNode.getData();   

         System.out.println("Node[1]: " + data);
        
        while( (currentNode.getNextNode() != null) ) {

            currentNode = currentNode.getNextNode();
            data = (E)currentNode.getData();
            System.out.println("Node[" + (++nodeCount) + "]: " + data);

        } 
     }
    

    
/** 
 *
 * @author kmehta
 */    
    public class ListNode {
        
        public E data; // entry in queue
        public ListNode next; // link to next node

        public ListNode(E anEntry) {
            this(anEntry, null);
        }
        
        public ListNode(E anEntry, ListNode n){
            this.data = anEntry;
            this.next = n;        
        }
        
        public E getData() {
            return data;
        }
        
        public ListNode getNextNode() {
            return this.next;
        }
        
        public void setNextNode(ListNode anEntry) {
            this.next = anEntry;
        }
        
        public void setData(E anEntry) {
            this.data = anEntry;
        }
  
    } // end QueueNode    
    

public Iterator<E> getIterator() {
    return new LinkedListIterator();
}
private class LinkedListIterator implements Iterator<E> {
    private ListNode currentNode;

    public LinkedListIterator() {
        currentNode = firstNode;
    }

    @Override
    public boolean hasNext() {
        return currentNode != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E data = currentNode.getData();
        currentNode = currentNode.getNextNode();
        return data;
    }
}

    
}

