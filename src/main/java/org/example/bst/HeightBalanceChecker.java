package org.example.bst;

import java.util.Scanner;

public class HeightBalanceChecker {
    public static boolean isHeightBalanced(BSTOperations.TreeNode treeNode) {
        if(treeNode == null) {
            return true;
        }
        int leftHeight = getHeight(treeNode.left);
        int rightHeight = getHeight(treeNode.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isHeightBalanced(treeNode.left) && isHeightBalanced(treeNode.right);
    }

    private static int getHeight(BSTOperations.TreeNode treeNode) {
        if(treeNode == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(treeNode.left), getHeight(treeNode.right));
    }

    public static void main(String[] args) {
        Scanner sysInput = new Scanner(System.in);
        System.out.println("Enter number of elements in the tree: ");
        int numberOfElements = sysInput.nextInt();
        System.out.println("Enter elements in the tree: ");
        BSTOperations bstOperations = new BSTOperations();
        for(int counter = 0; counter < numberOfElements; counter++) {
            int currentValue = sysInput.nextInt();
            bstOperations.setRoot(bstOperations.insertElement(bstOperations.getRoot(), currentValue));
        }

        // Inorder Traversal
        System.out.println("Inorder traversal");
        bstOperations.inorder(bstOperations.getRoot());

        System.out.println("Height of the tree " + getHeight(bstOperations.getRoot()));
        System.out.println("Is height balanced tree " + isHeightBalanced(bstOperations.getRoot()));
    }
}
