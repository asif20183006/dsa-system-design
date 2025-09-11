package org.example.sorting;

public class QuickSort {

    // divide and conquer

    public static int[] quickSort(int[] nums) {

        quickSort(nums, 0, nums.length-1);

        return nums;
    }

    public static void quickSort(int arr[], int low, int high) {
        if(low<high) {
            int partition = partition(arr, low, high);

            quickSort(arr, low, partition -1);
            quickSort(arr, partition+1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {

        int pivot = arr[low];

        int i = low;
        int j = high;

        while(i < j) {

            while (arr[i] <= pivot && i<=high-1){
                i++;
            }

            while (arr[j] > pivot && j>=low+1) {
                j--;
            }

            if (i<j) {
                swap(arr, i, j);
            }

        }

        swap(arr, low, j);

        return j;

    }

    public static void swap(int arr[], int i, int j) {

        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int []arr = new int[]{23,15,22,13,6};

        int[] ints = quickSort(arr);

        for(int i: ints) {
            System.out.println(i);
        }
    }
}
