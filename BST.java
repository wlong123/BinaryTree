/**
	Binary Search Tree
	@version 1/14/16
	@author Will Long
*/
public class BST<E extends Comparable<E>>
{
	/**root of the binary search tree*/
	private BinaryTree<E> root;
	
	/**
	defalt constructor for binary search tree that sets root to null
	*/
	public BST()
	{
		root = null;
	}
	
	/**
	adds an object to the binary search tree
	@param obj item that is going to be added to the tree
	@return boolean returns true if item was successfully added to the tree
	*/
	public boolean add(E obj)
	{
		if(root == null) //if there isn't anything in the tree, sets object to root
		{
			root = new BinaryTree<E>(obj);
			return true;
		}
		else
		{
			return add(root, obj); //recursive call to add
		}
	}
	
	/**
	add method that takes in a binary tree and an object. Used for recursive call from the other add method
	@param tree Binary Tree
	@param obj object that is going to be added to the tree
	@return boolean true if item was successsfuly added to the tree
	*/
	public boolean add(BinaryTree<E> tree, E obj)
	{
		if(tree.value().equals(obj))  //can't have duplicates in the tree
			return false;
		if(root.value().compareTo(obj) < 0)  //goes right if item is less than value of the tree
		{
			if(tree.right() == null)
			{
				tree.setRight(new BinaryTree<E>(obj));
				return true;
			}
			else
			{
				add(tree.right(), obj);
			}
		}
		else if(root.value().compareTo(obj) > 0)
		{
			if(tree.left() == null)
			{
				tree.setLeft(new BinaryTree<E>(obj));
				return true;
			}
			else
			{
				add(tree.left(), obj);
			}
		}	
		return true;
	}
	
	/**
	finds an item in the binary tree
	@param obj object that is going to be found in the tree
	@return BinaryTree<E> binary tree with the obj as the root
	*/
	public BinaryTree<E> find(E obj)
	{
		if(root.value().equals(obj))
			return root;
		else
		{
			return find(root, obj);
		}
	}
	
	/**
	finds an item in the tree. used as recursive call from the other find method
	@param tree Binary tree
	@param obj object that is going to be found
	@return BinaryTree<E> binary tree with obj as the root
	*/
	public BinaryTree<E> find(BinaryTree<E> tree, E obj)
	{
		if(tree.value().equals(obj))
			return tree;
		if(root.value().compareTo(obj) < 0)
		{
			if(tree.right().value().equals(obj))
					return tree.right();
			else
			{
				find(tree.right(), obj);
			}
		}
		else if(root.value().compareTo(obj) > 0)
		{
				if(tree.left.value().equals(obj))
					return tree.left();
			else
			{
				find(tree.left(), obj);
			}
		}	
		return null;
	}
	
	public String toString()
	{
		String s = root.toString();
		return s;
	}
}