package org.example.array;

import java.util.HashMap;
import java.util.Map;

import static org.example.sorting.QuickSort.swap;

public class ArrayMedium {
    public static void sortZeroOneTwo1(int[] nums) {

        // count all the zeros, ones, twos
        // insert into same error


        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;


        for (int i=0; i< nums.length; i++) {
            if(nums[i] == 1) oneCount++;
            if(nums[i] == 2) twoCount++;
            if(nums[i] == 0) zeroCount++;
        }

        int i =0;

        while (i< nums.length && zeroCount > 0) {

            nums[i] = 0;
            i++;
            zeroCount--;
        }
        while (i< nums.length && oneCount > 0) {

            nums[i] = 1;
            i++;
            oneCount--;
        }

        while (i< nums.length && twoCount > 0) {

            nums[i] = 2;
            i++;
            twoCount--;
        }

    }

    public static void sortZeroOneTwoOptimal(int []nums) {

        // all 0s will be 0 to low-1
        // all 1s will be low to mid-1
        // mid to high-1 unsorted
        // all 2s high to n-1 will

        int low=0,mid=0,high=nums.length-1;
        while (mid<=high) {
            if (nums[mid] == 0) {

                swap(nums, low, mid);

                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;

            } else {
                swap(nums, mid, high);
                high--;

            }
        }
    }


    public static int majorityElement(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault+1);
        }

        int ans = 0;

       for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > nums.length/2) {
                ans = entry.getKey();
                break;
            }
        }


        return ans;
    }

    public static int majorityElementOptimal(int []nums) {

        // more's algorithm
        // idea is one number always be greater that half of the size of array
        // so if I will keep one number 1 side and all others numbers one side try to cut
        // majority element then all other element will cut all the non majority element


        int ans = 0;
        int count = 0;

        for (int num: nums) {
            if (count == 0) {
                ans = num;
                count++;
            } else if (num == ans) {
                count++;

            } else {
                count--;
            }
        }

        return ans;

    }

    public static void main(String[] args) {
        int []arr = new int[]{2,2,1,1,1,2,2,1,1,3,3,3,3,3,3,3,3,3,2,2,2,3,3,3,2};
        System.out.println(majorityElementOptimal(arr));

    }
}
