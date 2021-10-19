package org.example.dynamic;

import java.util.Arrays;

public class CommonSubsequence {

    public static int maxSubSequence(int[][] memoization, char[] str1, char[] str2, int index1, int index2) {
        if (index1 == -1 || index2 == -1) {
            return 0;
        } else if(memoization[index1][index2] != -1) {
            return memoization[index1][index2];
        }
        if (str1[index1] == str2[index2]) {
            memoization[index1][index2]  = 1 + maxSubSequence(memoization, str1, str2, index1 - 1, index2 - 1);
        } else {
            memoization[index1][index2] = Math.max(maxSubSequence(memoization, str1, str2, index1 - 1, index2),
                    maxSubSequence(memoization, str1, str2, index1, index2 - 1));
        }
        return memoization[index1][index2];
    }

    public static void main(String[] args) {
        String input1 = "SubCommonString";
        String input2 = "findSubString";
        int[][] memoization = new int[input1.length()][input2.length()];
        for(int i = 0; i < input1.length(); i++) {
            Arrays.fill(memoization[i], -1);
        }
        System.out.println(maxSubSequence(memoization, input1.toCharArray(), input2.toCharArray(), input1.length() - 1, input2.length() - 1));
    }
}
