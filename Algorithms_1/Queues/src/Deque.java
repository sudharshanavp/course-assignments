import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
	
	private Node first;
	private Node last;
	private int size = 0;
	
	// Linked List 
	private class Node {
		Item item;
		Node next;
		Node prev;
	}

    // construct an empty deque
    public Deque() {
    	
    }

    // is the deque empty?
    public boolean isEmpty() {
    	return (size == 0);
    }

    // return the number of items on the deque
    public int size() {
    	return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
    	if (item == null) { throw new IllegalArgumentException(); }
    	
    	Node node = new Node();
    	node.item = item;
    	
    	if (first == null) {
    		first = node;
    		last = node;
    	}
    	
    	first.prev = node;
    	node.next = first;
    	first = node;
    	
    }

    // add the item to the back
    public void addLast(Item item) {
    	if (item == null) { throw new IllegalArgumentException(); }
    	
    	Node node = new Node();
    	node.item = item;
    
    	if (last == null) {
    		first = node;
    		last = node;
    	}
    
    	node.prev = last;
    	last.next = node;
    	last = node;
    	
    }

    // remove and return the item from the front
    public Item removeFirst() {
    	if(isEmpty()) { throw new NoSuchElementException(); }
    	
    	Item item = first.item;
    	
    	if (size == 1) {
    		first = null;
    		last = null;
    	}
    	    	
    	first = first.next;
    	first.prev = first.prev.next = null;
    	
    	if (size == 2) {
    		first = last;
    	}
    	
    	size++;
    	return item;
    	
    }

    // remove and return the item from the back
    public Item removeLast() {
    	if(isEmpty()) { throw new NoSuchElementException(); }
    	
    	Item item = last.item;
    	
    	if (size == 1) {
    		first = null;
    		last = null;
    	}
    	    	
    	last.prev.next = last.prev = null;
    	
    	if (size == 2) {
    		last = first;
    	}
    	
    	size++;
    	return item;

    	
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
    	return new DequeIterator();
    }
    
    private class DequeIterator implements Iterator<Item> {

    	private Node current = first;
    	
    	@Override
		public boolean hasNext() { return (current != null); }
		
    	@Override
		public Item next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			
			Item item = current.item;
			current = current.next;
			return item;
		}
		
    	@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
    }

    // unit testing (required)
    public static void main(String[] args) {
    	
    }

}
