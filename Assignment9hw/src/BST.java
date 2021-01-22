
import java.util.*;

public class BST<T extends Comparable<T>> {
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
		if (p == null)
			return false;
		else if (compare(toSearch, p.data) == 0)
			return true;
		else if (compare(toSearch, p.data) < 0)
			// If the value is less than that of root, search in the left subtree
			return search(p.left, toSearch);
		else
			return search(p.right, toSearch);
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
		inOrderHelper(root);

	}
	
	private void inOrderHelper(Node<T> r) {
		if (r != null) {
			inOrderHelper(r.left);
			System.out.print(r.data + " ");
			inOrderHelper(r.right);
		}
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

	public T kthSmallestElement( Node<T> r,int k) 
	{
		// Complete the method to find the k_th smallest value in a BST
		// Feel free to change the return type, parameters
		if(r == null)
			return null;
		
		//recursive call to the left child
		kthSmallestElement(r.left ,k);
				
		kthSmallestElement(r.right, k--);
		
		return r.data;

	}

	public void k1k2Range(Node<T> temp, T k1, T k2) {
		// Complete the method to find all values in [k1,k2] in a BST
		// Feel free to change the return type, parameters
		
		if(temp != null)
		{
			if(compare(temp.data, k1) >= 0)
				k1k2Range(temp.left, k1, k2);

			if(compare(temp.data, k1) >= 0 && compare(temp.data, k2) <= 0)
				System.out.print(temp.data+",  ");

			
			if(compare(temp.data, k2) <= 0 )
				k1k2Range(temp.right, k1, k2);
		
		}//if
		
		else
			return;
		

	
	}



	public T findmin() 
	{
		// Complete the method to find the minimum node in a BST
		// Feel free to change the return type, parameters
		T min = null;
		//temp ensures the root itself is not midofied 
		Node <T> temp = root;
		
		if(temp.data != null)
		{
			while(temp.left != null)
				temp = temp.left;
			
			min =  temp.data;
		}//if	
		 
		return min;
		
		
	}//findMin 

	public T findmax() 
	{
		// Complete the method to find the maximum node in a BST
		// Feel free to change the return type, parameters
		T max = null;
		//temp ensures the root itself is not midofied 
		Node <T> temp = root;
		if(temp.data != null)
		{
			while(temp.right != null)
				temp = temp.right;
	
			max =  temp.data;
		}//if	
		 
		return max;
	}//findMax

	public static void main(String[] args) {
		// example code to create a tree and print the tree inorder
		Integer[] a = { 4, 5, 2, 7, 1 };
		BST bst = new BST();
		for (Integer n : a)
			bst.insert(n);
		bst.preOrderTraversal();
		System.out.println();
		System.out.println("The 3rd smallest node is " + bst.kthSmallestElement(bst.root, 3));
		// the output should be 4
		
		System.out.println("The smallest node is " + bst.findmin());
		// the output should be 1
		
		System.out.println("The largest node is " + bst.findmax());
		// the output should be 7
		Integer r1 = 2;
		Integer r2 = 5;
		System.out.println(" Values in [2,5] ");
		bst.k1k2Range(bst.root, r1, r2);
		// the output should be 2, 4, 5

	}

}// end of BST
