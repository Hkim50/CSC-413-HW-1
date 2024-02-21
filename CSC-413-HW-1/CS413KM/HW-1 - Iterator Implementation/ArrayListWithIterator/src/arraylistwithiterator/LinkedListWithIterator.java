package arraylistwithiterator;

import java.util.Iterator;

public class LinkedListWithIterator<E extends Comparable<? super E>> extends MyLList<E> implements ListWithIteratorInterface<E> {

    @Override
    public Iterator<E> getIterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private ListNode nextNode;
        private MyLList<E>.ListNode firstNode;

        public LinkedListIterator() {
            nextNode = firstNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new java.util.NoSuchElementException();
            E data = nextNode.getData();
            nextNode = nextNode.next;
            return data;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported.");
        }
    }

    @Override
    public Iterator<E> iterator() {
        return getIterator();
    }
}
