package org.example.backtracking;

import java.util.Scanner;

public class NQueens {

    /**
     * Check if the current position of element is valid
     * 1. Check if there are elements at the left
     * 2. Check if there are elements diagonally top
     * 3. Check if there are elements diagonally down
     * @return Boolean
     */
    private boolean isValidEntry(int [][] matrix, int row, int col) {
        int rowCounter = 1;
        for(int left = col - 1; left >= 0; left --) {
            if(row - rowCounter >= 0 && matrix[row - rowCounter][left] == 1) {
                return false;
            }
            if(row >= 0 && matrix[row][left] == 1) {
                return false;
            }
            if(row + rowCounter < matrix.length && matrix[row + rowCounter][left] == 1) {
                return false;
            }
            rowCounter++;
        }
        return true;
    }

    /**
     * Backtracking: Undo the position if all the queens cannot be placed
     * @param matrix Input matrix
     * @param col Current column
     * @return Boolean value
     */
    private boolean positionQueen(int[][] matrix, int col) {
        if(col >= matrix.length) {
            return true;
        }
        for(int row = 0; row < matrix.length; row++) {
            if(isValidEntry(matrix, row, col)) {
                matrix[row][col] = 1;
                if(positionQueen(matrix, col + 1)) {
                    return true;
                }
                matrix[row][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sysInput = new Scanner(System.in);
        System.out.println("Enter the dimension of matrix");
        int matrixDimension = sysInput.nextInt();

        int[][] matrixInput = new int[matrixDimension][matrixDimension];

        NQueens nQueens = new NQueens();
        boolean isSuccessful = nQueens.positionQueen(matrixInput, 0);

        if(isSuccessful) {
            for(int i = 0; i < matrixDimension; i++) {
                for(int j = 0; j < matrixDimension; j++) {
                    if(matrixInput[i][j] == 1) {
                        System.out.println("Row=" + i + " Column=" + j);
                    }
                }
            }
        } else {
            System.out.println("N Queens cannot be placed in this dimension");
        }
    }
}
