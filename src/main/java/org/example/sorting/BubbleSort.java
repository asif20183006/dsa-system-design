package org.example.sorting;

public class BubbleSort {

    // put largest element at last by adjacent swapping
    public static void bubbleSort(int []arr, int n) {
        for(int i = n-1; i>=0; i--) {
            boolean swap = false;

            for(int j=0; j<=i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap=true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int []arr = new int[]{23,15,22,13,6};

        bubbleSort(arr, 5);

        for(int i: arr) {
            System.out.println(i);
        }
    }
}
