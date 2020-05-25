import edu.princeton.cs.algs4.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] queue;
	private int size;
	
    // construct an empty randomized queue
    public RandomizedQueue() {
    	queue = (Item[]) new Object[2];
    	size = 0;
    }
    
    // Resize array function
    
    private void resize(int capacity) {
    	assert capacity >= size;
    	Item[] temp = (Item[]) new Object[capacity];
    	for (int i = 0; i < size; i++) {
    		temp[i] = queue[i];
		}
    	queue = array;
    }
    
    // is the randomized queue empty?
    public boolean isEmpty() {
    	return (size == 0);
    }

    // return the number of items on the randomized queue
    public int size() {
    	return size;
    }

    // add the item
    public void enqueue(Item item) {
    	if (item == null) { throw new IllegalArgumentException(); }
    	
    	if (size == queue.length)
    		resize(size * 2);
    	queue[size++] = item;    
    }

    // remove and return a random item
    public Item dequeue() {
    	if (isEmpty()) { throw new IllegalArgumentException(); }
    	
    	int randomIndex = (int)(StdRandom.uniform(size));
    	Item item = queue[randomIndex];
    	queue[randomIndex] = queue[size - 1];
    	queue[size - 1] = null;
    	size--;
    	if (size == queue.length/4) {
    		resize(queue.length/2);
    	}
    	return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
    	if (isEmpty()) { throw new IllegalArgumentException(); }
    	
    	int randomIndex = (int)(Math.random()*size);
    	Item item = queue[randomIndex];
    	return item;
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
    	return new RandomQueueIterator();
    }
    
    private class RandomQueueIterator implements Iterator<Item> {

    	private int index;
    	private Item[] randomQueue;
    	
    	public RandomQueueIterator() {
    		randomQueue = (Item[]) new Object[size];
    		for (int i = 0; i < size; i++)
    			randomQueue[i] = queue[i];
    		StdRandom.shuffle(randomQueue);
		}
    	
		@Override
		public boolean hasNext() {
			return index<size;			
		}

		@Override
		public Item next() {
			if (!hasNext()) { throw new NoSuchElementException(); }
			Item current = randomQueue[index];
			index++;
			return current;
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