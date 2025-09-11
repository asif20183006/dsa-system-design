package org.example.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int []arr = new int[]{23,15,22,13,6};

        int[] ints = mergeSort(arr);

        for(int i: ints) {
            System.out.println(i);
        }

    }

    public static int[] mergeSort(int[] nums) {

        return mergeSort(nums, 0, nums.length-1);
    }

    public static int[] mergeSort(int[] nums, int low, int high) {

        if (low == high) return nums;
        int mid = (low + high)/2;

        mergeSort(nums, low, mid);
        mergeSort(nums, mid+1, high);

        return merge(nums, low, mid, high);


    }

    public static int [] merge(int []nums, int low, int mid, int high) {
        List<Integer> list = new ArrayList<>();

        int left = low;
        int right = mid+1;

        while (left <= mid && right<= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while ((left <= mid)) {
            list.add(nums[left]);
            left++;
        }

        while ((right <= high)) {
            list.add(nums[right]);
            right++;
        }

        for (int i = low; i<= high; i++) {
            nums[i] = list.get(i-low);
        }

        return nums;

    }
}
