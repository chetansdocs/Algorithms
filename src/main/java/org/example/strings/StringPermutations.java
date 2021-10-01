package org.example.strings;

public class StringPermutations{

    private static void printPermutations(String inputString, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            System.out.println(inputString);
        } else {
            for(int i = startIndex; i <= endIndex; i++) {
                String modifiedStr = swapPositions(inputString, startIndex, i);
                printPermutations(modifiedStr, startIndex + 1, endIndex);
                inputString = swapPositions(modifiedStr, startIndex, i);
            }
        }
    }

    private static String swapPositions(String str, int index1, int index2) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(index1, str.charAt(index2));
        sb.setCharAt(index2, str.charAt(index1));
        return sb.toString();
    }

    public static void main(String[] args) {
        printPermutations("ABCD",0, 3);
    }
}
