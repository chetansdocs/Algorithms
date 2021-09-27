package org.example.bst;

import java.util.Scanner;

public class KDistanceNodes {

    private static void printElementKDistance(BSTOperations.TreeNode treeNode, int k) {
        if(treeNode != null) {
            if(k == 0) {
                System.out.println(treeNode.value);
            } else {
                printElementKDistance(treeNode.left, k - 1);
                printElementKDistance(treeNode.right, k - 1);
            }
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
            bstOperations.setRoot(bstOperations.insertElement(bstOperations.getRoot(), currentValue));
        }

        // Inorder Traversal
        System.out.println("Inorder traversal");
        bstOperations.inorder(bstOperations.getRoot());

        // Inorder Traversal
        System.out.println("Print elements at level 2");
        printElementKDistance(bstOperations.getRoot(), 2);
    }
}
