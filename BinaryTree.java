public class BinaryTree<E>
{
	protected E value;
	protected BinaryTree<E> left;
	protected BinaryTree<E> right;
	
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}
	
	public BinaryTree<E> left()
	{
		return left;
	}
	
	public BinaryTree<E> right()
	{
		return right;
	}
	
	public E value()
	{
		return value;
	}
	
	public void setLeft(BinaryTree<E> node)
	{
		left = node;
	}
	
	public void setRight(BinaryTree<E> node)
	{
		right = node;
	}
	
	public void setValue(E val)
	{
		value = val;
	}
	
	public boolean isLeaf()
	{
		if((left == null) && (right == null))
			return true;
		return false;
	}
	
	public int size()
	{
		if(isLeaf())
			return 1;
		if((left != null) && (right != null))
			return 1 + left().size() + right.size();
		if(right != null)
			return 1 + right.size();
		if(left != null)
			return 1 + left.size();
		return 0;
	}
/**
	//public Iterator<E> preorderIterator()
		//root
		//left
		//right
	public Iterator<E> inorderIterator()
	{
		//left
		//root
		//right
		
	}
	//public Iterator<E> postorderIterator()
		//left
		//right
		//root
*/	
	public String toString()
	{
		String s = "";
		if(value == null)
			return "";
		if((left != null) && (right != null))
		{
			if(s.contains(value.toString()))
				s += "\n" + left().value() + "  " + right().value() + left.toString() + right.toString();
			else
			{
				s += value.toString() + "\n" + left().value() + "  " + right().value() + left.toString() + right.toString();
			}
		}
		else if(left != null)
			if(s.contains(value.toString()))
				s += "\n" + left().value() + left.toString();
			else
			{
				s += value.toString() + "\n" + left().value() + left.toString();
			}
		else if(right != null)
			if(s.contains(value.toString()))
				s += "\n" + right().value() + right.toString();
			else
			{
				s += value.toString() + "\n" + right().value() + right.toString();
			}
		return s;
	}

	public int height()
	{
		if(isLeaf())
			return 0;
		if((left != null) && (right != null))
			return 1 + left().height() + right.height();
		if(right != null)
			return 1 + right.height();
		if(left != null)
			return 1 + left.height();
		return 0;
	}
	
	public boolean isFull()
	{
		if(isLeaf())
			return true;
		if((left == null) || (right == null))
			return false;
		return (left.isFull()) && (right().isFull()) && (right.height() == left.height());
	}
	
	public boolean isComplete()
	{
		if(isLeaf())
			return true;
		if((left == null) && (right != null))
			return false;
		if((left != null) && (right != null))
			return (left().isComplete()) && (right().isComplete());
		if(left != null)
			return left().isComplete();
		if(right != null)
			return right().isComplete();
		throw new Error("fatal error");
	}
	
	public boolean isBalanced()
	{
		if(isLeaf()) 
			return true;
		if((left != null) && (right == null) && (left.height() <= 1))
			return true;
		if((right != null) && (left == null) && (right.height() <= 1))
			return true;
		if((left != null) && (right != null) && (Math.abs(right.height() - left.height()) <= 1))
			return (left.isBalanced()) && (right.isBalanced());
		return false;
	}
	
}