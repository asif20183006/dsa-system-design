package org.example.sorting;

public class InsertionSort {

    // pick one element put it on write position
    public static void insertionSort(int []arr, int n) {

        for(int i = 0; i<= n-1; i++) {
            int j = i;
            while (j>0 && arr[j-1] > arr[j]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        int []arr = new int[]{23,15,22,13,6};

        insertionSort(arr, 5);

        for(int i: arr) {
            System.out.println(i);
        }
    }
}
