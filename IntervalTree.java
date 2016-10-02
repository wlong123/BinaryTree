import java.util.Iterator;
/**
	Interval Tree Class
	@version 10/1/16
	@author Will Long
*/
public class IntervalTree<E extends Comparable<E>>
{
	
	/**interval of that node. contains two numbers*/
	protected Object[] interval;
	
	/**node to the left of the root*/
	protected IntervalTree<E> left;
	
	/**node to the right of the root*/
	protected IntervalTree<E> right;
	
	/**
	constructor that takes in a value and two interval trees
	@param i array that is going to be the interval of the tree
	@param l binary tree that is going to be set to left
	@param r binary tree that is going to be set to right
	*/
	public IntervalTree(Object[] i, IntervalTree<E> l, IntervalTree<E> r)
	{
		interval = new Object[2];
		interval[0] = i[0];
		interval[1] = i[1];
		left = l;
		right = r;
	}
	
	/**
	constructor that only takes in an interval
	@param i array that is going to be the interval of the tree
	*/
	public IntervalTree(Object[] i)
	{
	//throw exception if i is not length 2 and if i is not an interval
		interval = new Object[2];
		interval[0] = i[0];
		interval[1] = i[1];
		left = null;
		right = null;
	}
	
	/**
	default constructor 
	*/
	public IntervalTree()
	{
		interval = null;
		left = null;
		right = null;
	}
	
	/**
	accessor for the field left
	@return IntervalTree<E> tree to the left of the root
	*/
	public IntervalTree<E> left()
	{
		return left;
	}
	
	/**
	accessor for the field right
	@return IntervalTree<E> tree to the right of the root
	*/
	public IntervalTree<E> right()
	{
		return right;
	}
	
	/**
	accessor for interval
	@return Object[] the interval of the node
	*/
	public Object[] interval()
	{
		return interval;
	}
	
	/**
	modifier for the field interval
	@param i array containing the new interval
	*/
	public void setInterval(Object[] i)
	{
		interval[0] = i[0];
		interval[1] = i[1];
	}
	
	/**
	modifier for the field left
	@param node new value for the field left
	*/
	public void setLeft(IntervalTree<E> node)
	{
		left = node;
	}
	
	/**
	modifier for the field right
	@param node new value for the field right
	*/
	public void setRight(IntervalTree<E> node)
	{
		right = node;
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
	returns the size of the interval tree
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
	returns string representation of the interval tree
	@return String string representation of the interval tree
	*/
	public String toString()
	{
		String s = "";
		if(interval == null)
			return "";
		if(isLeaf())
			s += "[" + interval[0] + ", " + interval[1] + "]";
		else if((left != null) && (right != null)) //has a left and a right branch
				s += "[" + interval[0].toString() + ", " + interval[1].toString() + "]" + "(" + left.toString() + "," + right.toString() + ")";
		else if(left != null)
				s += "[" + interval[0].toString() + ", " + interval[1].toString() + "]" + "," + "(" + left.toString() + ")";
		else if(right != null)
				s += interval[0].toString() + ", " + interval[1].toString() + "(" + right.toString() + ")";
		return s;
	}

	/**
	returns the height of the interval tree
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
	/*

	public void setMaxValue()
	{
		if(isLeaf())
			maxValue = (E) interval[1];
		if((left() != null) && (left.maxValue().compareTo(maxValue) > 0))
			maxValue = left.maxValue();
		if((right() != null) && (right.maxValue().compareTo(maxValue) > 0))
			maxValue = right.maxValue();
	}
	*
	/*
	public Object[][] overLappingIntervalSearch(Object[] inter)
	{
		Object[][] output = new Object[][2];
	
		if(interval == null)
			return null;
		//checks interval of root for overlaps
		if((interval[0].compareTo(inter[1]) <= 0) && (inter[0].compareTo(interval[1]) <= 0))
			output[0] = interval();
		//checks left child for overlapping intervals
		if((left != null) && (left.interval()[1].compareTo(inter[0]) <= 0))
			return left.overLappingIntervalSearch(inter);
		//checks right child for overlapping intervals
		else if((right != null) && (right.interval()[1].compareTo(inter[0]) <= 0))
		{
			return right.overLappingIntervalSearch(inter);
		}
		else
		{
			return output
		}
	}

	
	public int compare(int i, Object obj)
	{
		return this.compareTo(obj);
	}
   */
}