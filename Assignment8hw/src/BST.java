
import java.util.*;

public class BST<T extends Comparable<T>>
{
	// A Java implementation of BST
	// T is a Java generic type

	private Node<T> root;
	private Comparator<T> comparator;

	public BST()// constructor
	{
		root = null;
		comparator = null;
	}

	public BST(Comparator<T> comp) {
		root = null;
		comparator = comp;
	}

	private int compare(T x, T y) {
		if (comparator == null) {
			return x.compareTo(y);
		} else
			return comparator.compare(x, y);
	}

	public void insert(T toInsert)// Insert a value into the tree
	{
		root = insert(root, toInsert);
	}

	private Node insert(Node<T> p, T toInsert) {
		if (p == null)
			return new Node(toInsert);

		if (compare(toInsert, p.data) == 0)
			return p;

		if (compare(toInsert, p.data) < 0)
			// If the value to insert is less than that of root, insert to the left subtree
			p.left = insert(p.left, toInsert);
		else
			p.right = insert(p.right, toInsert);

		return p;
	}

	public boolean search(T toSearch)// Search for a value in the tree
	{	
		return search(root, toSearch);
	}

	private boolean search(Node<T> p, T toSearch) {
		// Complete this method to search for a value "toSearch" in the tree rooted at Node p
		// Note: Follow the pseudocode of search() in slides. 
		// Note: You may also want to read existing methods such as insert() in the BST class to learn how to code with BST nodes.
			
			//checks to see if the current node has a value
			if(p.data != null)
			{
				if(compare(toSearch, p.data) == 0)
					return true;
				
				else 
				{
					//searches to the left
					if(compare(toSearch, p.data) < 0 && p.left != null)
						return search(p.left, toSearch);
					//searches to the right
					else if(p.right != null)
						return search(p.right, toSearch);
				}//else
			}//if
			return false;

	}



	public void preOrderTraversal() {
		preOrderHelper(root);
	}

	private void preOrderHelper(Node<T> r) {
		if (r != null) {
			System.out.print(r.data + " ");
			preOrderHelper(r.left);
			preOrderHelper(r.right);
		}
	}

	public void inOrderTraversal() {
		// Complete this method to traverse the tree in-order
		inOrderhelper(root);
		
	}
	
	private void  inOrderhelper(Node<T> r)
	{
		if(r == null)
			return;
		
		//recursive call to the left child
		inOrderhelper(r.left);
		
		System.out.print(r.data+", ");
		
		//recursive call to the right child
		inOrderhelper(r.right);
		
	}

	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(Node p) {
		if (p == null)
			return 0;
		else if (p.left == null && p.right == null)
			return 1;
		else
			return countLeaves(p.left) + countLeaves(p.right);
	}

	public int size() {
		// Complete this method to return the size of the binary search tree
		// Size of a tree: the number of nodes in the tree
	
		return sizeHelper(root);
		
	}
	
	private int sizeHelper(Node<T> r)
	{
	
		if(r == null)
			return 0;
		//1 is the node current node
		//we recurr on the left side of the binary tree and add up all
		//values on the left
		//we do the same for the right
		//finally we add up the size of the left, right and the current node
		int total = 1 + sizeHelper(r.left) + sizeHelper(r.right);
		return total;

	}//sizeHelper

	private class Node<T> {
		private T data;
		private Node<T> left, right;

		public Node(T data, Node l, Node r) // constructor
		{
			left = l;
			right = r;
			this.data = data;
		}

		public Node(T data) {
			this(data, null, null);
		}

	} // end of Node




	public static void main(String[] args) {
		// example code to create a tree and print the tree inorder
		Integer[] a = { 4, 5, 2, 7, 1 };
		BST bst = new BST();
		for (Integer n : a)
			bst.insert(n);
		bst.inOrderTraversal();
		// the output should be 1, 2, 4, 5, 7
		System.out.println();
		System.out.println("The size of the tree is " + bst.size());
		// the output should be 5
		System.out.println("Does 5 exist in the tree?  " + bst.search(5));
		// the output should be true
		System.out.println("Does 10 exist in the tree?  " + bst.search(10));
		// the output should be false

	}

}// end of BST
