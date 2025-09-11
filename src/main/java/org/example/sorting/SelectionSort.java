package org.example.sorting;

public class SelectionSort {

    // find the minimum and keep it at front

    public static void selectionSort(int []arr, int n) {
        for(int i = 0; i<=n-2; i++) {

            int min = i;

            for(int j =i; j<= n-1; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }


            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

    }

    public static void main(String[] args) {
        int []arr = new int[]{23,15,22,13,6};

        selectionSort(arr, 5);

        for(int i: arr) {
            System.out.println(i);
        }
    }
}