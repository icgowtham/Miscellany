import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiamTreeSolution {

private static class Node {
       Node left, right;
       int data;

       Node (int newData) {
           left = right = null;
           data = newData;
       }
}

private static Node insert (Node node, int data) {
       if (node == null){
           node = new Node (data);
       }
       else {
           if (data < node.data) {
               node.left = insert (node.left, data);
           }
           else {
               node.right = insert (node.right, data);
           }
       }
       return (node);
   }

private static Node addRandomElement (Node node, int data, int index) {
       if (node == null){
           node = new Node (data);
       }
       else {
            if (index <= 2) {
               node.left = addRandomElement (node.left, data, index);
           }
           else {
               node.right = addRandomElement (node.right, data, index);
           }

       }
       return (node);
   }

	public static void preOrder (Node root) {
		if (root == null)
			return;

		System.out.print (root.data + " ");
		preOrder (root.left);
		preOrder (root.right);
	}

	public static void postOrder (Node root) {
		if (root == null)
			return;
		postOrder (root.left);
		postOrder (root.right);
		System.out.print (root.data + " ");
	}

	public static void inOrder (Node root) {
		if (root == null)
			return;

		inOrder (root.left);
		System.out.print(root.data + " ");
		inOrder (root.right);
	}

	/* Write your custom functions here */
	static int diameterOfTree(Node root) {
    	if (root == null)
    		return 0;
    	else
    		return Math.max (diameterOfTree (root.left),
    						 Math.max (diameterOfTree (root.right), height (root.left) + height (root.right) + 1));
	}

	public static int height (Node root) {
    	if (root == null)
    		return 0;
    	else
    		return 1 + Math.max (height (root.left), height (root.right));
	}

	public static void main (String[] args) {
		Node root = insert (null, 5);
		insert (root, 10);
		insert (root, 1);
		insert (root, 22);
		insert (root, 8);

		System.out.print ("In-Order traversal: ");
		inOrder (root);
		System.out.print ("\nPre-Order traversal: ");
		preOrder (root);
		System.out.print ("\nPost-Order traversal: ");
		postOrder (root);

		System.out.println ("\n" + diameterOfTree (root));
	}
}