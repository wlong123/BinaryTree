import java.util.Iterator;
import java.util.NoSuchElementException;
public class preorderIterator<E> implements iterator<E>
{
	private BinaryTree<E> curr;
	
	public preorderIterator(BinaryTree<E> head)
	{
		head = curr;
	}
	
	public boolean hasNext()
	{
		return curr != null;
	}
	
	public E next()
	{
		if(hasNext() == false)
			throw new NoSuchElementException("no more items left in the linked list");
		E output = curr.value();
		if(curr.left() != null)
			
	}
}