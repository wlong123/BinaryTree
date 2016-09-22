import java.util.Iterator;
/**
	Binary Tree Class
	@version 12/18/15
	@author Will Long
*/
public class IntervalTree<E extends Comparable<E>>
//implements Iterable<E>, Comparable<E>
{
	/**value of max value of that section of the binary tree*/
	protected E maxValue;
	
	/**interval of that node. contains two numbers*/
	protected Object[] interval;
	
	/**node to the left of the root*/
	protected IntervalTree<E> left;
	
	/**node to the right of the root*/
	protected IntervalTree<E> right;
	
	/**
	constructor that takes in a value and two binary trees
	@param v item that is going to be the root of the tree
	@param l binary tree that is going to be set to left
	@param r binary tree that is going to be set to right
	*/
	public IntervalTree(Object[] i, IntervalTree<E> l, IntervalTree<E> r)
	{
	//throw exception if i is not length 2 and if i is not an interval
		interval = new Object[2];
		interval[0] = i[0];
		interval[1] = i[1];
		left = l;
		right = r;
		setMaxValue();
	}
	
	/**
	constructor that only takes in an interval
	@param v item that is going to be the root of the tree
	*/
	public IntervalTree(Object[] i)
	{
	//throw exception if i is not length 2 and if i is not an interval
		interval = new Object[2];
		interval[0] = i[0];
		interval[1] = i[1];
		setMaxValue();
	}
	
	/**
	default constructor 
	*/
	public IntervalTree()
	{
		maxValue = null;
		interval = null;
		left = null;
		right = null;
	}
	
	/**
	accessor for the field left
	@return BinaryTree<E> tree to the left of the root
	*/
	public IntervalTree<E> left()
	{
		return left;
	}
	
	/**
	accessor for the field right
	@return BinaryTree<E> tree to the right of the root
	*/
	public IntervalTree<E> right()
	{
		return right;
	}
	
	/**
	accessor for the field value
	@return E value of the root
	*/
	public E maxValue()
	{
		return maxValue;
	}
	
	/**
	accessor for interval
	@return E[] the interval of the node
	*/
	public Object[] interval()
	{
		return interval;
	}
	
	/**
	modifier for the field left
	@param node new value for the field left
	*/
	public void setLeft(IntervalTree<E> node)
	{
		left = node;
		setMaxValue();
	}
	
	/**
	modifier for the field right
	@param node new value for the field right
	*/
	public void setRight(IntervalTree<E> node)
	{
		right = node;
		setMaxValue();
	}
	
	/**
	modifier for the field maxValue
	@param val new value for the field maxValue
	*/
	public void setMaxValue(E val)
	{
		maxValue = val;
	}
	
	/**
	returns whether the tree doesn't have any branches
	@return boolean returns true if the tree doesn't have any branches, false if not
	*/
	public boolean isLeaf()
	{
		if((left == null) && (right == null))
			return true;
		return false;
	}
	
	/**
	returns the size of the binary tree
	@return int the size of the tree
	*/
	public int size()
	{
		if(isLeaf())  //size of a leaf is one
			return 1;
		if((left != null) && (right != null))  //has a left and a right branch
			return 1 + left().size() + right.size();
		if(right != null)
			return 1 + right.size();
		if(left != null)
			return 1 + left.size();
		return 0;
	}
	
	/**
	returns a preorder iterator for the binary tree
	@return Iterator<E> preorder iterator for binary tree
	*/
	/*
	public Iterator<E> preorderIterator()
	{
		return new preorderIterator<E>(this);
	}
	*/
	/**
	returns an inorder iterator for the binary tree
	@return Iterator<E> inorder iterator for binary tree
	*/
	/*
	public Iterator<E> inorderIterator()
	{
		return new inorderIterator<E>(this);	
	}
	*/
	/**
	returns a postorder iterator for the binary tree
	@return Iterator<E> postorder iterator for binary tree
	*/
	/*
	public Iterator<E> postorderIterator()
	{
		return new postorderIterator<E>(this);	
	}
	*/
	/**
	returns an iterator for the binary tree
	@return Iterator<E> iterator for binary tree
	*/
	/*
	public Iterator<E> iterator()
	{
		return new inorderIterator<E>(this);
	}
	*/
	/**
	returns string representation of the binary tree
	@return String string representation of the binary tree
	*/
	public String toString()
	{
		String s = "";
		if(interval == null)
			return "";
		if(isLeaf())
			s += "(" + interval[0] + ", " + interval[1] + ")";
		else if((left != null) && (right != null)) //has a left and a right branch
				s += interval[0].toString() + ", " + interval[1].toString() + "(" + left.toString() + "," + right.toString() + ")";
		else if(left != null)
				s += interval[0].toString() + ", " + interval[1].toString() + "(" + left.toString() + ")";
		else if(right != null)
				s += interval[0].toString() + ", " + interval[1].toString() + "(" + right.toString() + ")";
		return s;
	}

	/**
	returns the height of the binary tree
	@return int size of the tree
	*/
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
	
	/**
	returns whether the tree is full or not
	@return boolean returns true if the tree is full, false if not
	*/
	public boolean isFull()
	{
		if(isLeaf())
			return true;
		if((left == null) || (right == null))
			return false;
		return (left.isFull()) && (right().isFull()) && (right.height() == left.height());
	}
	
	/**
	returns whether the tree is complete or not
	@return boolean returns true if the tree is complete, false if not
	*/
	public boolean isComplete()
	{
		if(isLeaf())
			return true;
		if(left == null)
			return false;
		if((right == null) && (left.isLeaf()))
			return true;
		if((left != null) && (right != null) && (left.height() - right.height() == 1))
			return (left.isComplete()) && (right.isFull());
		if((left != null) && (right != null) && (left.height() == right.height()))
			return (left.isFull()) && (right.isComplete());
		return false;
	}
	
	
	/**
	returns whether the tree is balanced or not
	@return boolean returns true if the tree is balanced, false if not
	*/
	public boolean isBalanced()
	{
		if(isLeaf()) 
			return true;
		if((left != null) && (right == null) && (height() <= 1))
			return true;
		if((right != null) && (left == null) && (height() <= 1))
			return true;
		if((left != null) && (right != null) && (Math.abs(right.height() - left.height()) <= 1)) //difference between heights is less than 2
			return (left.isBalanced()) && (right.isBalanced());
		return false;
	}
	
	/**
	returns the max value in the interval tree
	@return int the max value in the interval tree
	*/
	public void setMaxValue()
	{
		if(isLeaf())
			maxValue = (E) interval[1];
		if((left != null) && (left.maxValue().compareTo(maxValue) > 0))
			maxValue = left.maxValue();
		if((right != null) && (right.maxValue().compareTo(maxValue) > 0))
			maxValue = right.maxValue();
	}
	

}