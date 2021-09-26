package org.example.bst;

import java.util.Scanner;

public class BSTOperations {
     class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value) {
            this.value = value;
        }
    }

    private TreeNode root;
    public TreeNode getRoot() {
        return root;
    }
    public void setRoot(TreeNode root) {
        this.root = root;
    }

    /**
     * Insert element to the BST
     * @param rootNode {@link TreeNode}
     * @param value {@link Integer} Value to be inserted
     * @return Root of the tree
     */
    public TreeNode insertElement(TreeNode rootNode, int value) {
        if(rootNode == null) {
            rootNode = new TreeNode(value);
            return rootNode;
        }
        if(rootNode.value > value) {
            rootNode.left = insertElement(rootNode.left, value);
        } else if(rootNode.value < value) {
            rootNode.right = insertElement(rootNode.right, value);
        }
        return rootNode;
    }

    /**
     * Inorder traversal of the binary tree
     * @param root Root node
     */
    void inorder(TreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.value);
            inorder(root.right);
        }
    }


    public static void main(String[] args) {
        Scanner sysInput = new Scanner(System.in);
        System.out.println("Enter number of elements in the tree: ");
        int numberOfElements = sysInput.nextInt();
        System.out.println("Enter elements in the tree: ");
        BSTOperations bstOperations = new BSTOperations();
        for(int counter = 0; counter < numberOfElements; counter++) {
            int currentValue = sysInput.nextInt();
            bstOperations.root = bstOperations.insertElement(bstOperations.getRoot(), currentValue);
        }

        // Inorder Traversal
        System.out.println("Inorder traversal");
        bstOperations.inorder(bstOperations.getRoot());
    }
}
