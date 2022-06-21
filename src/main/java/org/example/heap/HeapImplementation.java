package org.example.heap;

import java.util.Arrays;

public class HeapImplementation {
    private int capacity;
    private int[] arr;
    int size;

    public HeapImplementation(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.arr = new int[capacity];
    }

    int leftIndex(int currentIndex) {
        return (2 * currentIndex) + 1;
    }

    int rightIndex(int currentIndex) {
        return (2 * currentIndex) + 2;
    }

    int parentIndex(int currentIndex) {
        return (currentIndex - 1) / 2;
    }

    public void insert(int element) {
        if(this.size < capacity) {
            this.size++;
            arr[size - 1] = element;
            int i = size - 1;
            while( i != 0 && arr[parentIndex(i)] > arr[i]) {
                int j = parentIndex(i);
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i = j;
            }
        }

    }

    public static void main(String[] args) {
        HeapImplementation heapImplementation = new HeapImplementation(20);
        heapImplementation.insert(30);
        heapImplementation.insert(20);
        heapImplementation.insert(15);
        heapImplementation.insert(10);
        Arrays.stream(heapImplementation.arr).forEach(System.out::println);
    }
}
